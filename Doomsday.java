/**
 * Im a class that takes a file and gives it to class
 * that knows how to copy it in a 2d ArrayList
 * and then i give that array to a class that knows how to
 * calculate if the universe will end or not.
 * Lastly i give the output to the user.
 */

import java.util.ArrayList;

public class Doomsday {

  public static void main(String[] args) {
    ReadFile copyarray = new ReadFile();
    ArrayList<ArrayList<String>> array = copyarray.file_to_2Darray(args[0]);
    Queue floodq = copyarray.getQueue();
    int [] coordinates = copyarray.sizeArr();

    CalcUni univ = new CalcUni(array, floodq, coordinates);
    univ.CreateResults();
    System.out.println(univ.getResult());
    array = univ.getUniView();

    for(ArrayList<String> linew: array){
      for(String elem: linew){
        System.out.print(elem);
      }
      System.out.println();
    }
  }

}
