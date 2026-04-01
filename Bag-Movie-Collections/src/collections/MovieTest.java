package collections;

import student.TestCase;

/**
 * 
 * @author Obed Mavungu
 * @version 2026-02-05
 * 
 */

public class MovieTest extends TestCase {

    private Movie movie;

    /**
     * Set up the test fixture
     */

    public void setUp()

    {

        movie = new Movie("Spiderman");
        movie.setGenre("Action");
        movie.setYear(2002);
        movie.setRating(4);
    }


    /**
     * Test getTitle()
     */

    public void testGetTitle() {
        assertEquals("Spiderman", movie.getTitle());

    }


    /**
     * Test getGenre()
     */

    public void testGetGenre() {
        assertEquals("Action", movie.getGenre());

    }


    /**
     * Tests setGenre().
     */

    public void testSetGenre() {
        movie.setGenre("Romance");
        assertEquals("Romance", movie.getGenre());

    }


    /**
     * Tests getYear() and setYear().
     */

    public void testGetSetYear() {
        assertEquals(2002, movie.getYear());
        movie.setYear(2010);
        assertEquals(2010, movie.getYear());

    }


    /**
     * Tests getRating() and setRating().
     */
    public void testGetSetRating() {
        assertEquals(4, movie.getRating());
        movie.setRating(5);
        assertEquals(5, movie.getRating());
    }


    /**
     * Tests equals with the same object.
     */

    public void testEqualsSameObject() {
        assertTrue(movie.equals(movie));
    }


    /**
     * Tests equals with null.
     */

    public void testEqualsNull() {
        assertFalse(movie.equals(null));
    }


    /**
     * Tests equals with same title.
     */

    public void testEqualsSameTitle() {
        Movie other = new Movie("Spiderman");
        assertTrue(movie.equals(other));
    }


    /**
     * Tests equals with different title.
     */
    public void testEqualsDifferentTitle() {
        Movie other = new Movie("Batman");
        assertFalse(movie.equals(other));
    }


    /**
     * Tests equals with a different object type.
     */
    public void testEqualsDifferentObject() {
        String notAMovie = "Spiderman";
        assertFalse(movie.equals(notAMovie));
    }

}
