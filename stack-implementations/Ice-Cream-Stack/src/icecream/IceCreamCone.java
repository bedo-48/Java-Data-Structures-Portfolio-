package icecream;

import java.util.Stack;

/**
 * Represents an ice cream cone implemented using a Stack of flavors.
 * 
 * @author Obed Mavungu
 * @version 2026-03-18
 */
public class IceCreamCone implements IceCreamConeADT {

    private Stack<String> flavors;
    private int numScoops;

    /**
     * Creates an empty ice cream cone.
     */
    public IceCreamCone() {
        flavors = new Stack<>();
        numScoops = 0;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String eatScoop() {
        numScoops--;
        return flavors.pop(); // Stack.pop()
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void addScoop(String flavor) {
        flavors.push(flavor); // Stack.push()
        numScoops++;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public int numScoops() {
        return numScoops;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(String flavor) {
        return flavors.contains(flavor); // inherited from Vector
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public boolean emptyCone() {
        return flavors.empty(); // Stack.empty()
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String currentScoop() {
        return flavors.peek(); // Stack.peek()
    }


    /**
     * Returns string representation using Stack's implementation.
     */
    @Override
    public String toString() {
        return flavors.toString(); // Stack.toString()
    }


    /**
     * Equality based on Stack equality (same elements, same order).
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other == null) || (other.getClass() != this.getClass())) {
            return false;
        }
        return flavors.equals(((IceCreamCone) other).flavors);
    }
}
