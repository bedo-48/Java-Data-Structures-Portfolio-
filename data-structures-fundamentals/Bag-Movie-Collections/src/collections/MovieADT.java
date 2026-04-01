package collections;

/**
 * Abstract data type representing a movie.
 *
 * @author Obed Mavungu
 * @version 2026-02-05
 */
public abstract class MovieADT {

    private String title;
    private String genre;
    private int rating;
    private int year;

    /**
     * Creates a MovieADT with the given title.
     *
     * @param title
     *            the movie title
     */
    public MovieADT(String title) {
        this.title = title;
    }


    /**
     * Returns the movie title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }


    /**
     * Returns the movie genre.
     *
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }


    /**
     * Sets the movie genre.
     *
     * @param genre
     *            the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }


    /**
     * Returns the movie rating.
     *
     * @return the rating
     */
    public int getRating() {
        return rating;
    }


    /**
     * Sets the movie rating.
     *
     * @param rating
     *            the rating to set
     */
    public void setRating(int rating) {
        this.rating = rating;
    }


    /**
     * Returns the release year.
     *
     * @return the year
     */
    public int getYear() {
        return year;
    }


    /**
     * Sets the release year.
     *
     * @param year
     *            the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }


    /**
     * Compares two movies by title.
     *
     * @param obj
     *            the object to compare
     * @return true if titles are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MovieADT)) {
            return false;
        }
        MovieADT other = (MovieADT)obj;
        return title != null && title.equals(other.title);
    }
}
