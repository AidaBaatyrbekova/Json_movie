import dao.impl.MovieDaoImpl;
import model.Movie;
import model.enums.Genre;
import service.impl.MovieServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // TODO: 14.09.2023 для началы работы необходимо положить 5 фильмов в JSON файл
        //  (для этого используйте метод writeToFile(String path, Movie movie); из класса MovieDao

        List<Movie> movies = new ArrayList<>(Arrays.asList(
                new Movie(5, "Name5", Genre.DETECTIVE, LocalDateTime.of(2007, 2, 13, 12, 45), "100.000.000"),
                new Movie(2, "Name2", Genre.HORROR, LocalDateTime.of(2020, 2, 13, 12, 45), "100.000.000"),
                new Movie(4, "Name4", Genre.ACTION, LocalDateTime.of(2023, 2, 13, 12, 45), "100.000.000"),
                new Movie(3, "Name3", Genre.THRILLER, LocalDateTime.of(2000, 2, 13, 12, 45), "100.000.000"),
                new Movie(1, "Name", Genre.DETECTIVE, LocalDateTime.of(3000, 2, 13, 12, 45), "100.000.000")
        ));

        MovieDaoImpl movieDao = new MovieDaoImpl();
        MovieServiceImpl movieService = new MovieServiceImpl();

        movieDao.writeToFile("movie.json", movies); //кладем фильмы в JSON файл
        System.out.println(movieDao.readFromFile("movie.json")); // считываем данные с файла

        movieService.updateById(1, new Movie(0, "sdfsd", Genre.DETECTIVE, LocalDateTime.now(), "100"));  // обновляем данные по айди
        System.out.println(movieService.findById(1)); // ищем фильм по айди
        System.out.println(movieService.findByName("Name")); // ищем фильм по имени
        System.out.println(movieService.sortByDate()); // возвращаем отсортированный лист по дате издания
        System.out.println(movieService.filterByGenre(Genre.DETECTIVE)); // возвращаем фильмы с отфильтрованным жанром
    }
}