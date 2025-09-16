package Stack;

import Array.DynamicArray;

/*
 * A generic stack implementation.
 */
public class Stack<T extends Comparable<T>> extends DynamicArray<T> implements StackInterface<T>{

    /*
     * Constructor to initialise the stack.
     */
    public Stack() {
        super();
    }

    /*
     * Checks if the stack is empty.
     */
    @Override
    public boolean empty() {
        return this.isEmpty();
    }

    /*
     * Returns the item at the top of the stack without removing it, or null
     * if the stack is empty.
     */
    @Override
    public T peek() {
        if (this.empty()) {
            return null;
        }
        return this.get(this.size() - 1);
    }

    /*
     * Removes the item at the top of the stack and returns it, or null if the 
     * stack is empty.
     */
    @Override
    public T pop() {
        if (this.empty()) {
            return null;
        }
        return this.remove(this.size() - 1);
    }

    /*
     * Pushes an item onto the stack.
     */
    @Override
    public T push(T item) {
        this.addBack(item);
        return item;
    }

    /*
     * Searches for an item in the stack.
     */
    @Override
    public int search(T item) {
        return this.firstIndexOf(item);
    }
}