package LinkedList;
public interface LinkedListInterface<T extends Comparable<T>> {
  boolean add(T value);
  void add(int index, T value);

  void addFirst(T value);
  void addLast(T value);

  void clear();

  boolean contains(T value);
 
  T element();
  T get(int index);
  T getFirst();
  T getLast();

  int indexOf(T value);
  int lastIndexOf(T value);

  boolean offer(T value);
  boolean offerFirst(T value);
  boolean offerLast(T value);

  T peek();
  T peekFirst();
  T peekLast();

  T poll();
  T pollFirst();
  T pollLast();

  T pop();
 
  void push(T value);

  T remove();
  T remove(int index);
  boolean remove(T value);
  T removeFirst();
  boolean removeFirstOccurrence(T value);
  T removeLast();
  boolean removeLastOccurrence(T value);

  T set(int index, T value);

  int size();

  void sort();

  boolean isEmpty();

  T[] toArray();
  T[] toSubArray(int fromIndex, int toIndex);
}
