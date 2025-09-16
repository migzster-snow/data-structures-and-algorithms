package LinkedList;

/*
 * A class for a doubly linked list data structure.
 */
public class DoublyLinkedList<T extends Comparable<T>> 
implements LinkedListInterface<T> {

  // Instance Variables

  /*
   * The number of elements in the list.
   */
  private int size;

  /*
   * The head (first element) of the list.
   */
  private DoublyLinkedListNode<T> head;

  /*
   * The tail (last element) of the list.
   */
  private DoublyLinkedListNode<T> tail;

  // Constructor

  /*
   * Constructor for the DoublyLinkedList class.
   */
  public DoublyLinkedList() {
    this.size = 0;
    this.head = null;
    this.tail = null;
  }

  // Methods

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
    DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<>();
    newNode.setData(element);
    if (this.isEmpty()) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      newNode.setNext(this.head);
      this.head.setPrev(newNode);
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
    DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<>();
    newNode.setData(element);
    if (isEmpty()) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      this.tail.setNext(newNode);
      newNode.setPrev(this.tail);
      this.tail = newNode;
    }
    this.size++;
  }

  /*
   * Adds an element at the specified index. If the index is equal to the size
   * of the list, the element should be added to the back of the list. If the
   * index is 0, the element should be added to the front of the list. 
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
      addFirst(element);
    } else if (index == this.size) {
      addLast(element);
    } else {
      DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<>();
      newNode.setData(element);
      DoublyLinkedListNode<T> current;
      if (index < this.size / 2) {
        current = this.head;
        for (int i = 0; i < index - 1; i++) {
          current = (DoublyLinkedListNode<T>) current.getNext();
        }
      } else {
        current = this.tail;
        for (int i = this.size - 1; i > index; i--) {
          current = (DoublyLinkedListNode<T>) current.getPrev();
        }
      }
      newNode.setNext(current.getNext());
      newNode.setPrev(current);
      ((DoublyLinkedListNode<T>) current.getNext()).setPrev(newNode);
      current.setNext(newNode);
      this.size++;
    }
  }

  /*
   * Removes all elements from the list.
   */
  @Override
  public void clear() {
    this.size = 0;
    this.head = null;
    this.tail = null;
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
    DoublyLinkedListNode<T> current = this.head;
    while (current != null) {
      if (current.getData().equals(element)) {
        return true;
      }
      current = (DoublyLinkedListNode<T>) current.getNext();
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
   * @return The tail of the list, or null if empty.
   */
  @Override
  public T getLast() {
    if (this.isEmpty()) {
      return null;
    }
    return this.tail.getData();
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
    DoublyLinkedListNode<T> current;
    if (index < this.size / 2) {
      current = this.head;
      for (int i = 0; i < index; i++) {
        current = (DoublyLinkedListNode<T>) current.getNext();
      }
    } else {
      current = this.tail;
      for (int i = this.size - 1; i > index; i--) {
        current = (DoublyLinkedListNode<T>) current.getPrev();
      }
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
    DoublyLinkedListNode<T> current = this.head;
    int index = 0;
    while (current != null) {
      if (current.getData().equals(element)) {
        return index;
      }
      current = (DoublyLinkedListNode<T>) current.getNext();
      index++;
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
    DoublyLinkedListNode<T> current = this.tail;
    int index = this.size - 1;
    while (current != null) {
      if (current.getData().equals(element)) {
        return index;
      }
      current = (DoublyLinkedListNode<T>) current.getPrev();
      index--;
    }
    return -1;
  }

  /*
   * Removes the element at the head of the list. Same as removeFirst.
   * @return The element that was removed, or null if the list is empty.
   */
  @Override
  public T poll() {
    return removeFirst();
  }

  /*
   * Removes the element at the head of the list. Same as poll.
   * @return The element that was removed, or null if the list is empty.
   */
  @Override
  public T removeFirst() {
    if (isEmpty()) {
      return null;
    }
    T data = this.head.getData();
    this.head = (DoublyLinkedListNode<T>) this.head.getNext();
    if (this.head != null) {
      this.head.setPrev(null);
    } else {
      this.tail = null;
    }
    this.size--;
    return data;
  }

  /*
   * Removes the element at the tail of the list. Same as removeLast.
   * @return The element that was removed, or null if the list is empty.
   */
  @Override
  public T pop() {
    return removeLast();
  }

  /*
   * Removes the element at the tail of the list. Same as pop.
   * @return The element that was removed, or null if the list is empty.
   */
  @Override
  public T removeLast() {
    if (isEmpty()) {
      return null;
    }
    T data = this.tail.getData();
    this.tail = (DoublyLinkedListNode<T>) this.tail.getPrev();
    if (this.tail != null) {
      this.tail.setNext(null);
    } else {
      this.head = null;
    }
    this.size--;
    return data;
  }

  /*
   * Removes the element at the specified index.
   * @param index The index at which the element should be removed.
   * @throws IndexOutOfBoundsException if index < 0 or index >= size()
   * @return The element that was removed.
   */
  @Override
  public T remove(int index) {
    if (!checkIndexExclusive(index)) {
      throw new IndexOutOfBoundsException("Index out of bounds");
    }
    if (index == 0) {
      return removeFirst();
    } else if (index == this.size - 1) {
      return removeLast();
    } else {
      DoublyLinkedListNode<T> current;
      if (index < this.size / 2) {
        current = this.head;
        for (int i = 0; i < index; i++) {
          current = (DoublyLinkedListNode<T>) current.getNext();
        }
      } else {
        current = this.tail;
        for (int i = this.size - 1; i > index; i--) {
          current = (DoublyLinkedListNode<T>) current.getPrev();
        }
      }
      T data = current.getData();
      current.getPrev().setNext(current.getNext());
      current.getNext().setPrev(current.getPrev());
      this.size--;
      return data;
    }
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
    DoublyLinkedListNode<T> current = this.head;
    int index = 0;
    while (current != null) {
      if (current.getData().equals(element)) {
        remove(index);
        return true;
      }
      current = (DoublyLinkedListNode<T>) current.getNext();
      index++;
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
    DoublyLinkedListNode<T> current = this.tail;
    int index = this.size - 1;
    while (current != null) {
      if (current.getData().equals(element)) {
        remove(index);
        return true;
      }
      current = (DoublyLinkedListNode<T>) current.getPrev();
      index--;
    }
    return false;
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
    DoublyLinkedListNode<T> current;
    if (index < this.size / 2) {
      current = this.head;
      for (int i = 0; i < index; i++) {
        current = (DoublyLinkedListNode<T>) current.getNext();
      }
    } else {
      current = this.tail;
      for (int i = this.size - 1; i > index; i--) {
        current = (DoublyLinkedListNode<T>) current.getPrev();
      }
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
  public void mergeSort() {
  }

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
    if (isEmpty()) {
      return;
    }
    DoublyLinkedListNode<T> current = this.head;
    DoublyLinkedListNode<T> temp = null;
    this.tail = current;
    while (current != null) {
      temp = (DoublyLinkedListNode<T>) current.getPrev();
      current.setPrev(current.getNext());
      current.setNext(temp);
      current = (DoublyLinkedListNode<T>) current.getPrev();
    }
    this.head = temp;
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
    if (isEmpty()) {
      return null;
    }
    T[] array = (T[]) new Comparable[this.size];
    DoublyLinkedListNode<T> current = this.head;
    int index = 0;
    while (current != null) {
      array[index] = current.getData();
      current = (DoublyLinkedListNode<T>) current.getNext();
      index++;
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
    if (!checkIndexInclusive(fromIndex) || !checkIndexExclusive(toIndex) 
    || fromIndex > toIndex) {
      throw new IndexOutOfBoundsException("Index out of bounds");
    }
    if (isEmpty()) {
      return null;
    }
    T[] array = (T[]) new Comparable[toIndex - fromIndex];
    DoublyLinkedListNode<T> current = this.head;
    int index = 0;
    while (current != null && index < toIndex) {
      if (index >= fromIndex) {
        array[index - fromIndex] = current.getData();
      }
      current = (DoublyLinkedListNode<T>) current.getNext();
      index++;
    }
    return array;
  }

  // Helper methods

  /*
   * Checks if the given index is in range [0, size).
   * @param index The index to be checked.
   * @returns true if the index is valid, false otherwise.
   */
  private boolean checkIndexExclusive(int index) {
    return index >= 0 && index < size;
  }

  /*
   * Checks if the given index is in range [0, size].
   * @param index The index to be checked.
   * @returns true if the index is valid, false otherwise.
   */
  private boolean checkIndexInclusive(int index) {
    return index >= 0 && index <= size;
  }

  // Node class

  private class DoublyLinkedListNode<T extends Comparable<T>> 
  implements DoublyLinkedListNodeInterface<T> {

    // Instance Variables

    /*
     * The data of the node.
     */
    private T data;

    /*
     * The next node of the current node.
     */
    private DoublyLinkedListNodeInterface<T> next;

    /*
     * The previous node of the current node.
     */
    private DoublyLinkedListNodeInterface<T> prev;

    // Constructor

    /*
     * Constructor for Node class.
     */
    public DoublyLinkedListNode() {
      this.data = null;
      this.next = null;
      this.prev = null;
    }

    // Methods

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
    public void setNext(DoublyLinkedListNodeInterface<T> next) {
      this.next = next;
    }

    /*
    * Gets the next node of the current node.
    * @return The next node of the current node.
    */
    @Override
    public DoublyLinkedListNodeInterface<T> getNext() {
      return this.next;
    }

    /*
    * Sets the previous node of the current node.
    * @param prev The previous node to be set.
    */
    @Override
    public void setPrev(DoublyLinkedListNodeInterface<T> prev) {
      this.prev = prev;
    }

    /*
    * Gets the previous node of the current node.
    * @return The previous node of the current node.
    */
    @Override
    public DoublyLinkedListNodeInterface<T> getPrev() {
      return this.prev;
    }

  } // End of Node class

} // End of DoublyLinkedList class
