package app.core.advice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrDetails {
	private String what; // key
	private String why; // value
}
