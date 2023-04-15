package app.core.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.entities.Movie;
import app.core.entities.Rate;
import app.core.exceptions.CinemaCustomException;
import app.core.repositories.MovieRepository;
import app.core.repositories.RateRepository;

@Service
@Transactional
public class CustomrServiceImpl implements CustomerService {

	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private RateRepository rateRepository;

	@Override
	public Rate addRatingToMovie(Rate rate, int movieId) throws CinemaCustomException {
		Movie movieRfomDb = movieRepository.findById(movieId)
				.orElseThrow(() -> new CinemaCustomException("movie " + movieId + " not found"));
		movieRfomDb.addRate(rate);
		return rate;
	}

	@Override
	public void updateRating(int movieId, int rateId, Rate rate) throws CinemaCustomException {
		Rate rateUpdate = rateRepository.findById(rateId)
				.orElseThrow(() -> new CinemaCustomException("rate " + rateId + " not found"));
		int a = rateRepository.existsRateOfMovie(movieId, rateId);
		if (a == 0) {
			throw new CinemaCustomException("rate " + rateId + " not found in this movie");
		}
		rateUpdate.setComment(rate.getComment());
		rateUpdate.setName(rate.getName());
		rateUpdate.setRating(rate.getRating());
		rateRepository.save(rateUpdate);
	}

}
