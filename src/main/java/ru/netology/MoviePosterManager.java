package ru.netology;

import lombok.Getter;

public class MoviePosterManager {
    private MoviePoster[] movies;
    private int size;
    @Getter
    private final int limit;

    public int getSize() {
        return size;
    }

    public MoviePoster[] getMovies() {
        return movies;
    }

    public MoviePosterManager() {
        this(5);
    }

    public MoviePosterManager(int limit) {
        this.movies = new MoviePoster[1];
        this.limit = limit;
        this.size = 0;
    }

    public void save(int minSize) {
        if (movies.length < minSize) {
            int newSize = movies.length * 2;
            if (newSize < minSize) {
                newSize = minSize;
            }

            MoviePoster[] newMovies = new MoviePoster[newSize];

            for (int i = 0; i < size; i++) {
                newMovies[i] = movies[i];
            }

            movies = newMovies;
        }
    }


    public void add(MoviePoster movie) {
        if (movie == null) {
            throw new IllegalArgumentException();
        }

        save(size + 1);
        movies[size++] = movie;
    }

    public String[] findAll() {
        String[] result = new String[size];
        for (int i = 0; i < size; i++) {
            result[i] = movies[i].getTitle();
        }
        return result;
    }

    public MoviePoster[] findLast() {
        int startIndex;
        if (size - limit < 0) {
            startIndex = 0;
        } else {
            startIndex = size - limit;
        }

        int length = 0;
        if (limit >= size - startIndex) {
            length = size - startIndex;
        }

        MoviePoster[] result = new MoviePoster[length];
        for (int i = 0; i < length; i++) {
            result[length - 1 - i] = movies[startIndex + i];
        }
        return result;
    }

}