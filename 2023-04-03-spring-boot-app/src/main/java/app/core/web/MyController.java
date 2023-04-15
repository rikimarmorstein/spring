package app.core.web;

import java.time.LocalTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jbt")
public class MyController {

	@GetMapping("/hello")
	public String Hello() {
		return "Hello Docker: " + LocalTime.now();
	}
}
