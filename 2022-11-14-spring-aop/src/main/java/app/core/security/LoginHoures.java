package app.core.security;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.stereotype.Component;

@Component
public class LoginHoures {

	private LocalDateTime time14 = LocalDateTime.of(LocalDate.now(), LocalTime.of(14, 00, 00));
	private LocalDateTime time16 = LocalDateTime.of(LocalDate.now(), LocalTime.of(16, 00, 00));
	private boolean logged = true;

	public boolean login(LocalDateTime now) {
		if (now.isAfter(time14) && now.isBefore(time16)) {
			logged = false;
		}
		return logged;
	}

	public boolean isLogged() {
		return logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}

}
