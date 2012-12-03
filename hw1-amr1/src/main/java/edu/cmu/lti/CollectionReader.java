/** @author Andrew Rodriguez (amr1)
 *  CollectionReader reads in the input to be processed.
 */

package edu.cmu.lti;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;


public class CollectionReader extends CollectionReader_ImplBase {

  private static final String PARAM_INPUT = "InputFile";
  private File inputFile;
  private BufferedReader fileReader;
  private boolean done;
  private String nextLine = null;

  public void initialize() throws ResourceInitializationException {
    inputFile = new File(((String) getConfigParameterValue(PARAM_INPUT)).trim());
    
    try {
      fileReader = new BufferedReader(new FileReader(inputFile));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      done = true;
    }
  }
  
  
  @Override
  public void getNext(CAS arg0) throws IOException, CollectionException {

       String[] tokenized = nextLine.split(" ", 2);
       if (tokenized.length != 2) {
         throw new CollectionException();
       }
       
       JCas jcas;
       try {
         jcas = arg0.getJCas();
       } catch (CASException e) {
         throw new CollectionException(e);
       }

       
       jcas.setDocumentText(tokenized[1]);
       
       SourceId srcInfo = new SourceId(jcas);
       srcInfo.setId(tokenized[0]);
       srcInfo.addToIndexes();

  }

  @Override
  public void close() throws IOException {
    // TODO Auto-generated method stub
    fileReader.close();
  }

  @Override
  public Progress[] getProgress() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean hasNext() throws IOException, CollectionException {
    if (done) {
      return false;
    }
      String line = fileReader.readLine();
      if (null == line) {
        done = true;
        return false;
      }
      nextLine = line;
      return true;
    
  }
}
