
package groceries;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

/**
 * Tests the GroceryBag class methods.
 * 
 * @author Obed Mavungu
 * @version 2026-02-11
 */

public class GroceryBagTest {
    private GroceryBag bag1;
    private GroceryBag bag2;
    private GroceryBag bag3;
    private GroceryBag bag4;
    private GroceryBag bag5;

    /**
     * Sets up test bags before each test case.
     */

    @Before
    public void setUp() {

        bag1 = new GroceryBag();
        bag1.add("apples");
        bag1.add("chips");
        bag1.add("yogurt");
        bag1.add("chicken");
        bag1.add("pasta");

        bag2 = new GroceryBag();
        bag2.add("pizza");
        bag2.add("broccoli");
        bag2.add("pasta");
        bag2.add("pasta");
        bag2.add("apples");

        bag3 = new GroceryBag();
        bag3.add("apples");
        bag3.add("chicken");
        bag3.add("chicken");
        bag3.add("pasta");
        bag3.add("pizza");
        bag3.add("soda");
        bag3.add("yogurt");
        bag3.add("wheat");

        bag4 = new GroceryBag();
        bag4.add("chicken");
        bag4.add("chicken");
        bag4.add("pasta");
        bag4.add("pasta");
        bag4.add("yogurt");

        bag5 = new GroceryBag();
        bag5.add("pasta");
        bag5.add("yogurt");
        bag5.add("chicken");
        bag5.add("pasta");
        bag5.add("chicken");

    }


    /**
     * Tests equals when comparing to itself.
     */

    @Test
    public void testEqualsSelf() {
        assertTrue(bag1.equals(bag1));
    }


    /**
     * Tests equals when comparing to null.
     */

    @Test
    public void testEqualsNull() {
        assertFalse(bag1.equals(null));
    }


    /**
     * Tests equals when comparing to a different class.
     */

    @Test
    public void testEqualsDifferentClass() {
        assertFalse(bag1.equals("hello"));
    }


    /**
     * Tests equals when bags have different sizes.
     */

    @Test
    public void testEqualsDifferentSize() {
        assertFalse(bag1.equals(bag3));
    }


    /**
     * Tests equals when bags contain same items in different order.
     */

    @Test
    public void testEqualsTrue() {
        assertTrue(bag4.equals(bag5));
    }


    /**
     * Tests equals when frequencies differ.
     */

    @Test
    public void testEqualsFalseDifferentFrequencies() {
        assertFalse(bag1.equals(bag2));
    }


    /**
     * Tests intersection when bags are identical.
     */

    @Test
    public void testIntersectionBasic() {
        GroceryBag result = bag4.intersection(bag5);

        assertTrue(result.equals(bag4));
    }


    /**
     * Tests intersection when there are no common items.
     */

    @Test
    public void testIntersectionNoCommon() {
        GroceryBag empty = new GroceryBag();
        GroceryBag result = bag1.intersection(empty);

        assertTrue(result.isEmpty());
    }


    /**
     * Tests intersection when bags partially overlap.
     */

    @Test
    public void testIntersectionPartial() {
        GroceryBag result = bag1.intersection(bag2);

        assertTrue(result.contains("apples"));
        assertTrue(result.contains("pasta"));
    }

}
