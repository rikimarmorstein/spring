package app.core.services;

import java.util.List;

import app.core.entities.Movie;
import app.core.exceptions.CinemaCustomException;

public interface AdminService {

	Movie addMovie(Movie movie);

	void deleteMovie(int movieId) throws CinemaCustomException;

	List<Movie> getAllMovies();

	Movie getOneMovie(int movieId) throws CinemaCustomException;

	Movie getNewMovie() throws CinemaCustomException;

	Movie getVeteranMovie() throws CinemaCustomException;

	List<Movie> getAllMoviesStartWith(String letter);

	List<Movie> getAllGoodMovies();

	List<Movie> getAllLikelyMovies();

	List<Movie> getAllBadMovies();

	List<Movie> getAllGoodMoviesSortedBySumRating();

	List<Movie> getAllGoodMoviesSortedUp();

	List<Movie> getAllGoodMoviesSortedDown();

	double getSumRatingGoodMovie();
}
