/**
 * An interface for collections of Strings.
 */
public interface Worklist {
  /**
   * Add one Node to the worklist.
   * @param item the String to add
   */
  void add(Node new_node);

  /**
   * Test whether there are more elements in the
   * worklist; that is, test whether more elements have
   * been added than have been removed.
   * @return true if there are more elements
   */
  boolean hasMore();

  /**
   * Remove one Node from the worklist and return it.
   * There must be at least one element in the worklist.
   * @return the Node item removed
   */
  Node remove();
}
