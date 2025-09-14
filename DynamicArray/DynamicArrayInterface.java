package DynamicArray;
public interface DynamicArrayInterface<T extends Comparable<T>> {
  boolean add(T value);
  void add(int index, T value);
 
  T get(int index);
 
  boolean contains(T value);
  int indexOf(T value);
  int lastIndexOf(T value);

  T remove(int index);
  boolean remove(T value);
 
  T set(int index, T value);

  int size();
  boolean isEmpty();

  void clear();

  void sort();

  T[] toArray();
  T[] toSubArray(int fromIndex, int toIndex);
}
