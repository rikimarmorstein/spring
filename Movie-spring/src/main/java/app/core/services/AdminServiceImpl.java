package app.core.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.entities.Movie;
import app.core.entities.Rate;
import app.core.entities.Rating;
import app.core.exceptions.CinemaCustomException;
import app.core.repositories.MovieRepository;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Movie addMovie(Movie movie) {
		Movie movieCreate = movieRepository.save(movie);
		return movieCreate;
	}

	public double getAvgRate(Movie movie) {
		double sum = 0;
		for (Rate rate : movie.getRates()) {
			sum += Rating.getRatingNumbers(rate.getRating());
		}
		return sum / movie.getRates().size();
	}

	public double getSumRate(Movie movie) {
		double sum = 0;
		for (Rate rate : movie.getRates()) {
			sum += Rating.getRatingNumbers(rate.getRating());
		}
		return sum;
	}

	@Override
	public void deleteMovie(int movieId) throws CinemaCustomException {
		Movie movieDelete = movieRepository.findById(movieId)
				.orElseThrow(() -> new CinemaCustomException("movie " + movieId + " not found"));
		if (getAvgRate(movieDelete) > 3.5) {
			throw new CinemaCustomException("Cannot be deleted - quality film is not deleted");
		}
		movieRepository.deleteById(movieId);
	}

	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public Movie getOneMovie(int movieId) throws CinemaCustomException {
		Movie movie = movieRepository.findById(movieId)
				.orElseThrow(() -> new CinemaCustomException("movie " + movieId + " not found"));
		return movie;
	}

	@Override
	public Movie getNewMovie() throws CinemaCustomException {
		int movieId = movieRepository.findByMaxYear();
		Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new CinemaCustomException("No movies"));
		return movie;
	}

	@Override
	public Movie getVeteranMovie() throws CinemaCustomException {
		int movieId = movieRepository.findByMinYear();
		Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new CinemaCustomException("No movies"));
		return movie;
	}

	@Override
	public List<Movie> getAllMoviesStartWith(String startLetter) {
		return movieRepository.findAllByNameStartingWith(startLetter);
	}

	@Override
	public List<Movie> getAllGoodMovies() {
		List<Movie> moviesFromDb = movieRepository.findAll();
		return moviesFromDb.stream().filter(m -> getAvgRate(m) > 3.5).collect(Collectors.toList());
	}

	@Override
	public List<Movie> getAllLikelyMovies() {
		List<Movie> moviesFromDb = movieRepository.findAll();
		return moviesFromDb.stream().filter(m -> getAvgRate(m) <= 3.5 && getAvgRate(m) >= 2.5)
				.collect(Collectors.toList());
	}

	@Override
	public List<Movie> getAllBadMovies() {
		List<Movie> moviesFromDb = movieRepository.findAll();
		return moviesFromDb.stream().filter(m -> getAvgRate(m) < 2.5).collect(Collectors.toList());
	}

	@Override
	public List<Movie> getAllGoodMoviesSortedBySumRating() {
		return getAllGoodMovies().stream().sorted(Comparator.comparingInt(m -> m.getRates().size()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Movie> getAllGoodMoviesSortedUp() {
		return getAllGoodMovies().stream().sorted(Comparator.comparingDouble(m -> getAvgRate((Movie) m)).reversed())
				.collect(Collectors.toList());
	}

	@Override
	public List<Movie> getAllGoodMoviesSortedDown() {
		return getAllGoodMovies().stream().sorted(Comparator.comparingDouble(m -> getAvgRate((Movie) m)))
				.collect(Collectors.toList());

	}

	@Override
	public double getSumRatingGoodMovie() {
//		Optional<Movie> mo = getAllGoodMovies().stream().max(Comparator.comparingDouble(m -> getAvgRate(m)));
//		Movie n = mo.get();
//		return getSumRate(n);
		return getSumRate(getAllGoodMovies().stream().max(Comparator.comparingDouble(m -> getAvgRate(m))).get());
	}

}
