package DynamicArray;

/*
 * An interface for a dynamic array data structure.
 */
public interface DynamicArrayInterface<T extends Comparable<T>> {

  /*
   * Adds an element to the front of the array.
   * @param element The element to be added to the front of the array.
   * @throws IllegalArgumentException if element is null.
   */
  void addFront(T element);

  /*
   * Adds an element to the back of the array.
   * @param element The element to be added to the back of the array.
   * @throws IllegalArgumentException if element is null.
   */
  void addBack(T element);

  /*
   * Adds an element at the specified index. If the index is equal to the size
   * of the array, the element should be added to the back of the array.
   * @param index The index at which the element should be added.
   * @param element The element to be added at the specified index.
   * @throws IndexOutOfBoundsException if index < 0 or index > size()
   * @throws IllegalArgumentException if element is null.
   */
  void add(int index, T element);

  /*
   * Retrieves an element at the specified index.
   * @param index The index at which the element should be retrieved.
   * @throws IndexOutOfBoundsException if index < 0 or index >= size()
   * @return The element that was retrieved.
   */
  T get(int index);

  /*
   * Replaces an element at the specified index.
   * @param index The index at which the element should be replaced.
   * @param element The element to be replaced at the specified index.
   * @throws IndexOutOfBoundsException if index < 0 or index >= size()
   * @throws IllegalArgumentException if element is null.
   * @return The element that was replaced.
   */
  T set(int index, T element);
 
  /*
   * Finds the index of the first occurrence of the given element.
   * @param element The element to find found.
   * @throws IllegalArgumentException if element is null.
   * @return The index of the first occurrence of the given element,
   *         or -1 if not found.
   */
  int firstIndexOf(T element);

  /*
   * Finds the index of the last occurrence of the given element.
   * @param element The element to be found.
   * @throws IllegalArgumentException if element is null.
   * @return The index of the last occurrence of the given element,
   *         or -1 if not found.
   */
  int lastIndexOf(T element);

  /*
   * Checks if the array contains the given element.
   * @param element The element to be checked.
   * @throws IllegalArgumentException if element is null.
   * @return true if the array contains the given element, false otherwise.
   */
  boolean contains(T element);

  /*
   * Removes the element at the front of the array.
   * @return The element that was removed, or null if the array is empty.
   */
  T removeFront();

  /*
   * Removes the element at the back of the array.
   * @return The element that was removed, or null if the array is empty.
   */
  T removeBack();

  /*
   * Removes the element at the specified index.
   * @param index The index at which the element should be removed.
   * @throws IndexOutOfBoundsException if index < 0 or index >= size()
   * @return The element that was removed.
   */
  T remove(int index);

  /*
   * Removes the first occurrence of the given element.
   * @param element The element to be removed.
   * @throws IllegalArgumentException if element is null.
   * @return true if the element was removed, false otherwise.
   */
  boolean removeFirst(T element);

  /*
   * Removes the last occurrence of the given element.
   * @param element The element to be removed.
   * @throws IllegalArgumentException if element is null.
   * @return true if the element was removed, false otherwise.
   */
  boolean removeLast(T element);

  /*
   * Returns the number of elements in the array.
   * @return The number of elements in the array.
   */
  int size();

  /*
   * Checks if the array is empty.
   * @return true if the array is empty, false otherwise.
   */
  boolean isEmpty();

  /*
   * Removes all elements from the array.
   */
  void clear();

  /*
   * Sorts the elements in the array in ascending order using merge sort.
   */
  void mergeSort();

  /*
   * Sorts the elements in the array in ascending order using quick sort.
   */
  void quickSort();

  /*
   * Sorts the elements in the array in ascending order using insertion sort.
   */
  void insertionSort();

  /*
   * Sorts the elements in the array in ascending order using selection sort.
   */
  void selectionSort();

  /*
   * Returns an array representation of the elements in the array.
   * @return An array containing the elements in the array.
   */
  T[] toArray();

  /*
   * Returns a subarray from the given fromIndex (inclusive) to the given
   * toIndex (exclusive).
   * @param fromIndex The starting index of the subarray (inclusive).
   * @param toIndex The ending index of the subarray (exclusive).
   * @throws IndexOutOfBoundsException if fromIndex < 0, toIndex > size(),
   *         or fromIndex > toIndex.
   * @return An array containing the elements in the specified range.
   */
  T[] toSubArray(int fromIndex, int toIndex);
}
