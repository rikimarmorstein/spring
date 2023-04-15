package app.core.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import app.core.entities.Movie;

public class RestTemplateDemoAdmin {

	public static void main(String[] args) {

		RestTemplate rt = new RestTemplate();
		String url = "http://localhost:8080/api/movies";
		try {

			Movie movie = Movie.builder().name("seret").year(2000).build();
			Movie m = rt.postForObject(url + "/", movie, Movie.class);
			System.out.println(m);
			rt.delete(url + "/7");

			Movie[] movies1 = rt.getForObject(url + "/getAllMovies", Movie[].class);
			List<Movie> listMovies1 = Arrays.asList(movies1);
			System.out.println(listMovies1);
			rt.getForObject(url + "/getOneMovie/1", Movie.class);
			rt.getForObject(url + "/getNewMovie", Movie.class);
			rt.getForObject(url + "/getVeteranMovie", Movie.class);
			Movie[] movies2 = rt.getForObject(url + "/getAllMoviesStartWith", Movie[].class);
			List<Movie> listMovies2 = Arrays.asList(movies2);
			System.out.println(listMovies2);
			Movie[] movies3 = rt.getForObject(url + "/getAllGoodMovies", Movie[].class);
			List<Movie> listMovies3 = Arrays.asList(movies3);
			System.out.println(listMovies3);
			Movie[] movies4 = rt.getForObject(url + "/getAllLikelyMovies", Movie[].class);
			List<Movie> listMovies4 = Arrays.asList(movies4);
			System.out.println(listMovies4);
			rt.getForObject(url + "/getAllBadMovies", Movie[].class);
			rt.getForObject(url + "/getAllGoodMoviesSortedBySumRating", Movie[].class);
			rt.getForObject(url + "/getAllGoodMoviesSortedUp", Movie[].class);
			rt.getForObject(url + "/getAllGoodMoviesSortedDown", Movie[].class);
			double sum = rt.getForObject(url + "/getSumRatingGoodMovie", Double.class);
			System.out.println(sum);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
