import java.util.ArrayList;

public class CalcUni{
  private ArrayList<ArrayList<String>> uni;
  private Queue floodq;
  private int i;        //size of array
  private int j;
  private String result = "Not calculated yet";
  private int time = -3;     // the time that universe is destroyed
  private boolean end = false;    //shows if universe has ended or not yet
  private String [] curr_matter_g;

  public CalcUni (ArrayList<ArrayList<String>> cp_arr, Queue q, int [] size){
    uni = cp_arr;
    floodq = q;
    i = size[0];
    j = size[1];
  }

  public void CreateResults(){
    Node elem;

    while(floodq.hasMore()){
      elem = floodq.remove();
      int x = elem.getX();
      int y = elem.getY();
      String matter = elem.getData();
      int t = elem.getTime();
      String [] curr_matter = {"0", "0", "0", "0"};


      // if the nodes time is after the world ended and
      // world ended then return
      if( time == t && end){
        break;
      }


      if(x-1 >= 0){
        //up
        curr_matter[0] = uni.get(x-1).get(y);
      }
      if(x+1 < i){
        //down
        curr_matter[1] = uni.get(x+1).get(y);
      }
      if(y-1 >= 0){
        //left
        curr_matter[2] = uni.get(x).get(y-1);
      }
      if(y+1 < j){
        //right
        curr_matter[3] = uni.get(x).get(y+1);
      }

      curr_matter_g = curr_matter;
      //spread node
      //up
      if(x-1 >= 0 && (!curr_matter[0].equals("X") && !curr_matter[0].equals(matter))){
         expand(0, x-1, y, t, matter);
      }

      //down
      if(x+1 < i && (!curr_matter[1].equals("X") && !curr_matter[1].equals(matter)) ){
         expand(1, x+1, y, t, matter);
      }

      //left
      if(y-1 >= 0 && (!curr_matter[2].equals("X") && !curr_matter[2].equals(matter))){
         expand(2, x, y-1, t, matter);
      }

      //right
      if(y+1 < j && (!curr_matter[3].equals("X") && !curr_matter[3].equals(matter))){
         expand(3, x, y+1, t, matter);
      }
    }

    if(!end){
      result = "the world is saved";
      return;
    }
    result = "" + time;
    return;
  }

  private void expand(int index, int a, int b, int tm, String mat){
    if(curr_matter_g[index].equals(".")){
      Node new_node = new Node (mat, null, null, a, b, tm+1);
      uni.get(a).set(b, mat);
      floodq.add(new_node);
    }
    else if((curr_matter_g[index].equals("+") && mat.equals("-")) || (curr_matter_g[index].equals("-") && mat.equals("+"))) {
      end = true;
      time = tm+1;
      uni.get(a).set(b, "*");
    }
    return;
  }

  public String getResult(){
    return result;
  }

  public ArrayList<ArrayList<String>> getUniView(){
    return uni;
  }

}


/*
  private void printQueue(Queue q){
    Node elem;
    while(q.hasMore()){
      elem = q.remove();
      int x = elem.getX();
      int y = elem.getY();
      String matter = elem.getData();
      int t = elem.getTime();
      String curr_matter;
      System.out.printf("x = %d , y = %d, matter = %s and time = %d\n",x,y,matter,t);
    }
  return;
  }
  */
