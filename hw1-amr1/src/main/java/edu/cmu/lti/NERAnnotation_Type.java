
/* First created by JCasGen Thu Oct 18 18:29:18 EDT 2012 */
package edu.cmu.lti;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** ner
 * Updated by JCasGen Thu Oct 18 19:45:47 EDT 2012
 * @generated */
public class NERAnnotation_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (NERAnnotation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = NERAnnotation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new NERAnnotation(addr, NERAnnotation_Type.this);
  			   NERAnnotation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new NERAnnotation(addr, NERAnnotation_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = NERAnnotation.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.NERAnnotation");
 
  /** @generated */
  final Feature casFeat_Confidence;
  /** @generated */
  final int     casFeatCode_Confidence;
  /** @generated */ 
  public int getConfidence(int addr) {
        if (featOkTst && casFeat_Confidence == null)
      jcas.throwFeatMissing("Confidence", "edu.cmu.lti.NERAnnotation");
    return ll_cas.ll_getIntValue(addr, casFeatCode_Confidence);
  }
  /** @generated */    
  public void setConfidence(int addr, int v) {
        if (featOkTst && casFeat_Confidence == null)
      jcas.throwFeatMissing("Confidence", "edu.cmu.lti.NERAnnotation");
    ll_cas.ll_setIntValue(addr, casFeatCode_Confidence, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public NERAnnotation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_Confidence = jcas.getRequiredFeatureDE(casType, "Confidence", "uima.cas.Integer", featOkTst);
    casFeatCode_Confidence  = (null == casFeat_Confidence) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Confidence).getCode();

  }
}



    