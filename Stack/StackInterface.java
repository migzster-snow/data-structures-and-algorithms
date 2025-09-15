public Stack;

public interface StackInterface<T extends Comparable<T>> {
    boolean empty();
    T peek();
    T pop();
    T push(T item);
    int search(T item);
}