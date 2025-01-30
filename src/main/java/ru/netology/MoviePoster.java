package ru.netology;

public class MoviePoster {
    private final String title;

    public MoviePoster(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MoviePoster)) {
            return false;
        }
        MoviePoster other = (MoviePoster) obj;
        return title.equals(other.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }
}
