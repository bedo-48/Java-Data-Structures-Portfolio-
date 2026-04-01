package project1;

import bag.BagInterface;
import student.TestCase;
import student.TestableRandom;

/**
 * Tests for the DisplayCollection class.
 *
 * @author Obed Mavungu
 * @version 2026-02-07
 */
public class DisplayCollectionTest extends TestCase {

    /**
     * setUp method Intentionally left empty
     */
    public void setUp() {
        // intentionally empty
    }


    /**
     * Test that the bag size is between 5 and 15
     */
    public void testBagSize() {

        for (int i = 5; i <= 15; i++) {

            // Force the random number
            TestableRandom.setNextInts(i - 5);

            DisplayCollection dc = new DisplayCollection();
            BagInterface<String> bag = dc.getItemBag();

            assertEquals(i, bag.getCurrentSize());
        }
    }


    /**
     * Test that the bag only contains legal strings
     */
    public void testBagContents() {

        DisplayCollection dc = new DisplayCollection();
        BagInterface<String> bag = dc.getItemBag();

        while (!bag.isEmpty()) {

            String item = bag.remove();
            boolean found = false;

            for (String legal : DisplayCollection.STRINGS) {
                if (item.equals(legal)) {
                    found = true;
                }
            }

            assertTrue(found);
        }
    }
}
