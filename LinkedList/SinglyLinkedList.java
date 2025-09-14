package LinkedList;
public class SinglyLinkedList<T extends Comparable<T>> implements LinkedListInterface<T> {
  private int size;
  private Node<T> head;

  public SinglyLinkedList() {}

  private class Node<T extends Comparable<T>> implements SinglyLinkedListNodeInterface<T> {
    private T data;
    private Node<T> next;

    public Node() {}
  }
}

