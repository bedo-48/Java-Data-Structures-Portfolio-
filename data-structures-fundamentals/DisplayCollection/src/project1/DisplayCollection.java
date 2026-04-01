/**
 * 
 */
package project1;

import bag.Bag;

import bag.BagInterface;

import student.TestableRandom;

/**
 * The DisplayCollection class creates and stores a collection of shape
 * descriptions inside a bag. This bag is later provided to other classes
 * for display purposes.
 *
 * @author Obed Mavungu
 * @version 2026-02-07
 */
public class DisplayCollection {

    /**
     * Constant array of shape descriptions that can be added to the bag.
     */

    public static final String[] STRINGS = {

        "red circle", "blue circle", "red square", "blue square" };

    private BagInterface<String> itemBag;

    /**
     * Constructs a DisplayCollection and fills the bag with a random
     * number of shape descriptions.
     */

    public DisplayCollection() {
        itemBag = new Bag<>();

        TestableRandom random = new TestableRandom();

        int count = random.nextInt(11) + 5;

        for (int i = 0; i < count; i++) {

            int index = random.nextInt(STRINGS.length);
            itemBag.add(STRINGS[index]);

        }

    }


    /**
     * Returns the bag containing the shape descriptions.
     *
     * @return the bag of items
     */

    public BagInterface<String> getItemBag() {

        return itemBag;
    }

}
