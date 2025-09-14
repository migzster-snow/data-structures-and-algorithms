package LinkedList;
public class DoublyLinkedList<T extends Comparable<T>> implements LinkedListInterface<T> {
  private int size;
  private Node<T> head;
  private Node<T> tail;

  public DoublyLinkedList() {}

  private class Node<T extends Comparable<T>> implements DoublyLinkedListNodeInterface<T> {
    private T data;
    private Node<T> next;
    private Node<T> prev;

    public Node() {}
  }
}

