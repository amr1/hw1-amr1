/** @author Andrew Rodriguez (amr1)
 *  Outputter spits out the NE recognized in the correct output format.
 */

package edu.cmu.lti;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;

public class Outputter extends CasConsumer_ImplBase {
  private static final String PARAM_OUTPUT = "OutputFile";
  private BufferedWriter fileWriter;
  
  public void initialize() throws ResourceInitializationException {
    File outputFile = new File(((String) getConfigParameterValue(PARAM_OUTPUT)).trim());
    
    try {
      fileWriter = new BufferedWriter(new FileWriter(outputFile));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void processCas(CAS arg0) throws ResourceProcessException {
    
    // get source id
    JCas jcas;
    try {
      jcas = arg0.getJCas();
    } catch (CASException e) {
      throw new ResourceProcessException(e);
    }
   
    FSIterator<Annotation> it = jcas
              .getAnnotationIndex(SourceId.type)
                    .iterator();
    SourceId id = null;
    if (it.hasNext()) {
      id = (SourceId) it.next();
    } else {
      throw new ResourceProcessException();
    }
    
    // get the ner tagging
    it = jcas.getAnnotationIndex(NERAnnotation.type).iterator();
    NERAnnotation ner = null;
    while (it.hasNext()) {
      ner = (NERAnnotation) it.next();
      int begin = ner.getBegin();
      int end = ner.getEnd();
      String document = jcas.getDocumentText();
      String relevant = document.substring(Math.min(document.length(), begin), Math.min(document.length(), end));
      try {
        fileWriter.write(id.getId() + "|" + numNonWhiteSpace(begin, document) + " " + (numNonWhiteSpace(end, document) - 1) + "|" + relevant + "\n");
      } catch (IOException e) {
        throw new ResourceProcessException(e);
      }
    } 
  }


  private int numNonWhiteSpace(int index, String document) {
    
    int total = 0;
    for (int i=0; i<index; i++) {
      if (document.charAt(i) != ' ')
        total++;
    }
    return total;
  }

  public void collectionProcessComplete() throws IOException {
    
    fileWriter.close();
    
  }
  
}
