package app.core.advice;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import app.core.exception.CatsCustomException;

@RestControllerAdvice
public class CatControllerAdvice {

	@ExceptionHandler(CatsCustomException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST) // 400
	public ErrDetails handleCatSystemExcptions(CatsCustomException e) {
		return new ErrDetails("Cats System Exception: ", e.getMessage());
	}

	@ExceptionHandler(SQLException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST) // 400
	public ErrDetails handleCatSystemExcptions(SQLException e) {
		return new ErrDetails("SQL Exception: ", e.getMessage());
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST) // 400
	public ErrDetails handleCatSystemExcptions(Exception e) {
		return new ErrDetails("Exception: ", e.getMessage());
	}

}
