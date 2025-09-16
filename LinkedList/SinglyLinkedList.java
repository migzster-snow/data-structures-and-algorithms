package LinkedList;

/*
 * A singly linked list implementation of the LinkedListInterface.
 */
public class SinglyLinkedList<T extends Comparable<T>> 
implements LinkedListInterface<T> {

  /*
   * The current number of elements in the list.
   */
  private int size;

  /*
   * The head (first element) of the list.
   */
  private SinglyLinkedListNode<T> head;

  /*
   * Constructs a new empty singly linked list.
   */
  public SinglyLinkedList() {
    this.size = 0;
    this.head = null;
  }

  /*
   * Adds an element to the top of the list. Same as addFirst.
   * @param element The element to be added to the top of the list.
   * @throws IllegalArgumentException if element is null.
   */
  @Override
  public void push(T element) {
    this.addFirst(element);
  }

  /*
   * Adds an element to the front of the list. Same as push.
   * @param element The element to be added to the front of the list.
   * @throws IllegalArgumentException if element is null.
   */
  @Override
  public void addFirst(T element) {
    if (element == null) {
      throw new IllegalArgumentException("Element cannot be null");
    }
    SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>();
    newNode.setData(element);
    if (this.head == null) {
      this.head = newNode;
    } else {
      newNode.setNext(this.head);
      this.head = newNode;
    }
    this.size++;
  }

  /*
   * Adds an element to the back of the list. Same as addLast.
   * @param element The element to be added to the back of the list.
   * @throws IllegalArgumentException if element is null.
   */
  @Override
  public void offer(T element) {
    this.addLast(element);
  }

  /*
   * Adds an element to the back of the list. Same as offer.
   * @param element The element to be added to the back of the list.
   * @throws IllegalArgumentException if element is null.
   */
  @Override
  public void addLast(T element) {
    if (element == null) {
      throw new IllegalArgumentException("Element cannot be null");
    }
    SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>();
    newNode.setData(element);
    if (this.head == null) {
      this.head = newNode;
    } else {
      SinglyLinkedListNode<T> current = this.head;
      while (current.getNext() != null) {
        current = (SinglyLinkedListNode<T>) current.getNext();
      }
      current.setNext(newNode);
    }
    this.size++;
  }

  /*
   * Adds an element at the specified index. If the index is equal to the size
   * of the list, the element should be added to the back of the list.
   * @param index The index at which the element should be added.
   * @param element The element to be added at the specified index.
   * @throws IndexOutOfBoundsException if index < 0 or index > size()
   * @throws IllegalArgumentException if element is null.
   */
  @Override
  public void add(int index, T element) {
    if (element == null) {
      throw new IllegalArgumentException("Element cannot be null");
    }
    if (!checkIndexInclusive(index)) {
      throw new IndexOutOfBoundsException("Index out of bounds");
    }
    if (index == 0) {
      this.addFirst(element);
      return;
    }
    if (index == this.size) {
      this.addLast(element);
      return;
    }
    SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>();
    newNode.setData(element);
    SinglyLinkedListNode<T> current = this.head;
    for (int i = 0; i < index - 1; i++) {
      current = (SinglyLinkedListNode<T>) current.getNext();
    }
    newNode.setNext(current.getNext());
    current.setNext(newNode);
    this.size++;
  }

  /*
   * Removes all elements from the list.
   */
  @Override
  public void clear() {
    this.size = 0;
    this.head = null;
  }

  /*
   * Checks if the list contains the given element.
   * @param element The element to be checked.
   * @throws IllegalArgumentException if element is null.
   * @return true if the list contains the given element, false otherwise.
   */
  @Override
  public boolean contains(T element) {
    if (element == null) {
      throw new IllegalArgumentException("Element cannot be null");
    }
    SinglyLinkedListNode<T> current = this.head;
    while (current != null) {
      if (current.getData().equals(element)) {
        return true;
      }
      current = (SinglyLinkedListNode<T>) current.getNext();
    }
    return false;
  }
 
  /*
   * Retrieves the head (first element) of the list. Same as getFirst.
   * @return The head of the list, or null if empty.
   */
  @Override
  public T peek() {
    return this.getFirst();
  }

  /*
   * Retrieves the head (first element) of the list. Same as peek.
   * @return The head of the list, or null if empty.
   */
  @Override
  public T getFirst() {
    if (this.isEmpty()) {
      return null;
    }
    return this.head.getData();
  }

  /*
   * Retrieves the tail (last element) of the list.
   * @throws IllegalStateException if the list is empty.
   * @return The tail of the list, or null if empty.
   */
  @Override
  public T getLast() {
    if (this.isEmpty()) {
      return null;
    }
    SinglyLinkedListNode<T> current = this.head;
    while (current.getNext() != null) {
      current = (SinglyLinkedListNode<T>) current.getNext();
    }
    return current.getData();
  }

  /*
   * Retrieves an element at the specified index.
   * @param index The index at which the element should be retrieved.
   * @throws IndexOutOfBoundsException if index < 0 or index >= size()
   * @return The element that was retrieved.
   */
  @Override
  public T get(int index) {
    if (!checkIndexExclusive(index)) {
      throw new IndexOutOfBoundsException("Index out of bounds");
    }
    SinglyLinkedListNode<T> current = this.head;
    for (int i = 0; i < index; i++) {
      current = (SinglyLinkedListNode<T>) current.getNext();
    }
    return current.getData();
  }

  /*
   * Finds the index of the first occurrence of the given element.
   * @param element The element to find found.
   * @throws IllegalArgumentException if element is null.
   * @return The index of the first occurrence of the given element,
   *         or -1 if not found.
   */
  @Override
  public int firstIndexOf(T element) {
    if (element == null) {
      throw new IllegalArgumentException("Element cannot be null");
    }
    SinglyLinkedListNode<T> current = this.head;
    for (int i = 0; i < this.size; i++) {
      if (current.getData().equals(element)) {
        return i;
      }
      current = (SinglyLinkedListNode<T>) current.getNext();
    }
    return -1;
  }

  /*
   * Finds the index of the last occurrence of the given element.
   * @param element The element to be found.
   * @throws IllegalArgumentException if element is null.
   * @return The index of the last occurrence of the given element,
   *         or -1 if not found.
   */
  @Override
  public int lastIndexOf(T element) {
    if (element == null) {
      throw new IllegalArgumentException("Element cannot be null");
    }
    SinglyLinkedListNode<T> current = this.head;
    int lastIndex = -1;
    for (int i = 0; i < this.size; i++) {
      if (current.getData().equals(element)) {
        lastIndex = i;
      }
      current = (SinglyLinkedListNode<T>) current.getNext();
    }
    return lastIndex;
  }

  /*
   * Removes the element at the head of the list. Same as removeFirst.
   * @return The element that was removed, or null if the list is empty.
   */
  @Override
  public T poll() {
    return this.removeFirst();
  }

  /*
   * Removes the element at the head of the list. Same as poll.
   * @return The element that was removed, or null if the list is empty.
   */
  @Override
  public T removeFirst() {
    if (this.isEmpty()) {
      return null;
    }
    SinglyLinkedListNode<T> removedNode = this.head;
    this.head = (SinglyLinkedListNode<T>) this.head.getNext();
    this.size--;
    return removedNode.getData();
  }

  /*
   * Removes the element at the tail of the list. Same as removeLast.
   * @return The element that was removed, or null if the list is empty.
   */
  @Override
  public T pop() {
    return this.removeLast();
  }

  /*
   * Removes the element at the tail of the list. Same as pop.
   * @return The element that was removed, or null if the list is empty.
   */
  @Override
  public T removeLast() {
    if (this.isEmpty()) {
      return null;
    }
    if (this.size == 1) {
      return this.removeFirst();
    }
    SinglyLinkedListNode<T> current = this.head;
    while (current.getNext() != null) {
      if (current.getNext().getNext() == null) {
        T data = current.getNext().getData();
        current.setNext(null);
        this.size--;
        return data;
      }
      current = (SinglyLinkedListNode<T>) current.getNext();
    }
    return null;
  }

  /*
   * Removes the element at the specified index.
   * @param index The index at which the element should be removed.
   * @throws IndexOutOfBoundsException if index < 0 or index >= size()
   * @return The element that was removed, or null if the list is empty.
   */
  @Override
  public T remove(int index) {
    if (!checkIndexInclusive(index)) {
      throw new IndexOutOfBoundsException("Invalid index");
    }
    if (index == 0) {
      return this.removeFirst();
    }
    SinglyLinkedListNode<T> current = this.head;
    for (int i = 0; i < index - 1; i++) {
      current = (SinglyLinkedListNode<T>) current.getNext();
    }
    SinglyLinkedListNode<T> removedNode = (SinglyLinkedListNode<T>) current.getNext();
    current.setNext(removedNode.getNext());
    this.size--;
    return removedNode.getData();
  }
  
  /*
   * Removes the first occurrence of the given element.
   * @param element The element to be removed.
   * @throws IllegalArgumentException if element is null.
   * @return true if the element was removed, false otherwise.
   */
  @Override
  public boolean removeFirstOccurrence(T element) {
    if (element == null) {
      throw new IllegalArgumentException("Element cannot be null");
    }
    SinglyLinkedListNode<T> current = this.head;
    SinglyLinkedListNode<T> previous = null;
    while (current != null) {
      if (current.getData().equals(element)) {
        if (previous == null) {
          this.head = (SinglyLinkedListNode<T>) current.getNext();
        } else {
          previous.setNext(current.getNext());
        }
        this.size--;
        return true;
      }
      previous = current;
      current = (SinglyLinkedListNode<T>) current.getNext();
    }
    return false;
  }

  /*
   * Removes the last occurrence of the given element.
   * @param element The element to be removed.
   * @throws IllegalArgumentException if element is null.
   * @return true if the element was removed, false otherwise.
   */
  @Override
  public boolean removeLastOccurrence(T element) {
    if (element == null) {
      throw new IllegalArgumentException("Element cannot be null");
    }
    SinglyLinkedListNode<T> current = this.head;
    SinglyLinkedListNode<T> previous = null;
    SinglyLinkedListNode<T> lastOccurrence = null;
    SinglyLinkedListNode<T> lastOccurrencePrev = null;
    while (current != null) {
      if (current.getData().equals(element)) {
        lastOccurrence = current;
        lastOccurrencePrev = previous;
      }
      previous = current;
      current = (SinglyLinkedListNode<T>) current.getNext();
    }
    if (lastOccurrence == null) {
      return false;
    }
    if (lastOccurrencePrev == null) {
      this.head = (SinglyLinkedListNode<T>) lastOccurrence.getNext();
    } else {
      lastOccurrencePrev.setNext(lastOccurrence.getNext());
    }
    this.size--;
    return true;
  }

  /*
   * Replaces the element at the specified index with the given element.
   * @param index The index at which the element should be replaced.
   * @param element The element to be stored at the specified index.
   * @throws IndexOutOfBoundsException if index < 0 or index >= size()
   * @throws IllegalArgumentException if element is null.
   * @return The element previously at the specified index.
   */
  @Override
  public T set(int index, T element) {
    if (element == null) {
      throw new IllegalArgumentException("Element cannot be null");
    }
    if (!checkIndexExclusive(index)) {
      throw new IndexOutOfBoundsException("Index out of bounds");
    }
    SinglyLinkedListNode<T> current = this.head;
    for (int i = 0; i < index; i++) {
      current = (SinglyLinkedListNode<T>) current.getNext();
    }
    T oldData = current.getData();
    current.setData(element);
    return oldData;
  }

  /*
   * Returns the number of elements in the list.
   * @return The number of elements in the list.
   */
  @Override
  public int size() {
    return this.size;
  }

  /*
   * Sorts the elements in the list in ascending order using merge sort.
   */
  @Override
  public void mergeSort() {}

  /*
   * Sorts the elements in the list in ascending order using insertion sort.
   */
  @Override
  public void insertionSort() {}

  /*
   * Sorts the elements in the list in ascending order using selection sort.
   */
  @Override
  public void selectionSort() {}

  /*
   * Sorts the elements in the list in ascending order using quick sort.
   */
  @Override
  public void quickSort() {}

  /*
   * Reverses the order of the elements in the list.
   */
  @Override
  public void reverse() {
    SinglyLinkedListNode<T> previous = null;
    SinglyLinkedListNode<T> current = this.head;
    SinglyLinkedListNode<T> next;
    while (current != null) {
      next = (SinglyLinkedListNode<T>) current.getNext();
      current.setNext(previous);
      previous = current;
      current = next;
    }
    this.head = previous;
  }

  /*
   * Checks if the list is empty.
   * @return true if the list is empty, false otherwise.
   */
  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  /*
   * Returns an array representation of the elements in the list.
   * @return An array containing the elements in the list.
   */
  @Override
  @SuppressWarnings("unchecked")
  public T[] toArray() {
    T[] array = (T[]) new Comparable[this.size];
    SinglyLinkedListNode<T> current = this.head;
    for (int i = 0; i < this.size; i++) {
      array[i] = current.getData();
      current = (SinglyLinkedListNode<T>) current.getNext();
    }
    return array;
  }

  /*
   * Returns a subarray from the given fromIndex (inclusive) to the given
   * toIndex (exclusive).
   * @param fromIndex The starting index of the subarray (inclusive).
   * @param toIndex The ending index of the subarray (exclusive).
   * @throws IndexOutOfBoundsException if fromIndex < 0, toIndex > size(),
   *         or fromIndex > toIndex.
   * @return An array containing the elements in the specified range.
   */
  @Override
  @SuppressWarnings("unchecked")
  public T[] toSubArray(int fromIndex, int toIndex) {
    if (!checkIndexInclusive(fromIndex) || 
        !checkIndexInclusive(toIndex) || fromIndex > toIndex) {
      throw new IndexOutOfBoundsException("Index out of bounds");
    }
    T[] array = (T[]) new Comparable[toIndex - fromIndex];
    SinglyLinkedListNode<T> current = this.head;
    for (int i = 0; i < fromIndex; i++) {
      current = (SinglyLinkedListNode<T>) current.getNext();
    }
    for (int i = fromIndex; i < toIndex; i++) {
      array[i - fromIndex] = current.getData();
      current = (SinglyLinkedListNode<T>) current.getNext();
    }
    return array;
  }

  // Helper Methods

  private boolean checkIndexInclusive(int index) {
    return index >= 0 && index <= this.size;
  }

  private boolean checkIndexExclusive(int index) {
    return index >= 0 && index < this.size;
  }

  /*
   * A private class representing a node in the singly linked list.
   */
  private class SinglyLinkedListNode<T extends Comparable<T>> 
  implements SinglyLinkedListNodeInterface<T> {

    /*
     * The data stored in the node.
     */
    private T data;

    /*
     * The next node in the list.
     */
    private SinglyLinkedListNodeInterface<T> next;

    public SinglyLinkedListNode() {
      this.data = null;
      this.next = null;
    }

    /*
    * Sets the data of the node.
    * @param data The data to be set.
    */
    @Override
    public void setData(T data) {
      this.data = data;
    }

    /*
    * Gets the data of the node.
    * @return The data of the node.
    */
    @Override
    public T getData() {
      return this.data;
    }

    /*
    * Sets the next node of the current node.
    * @param next The next node to be set.
    */
    @Override
    public void setNext(SinglyLinkedListNodeInterface<T> next) {
      this.next = next;
    }

    /*
    * Gets the next node of the current node.
    * @return The next node of the current node.
    */
    @Override
    public SinglyLinkedListNodeInterface<T> getNext() {
      return this.next;
    }

  } // End of Node class

} // End of SinglyLinkedList class
