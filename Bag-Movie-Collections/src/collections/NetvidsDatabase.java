package collections;

import java.util.NoSuchElementException;

public class NetvidsDatabase implements MovieCollection {

    private int size;
    private Movie[] movies;

    public NetvidsDatabase() {
        size = 0;
        movies = new Movie[10];
    }


    @Override
    public boolean addMovie(Movie movie) {
        if (movie == null) {
            return false;
        }
        if (contains(movie)) {
            return false;
        }
        if (size == movies.length) {
            expandCapacity();
        }
        movies[size++] = movie;
        return true;
    }


    @Override
    public Movie remove(Movie movie) {
        if (movie == null) {
            throw new IllegalArgumentException("Movie is null");
        }

        for (int i = 0; i < size; i++) {
            if (movies[i].equals(movie)) {
                Movie removed = movies[i];
                movies[i] = movies[size - 1];
                movies[size - 1] = null;
                size--;
                return removed;
            }
        }
        throw new NoSuchElementException("Movie not found");
    }


    @Override
    public boolean contains(Movie movie) {
        if (movie == null) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (movies[i].equals(movie)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public int size() {
        return size;
    }


    @Override
    public int capacity() {
        return movies.length;
    }


    private void expandCapacity() {
        Movie[] larger = new Movie[movies.length * 2];
        for (int i = 0; i < movies.length; i++) {
            larger[i] = movies[i];
        }
        movies = larger;
    }
}
