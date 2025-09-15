package LinkedList;

/*
 * An interface for a node in a singly linked list.
 */
public interface SinglyLinkedListNodeInterface<T extends Comparable<T>> {
  /*
   * Sets the data of the node.
   * @param data The data to be set.
   */
  void setData(T data);

  /*
   * Gets the data of the node.
   * @return The data of the node.
   */
  T getData();

  /*
   * Sets the next node of the current node.
   * @param next The next node to be set.
   */
  void setNext(SinglyLinkedListNodeInterface<T> next);

  /*
   * Gets the next node of the current node.
   * @return The next node of the current node.
   */
  SinglyLinkedListNodeInterface<T> getNext();
}

