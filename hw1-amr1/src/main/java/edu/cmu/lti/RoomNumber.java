

/* First created by JCasGen Sat Oct 06 16:13:10 EDT 2012 */
package edu.cmu.lti;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Sat Oct 06 16:13:28 EDT 2012
 * XML source: /home/andrew/src/class/11791/workspace/hw1-amr1/src/main/java/typeSystemDescriptor.xml
 * @generated */
public class RoomNumber extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(RoomNumber.class);
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
  protected RoomNumber() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public RoomNumber(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public RoomNumber(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public RoomNumber(JCas jcas, int begin, int end) {
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
  //* Feature: building

  /** getter for building - gets 
   * @generated */
  public String getBuilding() {
    if (RoomNumber_Type.featOkTst && ((RoomNumber_Type)jcasType).casFeat_building == null)
      jcasType.jcas.throwFeatMissing("building", "edu.cmu.lti.RoomNumber");
    return jcasType.ll_cas.ll_getStringValue(addr, ((RoomNumber_Type)jcasType).casFeatCode_building);}
    
  /** setter for building - sets  
   * @generated */
  public void setBuilding(String v) {
    if (RoomNumber_Type.featOkTst && ((RoomNumber_Type)jcasType).casFeat_building == null)
      jcasType.jcas.throwFeatMissing("building", "edu.cmu.lti.RoomNumber");
    jcasType.ll_cas.ll_setStringValue(addr, ((RoomNumber_Type)jcasType).casFeatCode_building, v);}    
  }

    