package LinkedList;

/*
 * An interface for a linked list data structure.
 */
public interface LinkedListInterface<T extends Comparable<T>> {
  
  /*
   * Adds an element to the top of the list. Same as addFirst.
   * @param element The element to be added to the top of the list.
   * @throws IllegalArgumentException if element is null.
   */
  void push(T element);

  /*
   * Adds an element to the front of the list. Same as push.
   * @param element The element to be added to the front of the list.
   * @throws IllegalArgumentException if element is null.
   */
  void addFirst(T element);

  /*
   * Adds an element to the back of the list. Same as addLast.
   * @param element The element to be added to the back of the list.
   * @throws IllegalArgumentException if element is null.
   */
  void offer(T element);

  /*
   * Adds an element to the back of the list. Same as offer.
   * @param element The element to be added to the back of the list.
   * @throws IllegalArgumentException if element is null.
   */
  void addLast(T element);

  /*
   * Adds an element at the specified index. If the index is equal to the size
   * of the list, the element should be added to the back of the list.
   * @param index The index at which the element should be added.
   * @param element The element to be added at the specified index.
   * @throws IndexOutOfBoundsException if index < 0 or index > size()
   * @throws IllegalArgumentException if element is null.
   */
  void add(int index, T element);

  /*
   * Removes all elements from the list.
   */
  void clear();

  /*
   * Checks if the list contains the given element.
   * @param element The element to be checked.
   * @throws IllegalArgumentException if element is null.
   * @return true if the list contains the given element, false otherwise.
   */
  boolean contains(T element);
 
  /*
   * Retrieves the head (first element) of the list. Same as getFirst.
   * @return The head of the list, or null if empty.
   */
  T peek();

  /*
   * Retrieves the head (first element) of the list. Same as peek.
   * @return The head of the list, or null if empty.
   */
  T getFirst();

  /*
   * Retrieves the tail (last element) of the list.
   * @throws IllegalStateException if the list is empty.
   * @return The tail of the list, or null if empty.
   */
  T getLast();

  /*
   * Retrieves an element at the specified index.
   * @param index The index at which the element should be retrieved.
   * @throws IndexOutOfBoundsException if index < 0 or index >= size()
   * @return The element that was retrieved.
   */
  T get(int index);

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
   * Removes the element at the head of the list. Same as removeFirst.
   * @return The element that was removed, or null if the list is empty.
   */
  T poll();

  /*
   * Removes the element at the head of the list. Same as poll.
   * @return The element that was removed, or null if the list is empty.
   */
  T removeFirst();

  /*
   * Removes the element at the tail of the list. Same as removeLast.
   * @return The element that was removed, or null if the list is empty.
   */
  T pop();

  /*
   * Removes the element at the tail of the list. Same as pop.
   * @return The element that was removed, or null if the list is empty.
   */
  T removeLast();

  /*
   * Removes the element at the specified index.
   * @param index The index at which the element should be removed.
   * @throws IndexOutOfBoundsException if index < 0 or index >= size()
   * @return The element that was removed, or null if the list is empty.
   */
  T remove(int index);
  
  /*
   * Removes the first occurrence of the given element.
   * @param element The element to be removed.
   * @throws IllegalArgumentException if element is null.
   * @return true if the element was removed, false otherwise.
   */
  boolean removeFirstOccurrence(T element);

  /*
   * Removes the last occurrence of the given element.
   * @param element The element to be removed.
   * @throws IllegalArgumentException if element is null.
   * @return true if the element was removed, false otherwise.
   */
  boolean removeLastOccurrence(T element);

  /*
   * Replaces the element at the specified index with the given element.
   * @param index The index at which the element should be replaced.
   * @param element The element to be stored at the specified index.
   * @throws IndexOutOfBoundsException if index < 0 or index >= size()
   * @throws IllegalArgumentException if element is null.
   * @return The element previously at the specified index.
   */
  T set(int index, T element);

  /*
   * Returns the number of elements in the list.
   * @return The number of elements in the list.
   */
  int size();

  /*
   * Sorts the elements in the list in ascending order using merge sort.
   */
  void mergeSort();

  /*
   * Sorts the elements in the list in ascending order using insertion sort.
   */
  void insertionSort();

  /*
   * Sorts the elements in the list in ascending order using selection sort.
   */
  void selectionSort();

  /*
   * Sorts the elements in the list in ascending order using quick sort.
   */
  void quickSort();

  /*
   * Reverses the order of the elements in the list.
   */
  void reverse();

  /*
   * Checks if the list is empty.
   * @return true if the list is empty, false otherwise.
   */
  boolean isEmpty();

  /*
   * Returns an array representation of the elements in the list.
   * @return An array containing the elements in the list.
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
