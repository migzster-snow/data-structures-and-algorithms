package Array;

/*
 * A dynamic array implementation.
 */
public class DynamicArray<T extends Comparable<T>> 
implements DynamicArrayInterface<T> {

  // Instance variables

  /*
   * The current number of elements in the array.
   */
  private int size;

  /*
   * The current capacity of the array.
   */
  private int capacity;
  
  /*
   * The array to store the elements.
   */
  private T[] data;

  /*
   * The initial capacity of the array.
   */
  private static final int INITIAL_CAPACITY = 32;

  // Constructor

  /*
   * Constructs a new dynamic array.
   */
  @SuppressWarnings("unchecked")
  public DynamicArray() {
    this.size = 0;
    this.capacity = INITIAL_CAPACITY;
    this.data = (T[]) new Comparable[INITIAL_CAPACITY];
  }

  // Methods

  /*
   * Adds an element to the front of the array.
   * @param element The element to be added to the front of the array.
   * @throws IllegalArgumentException if element is null.
   */
  @Override
  public void addFront(T element) {
    if (element == null) {
      throw new IllegalArgumentException("Element cannot be null");
    }
    if (isFull()) {
      upsize();
    }
    System.arraycopy(this.data, 0, this.data, 1, this.size);
    this.data[0] = element;
    this.size++;
  }

  /*
   * Adds an element to the back of the array.
   * @param element The element to be added to the back of the array.
   * @throws IllegalArgumentException if element is null.
   */
  @Override
  public void addBack(T element) {
    if (element == null) {
      throw new IllegalArgumentException("Element cannot be null");
    }
    if (isFull()) {
      upsize();
    }
    this.data[this.size++] = element;
  }

  /*
   * Adds an element at the specified index. If the index is equal to the size
   * of the array, the element should be added to the back of the array.
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
    if (isFull()) {
      upsize();
    }
    System.arraycopy(this.data, index, this.data, index + 1, this.size - index);
    this.data[index] = element;
    this.size++;
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
    return this.data[index];
  }

  /*
   * Replaces an element at the specified index.
   * @param index The index at which the element should be replaced.
   * @param element The element to be replaced at the specified index.
   * @throws IndexOutOfBoundsException if index < 0 or index >= size()
   * @throws IllegalArgumentException if element is null.
   * @return The element that was replaced.
   */
  @Override
  public T set(int index, T element) {
    if (element == null) {
      throw new IllegalArgumentException("Element cannot be null");
    }
    if (!checkIndexExclusive(index)) {
      throw new IndexOutOfBoundsException("Index out of bounds");
    }
    T oldElement = this.data[index];
    this.data[index] = element;
    return oldElement;
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
    for (int i = 0; i < this.size; i++) {
      if (this.data[i].equals(element)) {
        return i;
      }
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
    for (int i = this.size - 1; i >= 0; i--) {
      if (this.data[i].equals(element)) {
        return i;
      }
    }
    return -1;
  }

  /*
   * Checks if the array contains the given element.
   * @param element The element to be checked.
   * @throws IllegalArgumentException if element is null.
   * @return true if the array contains the given element, false otherwise.
   */
  @Override
  public boolean contains(T element) {
    if (element == null) {
      throw new IllegalArgumentException("Element cannot be null");
    }
    return firstIndexOf(element) != -1;
  }

  /*
   * Removes the element at the front of the array.
   * @return The element that was removed, or null if the array is empty.
   */
  @Override
  public T removeFront() {
    if (isEmpty()) {
      return null;
    }
    T removedElement = this.data[0];
    System.arraycopy(this.data, 1, this.data, 0, this.size - 1);
    this.size--;
    if (isHalfFull() && this.capacity > INITIAL_CAPACITY) {
      downsize();
    }
    return removedElement;
  }

  /*
   * Removes the element at the back of the array.
   * @return The element that was removed, or null if the array is empty.
   */
  @Override
  public T removeBack() {
    if (isEmpty()) {
      return null;
    }
    T removedElement = this.data[--this.size];
    if (isHalfFull() && this.capacity > INITIAL_CAPACITY) {
      downsize();
    }
    return removedElement;
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
    T removedElement = this.data[index];
    System.arraycopy(this.data, index + 1, this.data, index, 
        this.size - index - 1);
    this.size--;
    if (isHalfFull() && this.capacity > INITIAL_CAPACITY) {
      downsize();
    }
    return removedElement;
  }

  /*
   * Removes the first occurrence of the given element.
   * @param element The element to be removed.
   * @throws IllegalArgumentException if element is null.
   * @return true if the element was removed, false otherwise.
   */
  @Override
  public boolean removeFirst(T element) {
    if (element == null) {
      throw new IllegalArgumentException("Element cannot be null");
    }
    int index = firstIndexOf(element);
    if (index == -1) {
      return false;
    }
    remove(index);
    return true;
  }

  /*
   * Removes the last occurrence of the given element.
   * @param element The element to be removed.
   * @throws IllegalArgumentException if element is null.
   * @return true if the element was removed, false otherwise.
   */
  @Override
  public boolean removeLast(T element) {
    if (element == null) {
      throw new IllegalArgumentException("Element cannot be null");
    }
    int index = lastIndexOf(element);
    if (index == -1) {
      return false;
    }
    remove(index);
    return true;
  }

  /*
   * Returns the number of elements in the array.
   * @return The number of elements in the array.
   */
  @Override
  public int size() {
    return this.size;
  }

  /*
   * Checks if the array is empty.
   * @return true if the array is empty, false otherwise.
   */
  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  /*
   * Removes all elements from the array.
   */
  @Override
  @SuppressWarnings("unchecked")
  public void clear() {
    this.size = 0;
    this.capacity = INITIAL_CAPACITY;
    this.data = (T[]) new Comparable[INITIAL_CAPACITY];
  }

  /*
   * Sorts the elements in the array in ascending order using merge sort.
   */
  @Override
  public void mergeSort() {}

  /*
   * Sorts the elements in the array in ascending order using quick sort.
   */
  @Override
  public void quickSort() {}

  /*
   * Sorts the elements in the array in ascending order using insertion sort.
   */
  @Override
  public void insertionSort() {
    for (int i = 1; i < this.size; i++) {
      T key = this.data[i];
      int j = i - 1;
      while (j >= 0 && this.data[j].compareTo(key) > 0) {
        this.data[j + 1] = this.data[j];
        j--;
      }
      this.data[j + 1] = key;
    }
  }

  /*
   * Sorts the elements in the array in ascending order using selection sort.
   */
  @Override
  public void selectionSort() {
    for (int i = 0; i < this.size - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < this.size; j++) {
        if (this.data[j].compareTo(this.data[minIndex]) < 0) {
          minIndex = j;
        }
      }
      if (minIndex != i) {
        T temp = this.data[i];
        this.data[i] = this.data[minIndex];
        this.data[minIndex] = temp;
      }
    }
  }

  /*
   * Reverses the order of the elements in the array.
   */
  @Override
  public void reverse() {
    for (int i = 0; i < this.size / 2; i++) {
      T temp = this.data[i];
      this.data[i] = this.data[this.size - 1 - i];
      this.data[this.size - 1 - i] = temp;
    }
  }

  /*
   * Returns an array representation of the elements in the array.
   * @return An array containing the elements in the array.
   */
  @Override
  @SuppressWarnings("unchecked")
  public T[] toArray() {
    T[] array = (T[]) new Comparable[this.size];
    System.arraycopy(this.data, 0, array, 0, this.size);
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
    if (fromIndex < 0 || toIndex > this.size || fromIndex > toIndex) {
      throw new IndexOutOfBoundsException("Index out of bounds");
    }
    int subArraySize = toIndex - fromIndex;
    T[] subArray = (T[]) new Comparable[subArraySize];
    System.arraycopy(this.data, fromIndex, subArray, 0, subArraySize);
    return subArray;
  }
  
  // Helper methods

  /*
   * Checks if the array is full.
   * @return true if the array is full, false otherwise.
   */
  private boolean isFull() {
    return this.size == this.capacity;
  }

  /*
   * Checks if the array is half full.
   * @return true if the array is half full, false otherwise.
   */
  private boolean isHalfFull() {
    return this.size == this.capacity / 2;
  }

  /*
   * Checks if the index is in the range [0, size).
   * @param index The index to check.
   * @return true if the index is exclusive, false otherwise.
   */
  private boolean checkIndexExclusive(int index) {
    return index >= 0 && index < this.size;
  }

  /*
   * Checks if the index is in the range [0, size].
   * @param index The index to check.
   * @return true if the index is inclusive, false otherwise.
   */
  private boolean checkIndexInclusive(int index) {
    return index >= 0 && index <= this.size;
  }

  /*
   * Doubles the capacity of the array.
   */
  @SuppressWarnings("unchecked")
  private void upsize() {
    this.capacity *= 2;
    T[] newData = (T[]) new Comparable[this.capacity];
    System.arraycopy(this.data, 0, newData, 0, this.size);
    this.data = newData;
  }

  /*
   * Halves the capacity of the array.
   */
  @SuppressWarnings("unchecked")
  private void downsize() {
    this.capacity /= 2;
    T[] newData = (T[]) new Comparable[this.capacity];
    System.arraycopy(this.data, 0, newData, 0, this.size);
    this.data = newData;
  }

}

