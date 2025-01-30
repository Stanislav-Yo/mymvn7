package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoviePosterManagerTest {

    @Test
    void testSetsDefaultLimit() {
        MoviePosterManager manager = new MoviePosterManager();
        Assertions.assertEquals(5, manager.getLimit());
    }

    @Test
    void testSetsCustomLimit() {
        MoviePosterManager manager = new MoviePosterManager(3);
        Assertions.assertEquals(3, manager.getLimit());
    }

    @Test
    void testAddAndFindAll() {
        MoviePosterManager manager = new MoviePosterManager();

        manager.add(new MoviePoster("Бладшот"));
        manager.add(new MoviePoster("Вверх"));
        manager.add(new MoviePoster("Отель Белград"));
        manager.add(new MoviePoster("Джентльмены"));
        manager.add(new MoviePoster("Человек-невидимка"));
        manager.add(new MoviePoster("Тролли. Мировой Тур"));
        manager.add(new MoviePoster("Номер один"));

        String[] expected = {"Бладшот", "Вверх", "Отель Белград", "Джентльмены", "Человек-невидимка", "Тролли. Мировой Тур", "Номер один"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testFindLastWithDefaultLimit() {
        MoviePosterManager manager = new MoviePosterManager();

        manager.add(new MoviePoster("Бладшот"));
        manager.add(new MoviePoster("Вверх"));
        manager.add(new MoviePoster("Отель Белград"));
        manager.add(new MoviePoster("Джентльмены"));
        manager.add(new MoviePoster("Человек-невидимка"));
        manager.add(new MoviePoster("Тролли. Мировой Тур"));
        manager.add(new MoviePoster("Номер один"));

        MoviePoster[] expected = {new MoviePoster("Номер один"), new MoviePoster("Тролли. Мировой Тур"), new MoviePoster("Человек-невидимка"), new MoviePoster("Джентльмены"), new MoviePoster("Отель Белград")};
        MoviePoster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testFindLastWithCustomLimit() {
        MoviePosterManager manager = new MoviePosterManager(3);

        manager.add(new MoviePoster("Бладшот"));
        manager.add(new MoviePoster("Вверх"));
        manager.add(new MoviePoster("Отель Белград"));
        manager.add(new MoviePoster("Джентльмены"));
        manager.add(new MoviePoster("Человек-невидимка"));
        manager.add(new MoviePoster("Тролли. Мировой Тур"));
        manager.add(new MoviePoster("Номер один"));

        MoviePoster[] expected = {new MoviePoster("Номер один"), new MoviePoster("Тролли. Мировой Тур"), new MoviePoster("Человек-невидимка")};
        MoviePoster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testConstructorAndGetter() {
        String title = "Бладшот";
        MoviePoster poster = new MoviePoster(title);

        Assertions.assertEquals(title, poster.getTitle());
    }

    @Test
    void testSameObject() {
        MoviePoster poster1 = new MoviePoster("Бладшот");
        MoviePoster poster2 = poster1;

        Assertions.assertEquals(true, poster1.equals(poster2));
    }

    @Test
    void testDifferentObjectsSameTitle() {
        MoviePoster poster1 = new MoviePoster("Бладшот");
        MoviePoster poster2 = new MoviePoster("Бладшот");

        Assertions.assertEquals(true, poster1.equals(poster2));
    }

    @Test
    void testDifferentTitles() {
        MoviePoster poster1 = new MoviePoster("Бладшот");
        MoviePoster poster2 = new MoviePoster("Вверх");

        Assertions.assertEquals(false, poster1.equals(poster2));
    }

    @Test
    void testNull() {
        MoviePoster poster1 = new MoviePoster("Бладшот");
        Object poster2 = null;

        Assertions.assertEquals(false, poster1.equals(poster2));
    }

    @Test
    void testDifferentType() {
        MoviePoster poster1 = new MoviePoster("Бладшот");
        Object poster2 = new Object();

        Assertions.assertEquals(false, poster1.equals(poster2));
    }

    @Test
    void testDefaultConstructor() {
        MoviePosterManager manager = new MoviePosterManager();

        Assertions.assertEquals(5, manager.getLimit());
        Assertions.assertEquals(0, manager.getSize());
        Assertions.assertEquals(1, manager.getMovies().length);
    }

    @Test
    void testCustomConstructor() {
        int customLimit = 10;
        MoviePosterManager manager = new MoviePosterManager(customLimit);

        Assertions.assertEquals(customLimit, manager.getLimit());
        Assertions.assertEquals(0, manager.getSize());
        Assertions.assertEquals(1, manager.getMovies().length);
    }

    @Test
    void testAddSingleMovie() {
        MoviePosterManager manager = new MoviePosterManager();
        manager.add(new MoviePoster("Бладшот"));

        Assertions.assertEquals(1, manager.getSize());
        Assertions.assertEquals("Бладшот", manager.getMovies()[0].getTitle());
    }

    @Test
    void testAddMultipleMovies() {
        MoviePosterManager manager = new MoviePosterManager();
        manager.add(new MoviePoster("Бладшот"));
        manager.add(new MoviePoster("Вверх"));
        manager.add(new MoviePoster("Отель Белград"));

        Assertions.assertEquals(3, manager.getSize());
        Assertions.assertEquals("Бладшот", manager.getMovies()[0].getTitle());
        Assertions.assertEquals("Вверх", manager.getMovies()[1].getTitle());
        Assertions.assertEquals("Отель Белград", manager.getMovies()[2].getTitle());
    }

    @Test
    void testSaveDoesNotResize() {
        MoviePosterManager manager = new MoviePosterManager();
        manager.save(1);

        Assertions.assertEquals(1, manager.getMovies().length);
    }

    @Test
    void testHashCode() {
        MoviePoster poster1 = new MoviePoster("Бладшот");
        MoviePoster poster2 = new MoviePoster("Бладшот");

        Assertions.assertEquals(poster1.hashCode(), poster2.hashCode());
    }

    @Test
    void testFindLastFewerThanLimit() {
        MoviePosterManager manager = new MoviePosterManager(5);

        manager.add(new MoviePoster("Бладшот"));
        manager.add(new MoviePoster("Вверх"));

        MoviePoster[] expected = {new MoviePoster("Вверх"), new MoviePoster("Бладшот")};
        MoviePoster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testSaveResizesWhenNeeded() {
        MoviePosterManager manager = new MoviePosterManager();
        manager.save(4);

        Assertions.assertEquals(4, manager.getMovies().length);
    }

    @Test
    void testFindLastLessThanLimit() {
        MoviePosterManager manager = new MoviePosterManager(5);

        manager.add(new MoviePoster("Бладшот"));
        manager.add(new MoviePoster("Вверх"));
        manager.add(new MoviePoster("Отель Белград"));

        MoviePoster[] expected = {new MoviePoster("Отель Белград"), new MoviePoster("Вверх"), new MoviePoster("Бладшот")};
        MoviePoster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testFindLastWhenSizeIsGreaterThanLimit() {
        MoviePosterManager manager = new MoviePosterManager(3);

        manager.add(new MoviePoster("Бладшот"));
        manager.add(new MoviePoster("Вверх"));
        manager.add(new MoviePoster("Отель Белград"));
        manager.add(new MoviePoster("Джентльмены"));
        manager.add(new MoviePoster("Человек-невидимка"));
        manager.add(new MoviePoster("Тролли. Мировой Тур"));
        manager.add(new MoviePoster("Номер один"));

        MoviePoster[] expected = {new MoviePoster("Номер один"), new MoviePoster("Тролли. Мировой Тур"), new MoviePoster("Человек-невидимка")};
        MoviePoster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testFindLastWhenSizeSmallerThanLimit() {
        MoviePosterManager manager = new MoviePosterManager(7); // Лимит 7

        manager.add(new MoviePoster("Бладшот"));
        manager.add(new MoviePoster("Вверх"));
        manager.add(new MoviePoster("Отель Белград"));
        manager.add(new MoviePoster("Джентльмены"));

        MoviePoster[] expected = {new MoviePoster("Джентльмены"), new MoviePoster("Отель Белград"), new MoviePoster("Вверх"), new MoviePoster("Бладшот")};
        MoviePoster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testFindLastWhenSizeEqualToLimit() {
        MoviePosterManager manager = new MoviePosterManager(4); // Лимит 4

        manager.add(new MoviePoster("Бладшот"));
        manager.add(new MoviePoster("Вверх"));
        manager.add(new MoviePoster("Отель Белград"));
        manager.add(new MoviePoster("Джентльмены"));

        MoviePoster[] expected = {new MoviePoster("Джентльмены"), new MoviePoster("Отель Белград"), new MoviePoster("Вверх"), new MoviePoster("Бладшот")};
        MoviePoster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testSaveWhenMinSizeEqualsCurrentArrayLength() {
        MoviePosterManager manager = new MoviePosterManager();

        manager.add(new MoviePoster("Бладшот"));
        manager.save(manager.getMovies().length);

        Assertions.assertEquals(1, manager.getMovies().length);
    }

    @Test
    void testMinSizeLargerThanCurrentArrayLength() {
        MoviePosterManager manager = new MoviePosterManager();

        manager.add(new MoviePoster("Бладшот"));
        manager.save(3);

        Assertions.assertEquals(3, manager.getMovies().length);
    }

    @Test
    void testAddThrowsExceptionOnNull() {
        MoviePosterManager manager = new MoviePosterManager();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            manager.add(null);
        });
    }

}
