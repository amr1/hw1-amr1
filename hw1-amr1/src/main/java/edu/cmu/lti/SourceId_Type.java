
/* First created by JCasGen Thu Oct 18 19:30:16 EDT 2012 */
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

/** What is the id of the source?
 * Updated by JCasGen Thu Oct 18 19:45:47 EDT 2012
 * @generated */
public class SourceId_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (SourceId_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = SourceId_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new SourceId(addr, SourceId_Type.this);
  			   SourceId_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new SourceId(addr, SourceId_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = SourceId.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.SourceId");
 
  /** @generated */
  final Feature casFeat_Id;
  /** @generated */
  final int     casFeatCode_Id;
  /** @generated */ 
  public String getId(int addr) {
        if (featOkTst && casFeat_Id == null)
      jcas.throwFeatMissing("Id", "edu.cmu.lti.SourceId");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Id);
  }
  /** @generated */    
  public void setId(int addr, String v) {
        if (featOkTst && casFeat_Id == null)
      jcas.throwFeatMissing("Id", "edu.cmu.lti.SourceId");
    ll_cas.ll_setStringValue(addr, casFeatCode_Id, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public SourceId_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_Id = jcas.getRequiredFeatureDE(casType, "Id", "uima.cas.String", featOkTst);
    casFeatCode_Id  = (null == casFeat_Id) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Id).getCode();

  }
}



    