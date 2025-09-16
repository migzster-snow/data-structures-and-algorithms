package Search;

/*
 * A generic binary search implementation.
 */
public class BinarySearch<T extends Comparable<T>> {
  /*
   * Searches for a value in the list using binary search.
   */
  public int binarySearch(T[] list, T value) {
    int low = 0;
    int high = list.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (list[mid].equals(value)) {
        return mid;
      } else if (list[mid].compareTo(value) < 0) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -1;
  }
}
