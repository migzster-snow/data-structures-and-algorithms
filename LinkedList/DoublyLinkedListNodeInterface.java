package LinkedList;

/*
 * An interface for a node in a doubly linked list.
 */
public interface DoublyLinkedListNodeInterface<T extends Comparable<T>> {

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
  void setNext(DoublyLinkedListNodeInterface<T> next);

  /*
   * Gets the next node of the current node.
   * @return The next node of the current node.
   */
  DoublyLinkedListNodeInterface<T> getNext();

  /*
   * Sets the previous node of the current node.
   * @param prev The previous node to be set.
   */
  void setPrev(DoublyLinkedListNodeInterface<T> prev);

  /*
   * Gets the previous node of the current node.
   * @return The previous node of the current node.
   */
  DoublyLinkedListNodeInterface<T> getPrev();
}
