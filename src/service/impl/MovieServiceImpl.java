package service.impl;

import dao.impl.MovieDaoImpl;
import model.Movie;
import model.enums.Genre;
import service.MovieService;

import java.util.Comparator;
import java.util.List;

public class MovieServiceImpl implements MovieService {
    private static final String PATH = "movie.json";
    private final MovieDaoImpl movieDao = new MovieDaoImpl();
    private final List<Movie> movies = movieDao.readFromFile(PATH);

    @Override
    // TODO: 14.09.2023 вернуть фильм по ID
    public Movie findById(int movieId) {

        Movie newMovie = new Movie();
        for (Movie movie : movies) {
            if (movie.getId() == (movieId)) {
                newMovie = movie;
            }
        }
        return newMovie;
    }

    @Override
    // TODO: 14.09.2023 вернуть фильм по названию
    public Movie findByName(String name) {

        Movie newMovie = new Movie();
        for (Movie movie : movies) {
            if (movie.getName().equals(name)) {
                newMovie = movie;
            }
        }
        return newMovie;
    }

    @Override
    // TODO: 14.09.2023 вернуть отсортированный лист по дате создание
    public List<Movie> sortByDate() {

        movies.sort(Comparator.comparing(Movie::getCreateDate));
        return movies;
    }

    @Override
    // TODO: 14.09.2023 отфилтрововать все фильмы по жанру
    public List<Movie> filterByGenre(Genre genre) {

        movies.removeIf(movie -> !movie.getGenre().equals(genre));
        return movies ;
    }

    @Override
    // TODO: 14.09.2023 найти обьект по ID и изменить его состояние
    public void updateById(int movieId, Movie movie) {

        for (Movie movies : movies) {
            if (movies.getId() == (movieId)) {
                System.out.println("After\n" + movies);
                movies = movie;
                System.out.println("Before\n" + movies);
            }
        }
    }

}
