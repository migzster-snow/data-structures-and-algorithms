package LinkedList;
public interface DoublyLinkedListNodeInterface<T extends Comparable<T>> {
  void setData(T data);
  T getData();

  void setNext(DoublyLinkedListNodeInterface<T> next);
  DoublyLinkedListNodeInterface<T> getNext();

  void setPrev(DoublyLinkedListNodeInterface<T> prev);
  DoublyLinkedListNodeInterface<T> getPrev();
}

