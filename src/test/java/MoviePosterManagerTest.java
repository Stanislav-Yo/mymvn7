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
}
