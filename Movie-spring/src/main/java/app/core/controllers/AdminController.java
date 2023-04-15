package app.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import app.core.entities.Movie;
import app.core.exceptions.CinemaCustomException;
import app.core.services.AdminService;

@RestController
@RequestMapping("/api/movies")
public class AdminController {
	@Autowired
	private AdminService adminService;

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Movie addMovie(@RequestBody Movie movie) {
//		try {
		return adminService.addMovie(movie);
//		} catch (Exception e) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
//		}
	}

	@DeleteMapping("/{movieId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteMovie(@PathVariable int movieId) throws CinemaCustomException {
		adminService.deleteMovie(movieId);
	}

	@GetMapping("/getAllMovies")
	public List<Movie> getAllMovies() {
		return adminService.getAllMovies();
	}

	@GetMapping("/getOneMovie/{movieId}")
	public Movie getOneMovie(@PathVariable int movieId) throws CinemaCustomException {
		return adminService.getOneMovie(movieId);
	}

	@GetMapping("/getNewMovie")
	public Movie getNewMovie() throws CinemaCustomException {
		return adminService.getNewMovie();
	}

	@GetMapping("/getVeteranMovie")
	public Movie getVeteranMovie() throws CinemaCustomException {
		return adminService.getVeteranMovie();
	}

	@GetMapping("/getAllMoviesStartWith")
	public List<Movie> getAllMoviesStartWith(@RequestParam String startLetter) {
		return adminService.getAllMoviesStartWith(startLetter);
	}

	@GetMapping("/getAllGoodMovies")
	public List<Movie> getAllGoodMovies() {
		return adminService.getAllGoodMovies();
	}

	@GetMapping("/getAllLikelyMovies")
	public List<Movie> getAllLikelyMovies() {
		return adminService.getAllLikelyMovies();
	}

	@GetMapping("/getAllBadMovies")
	public List<Movie> getAllBadMovies() {
		return adminService.getAllBadMovies();
	}

	@GetMapping("/getAllGoodMoviesSortedBySumRating")
	public List<Movie> getAllGoodMoviesSortedBySumRating() {
		return adminService.getAllGoodMoviesSortedBySumRating();
	}

	@GetMapping("/getAllGoodMoviesSortedUp")
	public List<Movie> getAllGoodMoviesSortedUp() {
		return adminService.getAllGoodMoviesSortedUp();
	}

	@GetMapping("/getAllGoodMoviesSortedDown")
	public List<Movie> getAllGoodMoviesSortedDown() {
		return adminService.getAllGoodMoviesSortedDown();
	}

	@GetMapping("/getSumRatingGoodMovie")
	public double getSumRatingGoodMovie() {
		return adminService.getSumRatingGoodMovie();
	}
}
