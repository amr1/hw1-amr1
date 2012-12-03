/** @author Andrew Rodriguez (amr1)
 * 
 * A Named Entity Recognizer (NER) that directly calls the stanford parser and applies some processing that is specific to the biological domain.
 * 
 */

package edu.cmu.lti;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

public class NERAnnotator extends JCasAnnotator_ImplBase {

  private StanfordCoreNLP pipeline;

  @Override
  public void initialize(UimaContext ctx) throws ResourceInitializationException {
    // setup the stanford parser
    Properties props = new Properties();
    props.put("annotators", "tokenize, ssplit, pos");
    pipeline = new StanfordCoreNLP(props);
  }

  @Override
  public void process(JCas arg0) throws AnalysisEngineProcessException {
    
    String text = arg0.getDocumentText();
    
    Map<Integer, Integer> begin2end = new HashMap<Integer, Integer>();
    Annotation document = new Annotation(text);
    pipeline.annotate(document);
    List<CoreMap> sentences = document.get(SentencesAnnotation.class);
    for (CoreMap sentence : sentences) {
      List<CoreLabel> candidate = new ArrayList<CoreLabel>();
      for (CoreLabel token : sentence.get(TokensAnnotation.class)) {
        String pos = token.get(PartOfSpeechAnnotation.class);
        if (pos.startsWith("NN") || isAcronym(token.originalText()) || likelyBeginning(token.originalText())) {
          candidate.add(token);
        } else if (candidate.size() > 0) {
          int begin = candidate.get(0).beginPosition();
          int end = candidate.get(candidate.size() - 1).endPosition();
          begin2end.put(begin, end);
          candidate.clear();
        }
      }
      if (candidate.size() > 0) {
        int begin = candidate.get(0).beginPosition();
        int end = candidate.get(candidate.size() - 1).endPosition();
        begin2end.put(begin, end);
        candidate.clear();
      }
    }

    NERAnnotation annotation;
    for (Entry<Integer, Integer> entry : begin2end.entrySet()) {
      annotation = new NERAnnotation(arg0);
      annotation.setBegin(entry.getKey());
      annotation.setEnd(entry.getValue());
      annotation.addToIndexes();
    }
    
  }

  String[] likelyWords = new String[] {"chain", "monomer", "codon", "region", "exon", "orf", "cdna", "reporter",
  "gene", "antibody", "complex", "gene", "product", "mrna", "oligomer", "chemokine", "subunit",
  "peptide", "message", "transactivator", "homolog", "binding", "site", "enhancer", "element", "allele", "isoform", "intron", "promoter", "operon"};

  
  private boolean likelyBeginning(String originalText) {
    return Arrays.asList(likelyWords).contains(originalText);
  }

  /** isAcronym allows for the NER to return likely acronyms. */
  private boolean isAcronym(String originalText) {
    
    // all upper case?
    boolean upper = true;
    for (int i=0; i<originalText.length(); i++) {
      char c = originalText.charAt(i);
      if (!Character.isUpperCase(c)) {
        upper = false;
        break;
      }
    }
    
    return upper;
  }
    
}

