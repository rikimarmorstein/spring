package app.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import app.core.entities.Rate;
import app.core.exceptions.CinemaCustomException;
import app.core.services.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping("/{movieId}")
	@ResponseStatus(HttpStatus.CREATED)
	public Rate addRatingToMovie(@RequestBody Rate rate, @PathVariable int movieId) throws CinemaCustomException {
//		try {
		customerService.addRatingToMovie(rate, movieId);
		return rate;
//		} catch (Exception e) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
//		}
	}

	@PutMapping("/{movieId}/{rateId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateRating(@PathVariable int movieId, @PathVariable int rateId, @RequestBody Rate rate)
			throws CinemaCustomException {
		customerService.updateRating(movieId, rateId, rate);

	}

}
