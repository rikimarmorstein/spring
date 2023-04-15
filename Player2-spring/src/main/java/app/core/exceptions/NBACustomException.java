package app.core.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

public class NBACustomException extends Exception {

	private static final long serialVersionUID = 1L;

	@Getter
	private HttpStatus httpStatus;
	@Getter
	private ExceptionState exceptionState;

/////////////////
	public NBACustomException(String msg, HttpStatus httpStatus) {
		super(msg);
		this.httpStatus = httpStatus;
	}

	public NBACustomException(ExceptionState exceptionState) {
		super();
		this.exceptionState = exceptionState;
	}

	public NBACustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NBACustomException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NBACustomException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NBACustomException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public NBACustomException(HttpStatus httpStatus) {
		super();
		this.httpStatus = httpStatus;
	}

}
