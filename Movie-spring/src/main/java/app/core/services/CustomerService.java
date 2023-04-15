package app.core.services;

import app.core.entities.Rate;
import app.core.exceptions.CinemaCustomException;

public interface CustomerService {

	Rate addRatingToMovie(Rate rate, int movieId) throws CinemaCustomException;

	void updateRating(int movieId, int rateId, Rate rate) throws CinemaCustomException;

}
