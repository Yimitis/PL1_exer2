/**
 * A Node is an object that holds a String and a link
 * to the next Node.  It can be used to build linked
 * lists of Strings.
 */
public class Node {
  private String data; // Each node has a String...
  private int t ;   // current time passed
  private int x;       // coordinates
  private int y;
  private Node linkt;   // ...and a link to the next Node
  private Node linkh;   //... link to previous node
  /**
   * Node constructor.
   * @param theData the String to store in this Node
   * @param theLink a link to the next Node
   */
  public Node(String theData, Node theLinkt, Node theLinkh, int line, int column, int tn) {
    data = theData;
    linkt = theLinkt;
    linkh = theLinkh;
    x = line;
    y = column;
    t = tn;
  }

  /**
   * take new node reference as an arguemnt and
   * set the back of this Node
   */
   public void setBack (Node theNode)
   {
     linkh = theNode;
   }

   /**
    *set linkt of the Node
    */
    public void setForth(Node theForth)
    {
      linkt = theForth;
    }

  /**
   * Accessor for the String data stored in this Node.
   * @return our String item
   */
  public String getData() {
    return data;
  }

  /**
   * Accessor for the link to the next and previous Node
   * respectively.
   * @return the next Node
   */
  public Node getLinkt() {
    return linkt;
  }

  public Node getLinkh() {
    return linkh;
  }

  public int getTime(){
    return t;
  }

  public int getX(){
    return x;
  }

  public int getY(){
    return y;
  }
}
