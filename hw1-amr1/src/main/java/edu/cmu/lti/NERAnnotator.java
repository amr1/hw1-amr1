package edu.cmu.lti;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

public class NERAnnotator extends JCasAnnotator_ImplBase {

  @Override
  public void process(JCas arg0) throws AnalysisEngineProcessException {
    
    String docText = arg0.getDocumentText();
    
    NERAnnotation annotation = new NERAnnotation(arg0);
    annotation.setBegin(2);
    annotation.setEnd(5);
    annotation.addToIndexes();
    
    return;
    
  }

}
