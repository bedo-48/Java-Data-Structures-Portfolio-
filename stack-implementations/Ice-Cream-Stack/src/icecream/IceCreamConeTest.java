package icecream;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the IceCreamCone class.
 * 
 * @author Obed Mavungu
 * @version 2026-02-18
 */
public class IceCreamConeTest {

    private IceCreamCone cone;

    /**
     * Creates a fresh IceCreamCone before each test.
     */
    @Before
    public void setUp() {
        cone = new IceCreamCone();
    }


    /**
     * Tests that a newly created cone is empty and has 0 scoops.
     */
    @Test
    public void testNewConeIsEmpty() {
        assertTrue(cone.emptyCone());
        assertEquals(0, cone.numScoops());
        assertEquals("[]", cone.toString());
    }


    /**
     * Tests that addScoop pushes flavors onto the top of the cone and updates
     * the scoop count and string representation.
     */
    @Test
    public void testAddScoop() {
        cone.addScoop("Vanilla");

        assertFalse(cone.emptyCone());
        assertEquals(1, cone.numScoops());
        assertEquals("Vanilla", cone.currentScoop());
        assertEquals("[Vanilla]", cone.toString());

        cone.addScoop("Chocolate");

        assertEquals(2, cone.numScoops());
        assertEquals("Chocolate", cone.currentScoop());
        assertEquals("[Vanilla, Chocolate]", cone.toString());
    }


    /**
     * Tests that eatScoop removes and returns the top scoop (LIFO behavior)
     * and updates the scoop count.
     */
    @Test
    public void testEatScoop() {
        cone.addScoop("Vanilla");
        cone.addScoop("Chocolate");

        String eaten = cone.eatScoop();

        assertEquals("Chocolate", eaten);
        assertEquals(1, cone.numScoops());
        assertEquals("Vanilla", cone.currentScoop());
    }


    /**
     * Tests that contains returns true when a flavor exists in the cone
     * and false when it does not.
     */
    @Test
    public void testContains() {
        cone.addScoop("Vanilla");
        cone.addScoop("Chocolate");

        assertTrue(cone.contains("Vanilla"));
        assertFalse(cone.contains("Mint"));
    }


    /**
     * Tests that two cones with the same flavors in the same order are equal.
     */
    @Test
    public void testEquals() {
        IceCreamCone a = new IceCreamCone();
        IceCreamCone b = new IceCreamCone();

        a.addScoop("Vanilla");
        a.addScoop("Chocolate");

        b.addScoop("Vanilla");
        b.addScoop("Chocolate");

        assertEquals(a, b);
    }
}
