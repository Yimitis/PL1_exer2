/**
 * I get a file from someone and with fileto2darray i copy it
 * in a 2d ArrayList.
 * I can also return you that array with getArray, the size of
 * that array with sizeArr and a queue containing the matter (+)
 * and antimatter (-)
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
  private ArrayList<ArrayList<String>> array = new ArrayList<ArrayList<String>>() ;
  /* I used my own queue that has made previously in order to test it*/
  private Queue q = new Queue();
  private int i = 0;
  private int j = 0;


  public ArrayList<ArrayList<String>> file_to_2Darray(String fname){
    try{
        ArrayList<String> tmp;
        BufferedReader in = new BufferedReader(new FileReader (fname));
        String [] lineTable;
        String line;

        while((line = in.readLine() )!= null){
          j = line.length();
          lineTable = line.split("(?!^)");
          tmp = new ArrayList<String>();
          for(int k=0; k<j; k++) {
            tmp.add(lineTable[k]);
            //add initiall map of +, - as elements to queue
            if(lineTable[k].equals("+") || lineTable[k].equals("-")){
              q.add(new Node(lineTable[k], null, null, i, k, 0) );
            }
          }
          array.add(tmp);
          i++;
        }
        return array;
    }
    catch(IOException a){
       a.printStackTrace();
       return null;
    }
  }

  public Queue getQueue(){
    return q;
  }

  public int[] sizeArr(){
    int [] tabl = {i,j};
    return tabl;
  }
}
