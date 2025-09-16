package Search;

/*
 * A generic linear search implementation.
 */
public class LinearSearch<T extends Comparable<T>> {
  /*
   * Searches for a value in the list using linear search.
   */
  public int linearSearch(T[] list, T value) {
    for (int i = 0; i < list.length; i++) {
      if (list[i].equals(value)) {
        return i;
      }
    }
    return -1;
  }
}
