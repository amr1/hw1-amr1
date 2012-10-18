

/* First created by JCasGen Thu Oct 18 18:29:18 EDT 2012 */
package edu.cmu.lti;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** ner
 * Updated by JCasGen Thu Oct 18 19:45:47 EDT 2012
 * XML source: /home/andrew/git/hw1-amr1/hw1-amr1/src/main/java/typeSystemDescriptor.xml
 * @generated */
public class NERAnnotation extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(NERAnnotation.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected NERAnnotation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public NERAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public NERAnnotation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public NERAnnotation(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: Confidence

  /** getter for Confidence - gets 
   * @generated */
  public int getConfidence() {
    if (NERAnnotation_Type.featOkTst && ((NERAnnotation_Type)jcasType).casFeat_Confidence == null)
      jcasType.jcas.throwFeatMissing("Confidence", "edu.cmu.lti.NERAnnotation");
    return jcasType.ll_cas.ll_getIntValue(addr, ((NERAnnotation_Type)jcasType).casFeatCode_Confidence);}
    
  /** setter for Confidence - sets  
   * @generated */
  public void setConfidence(int v) {
    if (NERAnnotation_Type.featOkTst && ((NERAnnotation_Type)jcasType).casFeat_Confidence == null)
      jcasType.jcas.throwFeatMissing("Confidence", "edu.cmu.lti.NERAnnotation");
    jcasType.ll_cas.ll_setIntValue(addr, ((NERAnnotation_Type)jcasType).casFeatCode_Confidence, v);}    
  }

    