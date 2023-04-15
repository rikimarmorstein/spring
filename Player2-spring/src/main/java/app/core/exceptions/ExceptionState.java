package app.core.exceptions;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionState {

	A_PLAYER_NOT_IN_TEAM("A player does not belong to your team", HttpStatus.BAD_REQUEST);

	private String msg;
	private HttpStatus httpStatus;

}
