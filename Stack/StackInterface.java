package Stack;

/*
 * An interface for a generic stack data structure.
 */
public interface StackInterface<T extends Comparable<T>> {
    /*
     * Checks if the stack is empty.
     */
    boolean empty();
    
    /*
     * Returns the item at the top of the stack without removing it, or null if
     * the stack is empty.
     */
    T peek();

    /*
     *  Removes the item at the top of the stack and returns it, or null if the
     * stack is empty.
     */
    T pop();

    /*
     * Pushes an item onto the stack.
     */
    T push(T item);

    /*
     * Searches for an item in the stack.
     */
    int search(T item);
}