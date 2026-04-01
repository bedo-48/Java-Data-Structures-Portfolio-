package collections;

import java.util.NoSuchElementException;

import student.TestCase;

/**
 * @author Obed Mavungu
 * @version 2026-02-05
 * 
 * 
 **
 * 
 *          Teste la classe NetvidsDatabase.
 */

public class NetvidsDatabaseTest extends TestCase {

    private NetvidsDatabase netvids;
    private Movie movie;

    /**
     * Configure l'environnement de test avant chaque test.
     */

    public void setUp() {
        netvids = new NetvidsDatabase();
        movie = new Movie("Spiderman");
    }


    /**
     * Teste que la base de données est initialement vide.
     */

    public void testIsEmptyInitially() {
        assertTrue(netvids.isEmpty());
        assertEquals(0, netvids.size());

    }


    /**
     * Teste l'ajout d'un film dans la base de données.
     */

    public void testAddMovie() {
        assertTrue(netvids.addMovie(movie));
        assertEquals(1, netvids.size());
        assertFalse(netvids.isEmpty());
        assertTrue(netvids.contains(movie));
    }


    /**
     * Teste que l'ajout d'un film en double échoue.
     */

    public void testAddDuplicateMovie() {
        assertTrue(netvids.addMovie(movie));
        assertFalse(netvids.addMovie(movie));
        assertEquals(1, netvids.size());
    }


    /**
     * Teste la suppression d'un film de la base de données.
     */

    public void testRemoveMovie() {
        netvids.addMovie(movie);

        assertEquals(1, netvids.size());

        Movie removed = netvids.remove(movie);
        assertEquals(movie, removed);

        assertEquals(0, netvids.size());
        assertFalse(netvids.contains(movie));
    }


    /**
     * Teste la méthode contains pour un film présent.
     */

    public void testContainsPresent() {
        netvids.addMovie(movie);
        assertTrue(netvids.contains(movie));

    }


    /**
     * Teste la méthode contains pour un film absent.
     */

    public void testContainsAbsent() {
        Movie other = new Movie("Batman");
        assertFalse(netvids.contains(other));

    }


    /**
     * Teste contains après suppression d'un film.
     */

    public void testContainsAfterRemove() {
        netvids.addMovie(movie);
        netvids.remove(movie);
        assertFalse(netvids.contains(movie));

    }


    /**
     * Teste l'expansion de capacité de la base de données en ajoutant plusieurs
     * films.
     */

    public void testExpandCapacity() {
        assertEquals(10, netvids.capacity());

        for (int i = 0; i < 10; i++) {
            netvids.addMovie(new Movie("Movie " + i));
        }

        assertEquals(10, netvids.size());
        assertEquals(10, netvids.capacity());

        // Force expansion
        netvids.addMovie(new Movie("Extra"));

        assertEquals(11, netvids.size());
        assertEquals(20, netvids.capacity());
    }


    /**
     * Test the remove null throw
     * 
     */
    public void testRemoveNullThrows() {

        Movie nullMovie = null;
        Exception exception = null;
        try {

            netvids.remove(nullMovie);

        }
        catch (IllegalArgumentException e) {
            exception = e;

        }
        assertNotNull(exception);
    }


    /**
     * Test the remove non existent movie
     */

    public void testRemoveNonexistentMovieThrows() {
        Movie nonExistent = new Movie("Nonexistent");
        Exception exception = null;
        try {
            netvids.remove(nonExistent);

        }
        catch (NoSuchElementException e) {
            exception = e;

        }
        assertNotNull(exception);
    }


    /**
     * Test the contains null and return false
     */

    public void testContainsNullReturnsFalse() {
        assertFalse(netvids.contains(null));
    }


    /**
     * 
     * Test the Is empty after remove
     */

    public void testIsEmptyAfterAddAndRemove() {
        netvids.addMovie(movie);
        assertFalse(netvids.isEmpty());
        netvids.remove(movie);
        assertTrue(netvids.isEmpty());
    }


    /**
     * 
     * Test the size and capacity
     */

    public void testSizeAndCapacity() {
        assertEquals(0, netvids.size());
        assertEquals(10, netvids.capacity());

        for (int i = 0; i < 11; i++) {
            netvids.addMovie(new Movie("Movie " + i));
        }

        assertEquals(11, netvids.size());

        assertTrue(netvids.capacity() > 10);

        assertTrue(netvids.contains(new Movie("Movie 0")));
        assertTrue(netvids.contains(new Movie("Movie 10")));

        netvids.addMovie(new Movie("Movie 0"));
        assertEquals(11, netvids.size());

    }

}
