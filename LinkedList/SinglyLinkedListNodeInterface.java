package LinkedList;
public interface SinglyLinkedListNodeInterface<T extends Comparable<T>> {
  void setData(T data);
  T getData();

  void setNext(SinglyLinkedListNodeInterface<T> next);
  SinglyLinkedListNodeInterface<T> getNext();
}

