package groceries;

// -------------------------------------------------------------------------
/**
 * The Grocery Bag class is a bag data structure that holds String objects that
 * represent grocery store items.
 *
 * @author Megan Rigsbee (mrigsbee)
 * @version 2015.04.25
 * @author Grace Fields
 * @version 2016.02.01
 */
public class GroceryBag extends ArrayBasedBag {
    // Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates an empty bag using the default capacity.
     */
    public GroceryBag() {
        super(10);
    }


    // Public methods ........................................................
    /**
     * If an element is in both bags, then it will be in the intersection. If
     * there are multiple occurrences of that element, then the number of
     * occurrences of that element in the intersection will equal the minimum
     * number of occurrences in either set.
     * 
     * Examples: intersection of ({"apple","apple","cereal","chips"}, {"chips",
     * "apple","apple","chips","cake"}) = {"apple","apple","chips"}
     * 
     * @param bag
     *            Bag to be intersected with.
     * @return The intersection of the two bags.
     */
    public GroceryBag intersection(GroceryBag bag) {
        // Implement this method

        GroceryBag result = new GroceryBag();

        String[] contents = this.contents();

        for (int i = 0; i < this.size(); i++) {
            String item = contents[i];

            int countThis = this.occurrence(item);
            int countOther = bag.occurrence(item);

            int minCount = Math.min(countThis, countOther);

            // Only add if not already fully added
            if (result.occurrence(item) < minCount) {
                result.add(item);
            }
        }

        return result;
    }


    /**
     * For two bags to be equal they need to contain items with the same names
     * and frequencies (so equality across specific attributes; identity is not
     * required). Order does not matter, but number of occurrences does.
     *
     * @param givenBag
     *            Other bag to be compared with for equality.
     * @return Returns true if the two bags have the same items.
     */
    @Override
    public boolean equals(Object givenBag) {
        // Implement this method

        if (this == givenBag) {
            return true;
        }
        if (givenBag == null) {
            return false;
        }
        if (this.getClass() != givenBag.getClass()) {
            return false;
        }

        GroceryBag other = (GroceryBag)givenBag;

        if (this.size() != other.size()) {
            return false;
        }
        String[] contents = this.contents();

        for (int i = 0; i < this.size(); i++) {
            String item = contents[i];

            if (this.occurrence(item) != other.occurrence(item)) {
                return false;
            }
        }

        return true;
    }
}
