

/* First created by JCasGen Thu Oct 18 19:30:16 EDT 2012 */
package edu.cmu.lti;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** What is the id of the source?
 * Updated by JCasGen Thu Oct 18 22:21:37 EDT 2012
 * XML source: /home/andrew/git/hw1-amr1/hw1-amr1/src/main/java/aeDescriptor.xml
 * @generated */
public class SourceId extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(SourceId.class);
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
  protected SourceId() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public SourceId(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public SourceId(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public SourceId(JCas jcas, int begin, int end) {
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
  //* Feature: Id

  /** getter for Id - gets 
   * @generated */
  public String getId() {
    if (SourceId_Type.featOkTst && ((SourceId_Type)jcasType).casFeat_Id == null)
      jcasType.jcas.throwFeatMissing("Id", "edu.cmu.lti.SourceId");
    return jcasType.ll_cas.ll_getStringValue(addr, ((SourceId_Type)jcasType).casFeatCode_Id);}
    
  /** setter for Id - sets  
   * @generated */
  public void setId(String v) {
    if (SourceId_Type.featOkTst && ((SourceId_Type)jcasType).casFeat_Id == null)
      jcasType.jcas.throwFeatMissing("Id", "edu.cmu.lti.SourceId");
    jcasType.ll_cas.ll_setStringValue(addr, ((SourceId_Type)jcasType).casFeatCode_Id, v);}    
  }

    