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
import student.TestCase;

/**
 * Test class for ArrayBasedStack.
 * Tests all stack operations including push, pop, peek,
 * contains, clear, equals, toArray, and toString.
 *
 * @author Obed Mavungu
 * @version 2026-03-26
 */

public class ArrayBasedStackTest extends TestCase {

    private ArrayBasedStack<String> stack;

    /**
     * Initializes a new empty stack before each test.
     */

    public void setUp() {
        stack = new ArrayBasedStack<>();
    }


    /**
     * Tests the isEmpty method.
     */

    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push("A");
        assertFalse(stack.isEmpty());
    }


    /**
     * Tests the size method.
     */

    public void testSize() {
        assertEquals(0, stack.size());
        stack.push("A");
        stack.push("B");
        assertEquals(2, stack.size());
    }


    /**
     * Tests that peek throws EmptyStackException when stack is empty.
     */

    public void testPeekEmptyThrows() {
        EmptyStackException thrown = null;
        try {
            stack.peek();
        }
        catch (EmptyStackException e) {
            thrown = e;
        }
        assertNotNull(thrown);
    }


    /**
     * Tests that peek returns the top element without removing it.
     */

    public void testPeekReturnsTop() {
        stack.push("A");
        assertEquals("A", stack.peek());
        assertEquals(1, stack.size());
    }


    /**
     * Tests that pop throws EmptyStackException when stack is empty.
     */

    public void testPopEmptyThrows() {
        EmptyStackException thrown = null;
        try {
            stack.pop();
        }
        catch (EmptyStackException e) {
            thrown = e;
        }
        assertNotNull(thrown);
    }


    /**
     * Tests that pop removes and returns the top element.
     */

    public void testPopRemovesTop() {
        stack.push("A");
        stack.push("B");
        assertEquals(2, stack.size());

        String removed = stack.pop();
        assertEquals("B", removed);
        assertEquals(1, stack.size());
        assertEquals("A", stack.peek());
    }


    /**
     * Tests push and automatic capacity expansion.
     */

    public void testPushExpandsCapacity() {
        for (int i = 0; i < 100; i++) {
            stack.push("x" + i);
        }
        assertEquals(100, stack.size());

        stack.push("extra");
        assertEquals(101, stack.size());
        assertEquals("extra", stack.peek());
    }


    /**
     * Tests the contains method with normal elements.
     */

    public void testContains() {
        assertFalse(stack.contains("A"));

        stack.push("A");
        stack.push("B");

        assertTrue(stack.contains("A"));
        assertTrue(stack.contains("B"));
        assertFalse(stack.contains("C"));
    }


    /**
     * Tests contains when null is stored in the stack.
     */

    public void testContainsNull() {
        assertFalse(stack.contains(null));
        stack.push(null);
        assertTrue(stack.contains(null));
    }


    /**
     * Tests clearing the stack.
     */

    public void testClear() {
        stack.push("A");
        stack.push("B");
        assertEquals(2, stack.size());

        stack.clear();
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
        assertFalse(stack.contains("A"));
    }


    /**
     * Tests conversion of stack to array.
     */

    public void testToArray() {
        stack.push("A");
        stack.push("B");
        stack.push("C");

        Object[] arr = stack.toArray();
        assertEquals(3, arr.length);
        assertEquals("A", arr[0]);
        assertEquals("B", arr[1]);
        assertEquals("C", arr[2]);
    }


    /**
     * Tests string representation of the stack.
     */

    public void testToString() {
        assertEquals("[]", stack.toString());

        stack.push("A");
        assertEquals("[A]", stack.toString());

        stack.push("B");
        stack.push("C");
        assertEquals("[A, B, C]", stack.toString());
    }


    /**
     * Tests equality comparison between stacks.
     */

    public void testEquals() {

        assertTrue(stack.equals(stack));

        assertFalse(stack.equals(null));

        assertFalse(stack.equals("not a stack"));

        ArrayBasedStack<String> other = new ArrayBasedStack<>();

        assertTrue(stack.equals(other));

        stack.push("A");
        assertFalse(stack.equals(other));

        other.push("B");
        assertFalse(stack.equals(other));

        other.clear();
        other.push("A");
        stack.push("B");
        other.push("B");
        assertTrue(stack.equals(other));

        ArrayBasedStack<String> diffOrder = new ArrayBasedStack<>();
        diffOrder.push("B");
        diffOrder.push("A");
        assertFalse(stack.equals(diffOrder));
    }


    /**
     * Tests contains when searching for a null value that exists.
     */

    public void testContainsWithNullItemFound() {
        stack.push("A");
        stack.push(null); // null est dans la stack
        stack.push("B");

        assertTrue(stack.contains(null));
    }


    /**
     * Tests contains when searching for a null value that does not exist.
     */

    public void testContainsWithNullItemNotFound() {
        stack.push("A");
        stack.push("B");

        assertFalse(stack.contains(null));
    }


    public void testDebuggerViews()

    {

        // Put a breakpoint on the line below

        ArrayBasedStack<String> testStack = new ArrayBasedStack<String>();

        // Put a breakpoint on the line below. Use Step Over to see each push.

        testStack.push("blizzard");

        testStack.push("barrage");

        testStack.push("deadeye");

        testStack.push("resurrect");

        assertTrue(testStack.toString().equals(
            "[blizzard, barrage, deadeye, resurrect]"));

        // Put a breakpoint on the line below. Hit Step Over once to watch the
        // pop.

        testStack.pop();

        assertTrue(testStack.toString().equals("[blizzard, barrage, deadeye]"));

        Object[] toArrayResult = testStack.toArray();

        // Drop a breakpoint on the line below.

        // Use the debugger mode to compare toArrayResult to testStack.

        assertTrue(toArrayResult[0].toString().equals("blizzard"));

        assertEquals(toArrayResult.length, 3);

        // The following test fails because the stack still has entries in it.
        // However,

        // "expected <true> but was: <false>" is not very helpful.

        // Drop a breakpoint on the line below to see what the toString SHOULD
        // look like.

        assertTrue(testStack.toString().equals("[]"));

    }
}
