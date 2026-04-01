// Lab 06 Spring 2026
// Virginia Tech Honor Code Pledge:

//

// As a Hokie, I will conduct myself with honor and integrity at all times.

// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

// -- Obed Mavungu
// LLM Statement:
//
// During the preparation of this assignment, I, Obed Mavungu, used ChatGPT
// to help understand the requirements of the ArrayBasedStack implementation,
// clarify the logic of stack operations (push, pop, peek, contains, and
// testing),
// and review testing strategies for JUnit test cases. After using this tool,
// I reviewed and edited the content as needed to ensure its accuracy and take
// full responsibility for the content in relation to grading. I understand
// that I am responsible for being able to complete this work without the use
// of assistance.

package arraystack;

import java.util.EmptyStackException;

/**
 * Implementation of the inyerface StackADT
 * 
 * @author Obed Mavungu
 * @version 2026-02-26
 * 
 * @param <T>
 *            the generic type
 */

public class ArrayBasedStack<T> implements StackADT<T> {

    private T[] stackArray;
    private int size;
    private int capacity;

    /**
     * Initial capacity of the array
     * 
     * @param initialCapacity
     *            of the array used to stack element
     */

    @SuppressWarnings("unchecked")
    public ArrayBasedStack(int initialCapacity) {
        capacity = initialCapacity;
        size = 0;
        stackArray = (T[])new Object[capacity];
    }


    /**
     * Default constructor with initial capacity of 100
     */

    public ArrayBasedStack() {
        this(100);
    }


    @Override
    public boolean isEmpty() {
        return size == 0;

    }


    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[size - 1];
    }


    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int topIndex = size - 1;
        T top = stackArray[topIndex];
        stackArray[topIndex] = null; // propre
        size--;
        return top;
    }


    /**
     * Expands the capacity of the stack by doubling its current capacity.
     */
    private void expandCapacity() {

        @SuppressWarnings("unchecked")
        T[] newArray = (T[])new Object[this.capacity * 2];

        for (int i = 0; i < this.capacity; i++) {
            newArray[i] = this.stackArray[i];
        }

        this.stackArray = newArray;
        this.capacity *= 2;
    }


    @Override
    public void push(T item) {
        if (size == capacity) {
            expandCapacity();
        }
        stackArray[size] = item;
        size++;
    }


    @Override
    public boolean contains(T item) {
        for (int i = 0; i < size; i++) {
            if (item == null) {
                if (stackArray[i] == null) {
                    return true;
                }
            }
            else if (item.equals(stackArray[i])) {
                return true;
            }
        }
        return false;
    }


    @Override
    public int size() {

        return size;
    }


    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            stackArray[i] = null;
        }
        size = 0;
    }


    @Override
    public Object[] toArray() {
        @SuppressWarnings("unchecked")
        T[] copy = (T[])new Object[this.size()];
        for (int i = 0; i < this.size(); i++) {
            copy[i] = this.stackArray[i];
        }
        return copy;
    }


    /**
     * Returns the string representation of the stack.
     * 
     * [] (if the stack is empty)
     * [bottom, item, ..., item, top] (if the stack contains items)
     * 
     * @return the string representation of the stack.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[');

        boolean firstItem = true;
        for (int i = 0; i < this.size(); i++) {
            if (!firstItem) {
                builder.append(", ");
            }
            else {
                firstItem = false;
            }

            // String.valueOf will print null or the toString of the item
            builder.append(String.valueOf(this.stackArray[i]));
        }
        builder.append(']');
        return builder.toString();
    }


    /**
     * Two stacks are equal iff they both have the same size and contain the
     * same elements in the same order.
     *
     * @param other
     *            the other object to compare to this
     *
     * @return {@code true}, if the stacks are equal; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (this.getClass().equals(other.getClass())) {
            ArrayBasedStack<?> otherStack = (ArrayBasedStack<?>)other;
            if (this.size() != otherStack.size()) {
                return false;
            }
            Object[] otherArray = otherStack.toArray();
            for (int i = 0; i < this.size(); i++) {
                if (!(this.stackArray[i].equals(otherArray[i]))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
