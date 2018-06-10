/**
 *This is a queue made as an chain of objects
 */

 public class Queue implements Worklist{
   protected Node top = null;
   protected Node bottom = null;

   /**
    * adds a string to the top of the Queue
    */
   public void add (Node info){
     if (top == null){
       top = bottom = info;
       return;
     }
      Node temp = bottom;
      bottom = info;
      bottom.setForth(temp);
      temp.setBack(bottom);
      return;
   }

   /**
    *if return value is true then queue has more
    *else queue is empty
    */
    public boolean hasMore(){
      return (top != null);
    }

    /**
     * removes first item on the queue
     */
     public Node remove (){
       Node str = top;
       if(top != null){
         top = top.getLinkh();

         if(top == null){
           bottom = top;
         }
         else{
           top.setForth(null);
         }
       return str;
      }
      else{
       return null;
      }
    }
 }

 /* _____________TESTING____________
    public static void main(String[] args) {
      Queue song = new Queue();
      song.add("another");
      song.add("one");
      song.add("bites");
      song.add("the");
      song.add("dust");
      while(song.hasMore()){
        System.out.println(song.remove());
      }
    }
   */
