package app.core.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

	@GetMapping(path = "/greet", produces = MediaType.TEXT_PLAIN_VALUE)
	public String greet(String name) {
		return "Hello<br>" + name;
	}

	@GetMapping("/add")
	public double add(@RequestParam double a, double b) {
		return a + b;
	}

	@GetMapping("/add/{a}/{b}")
	public double add2(@PathVariable double a, @PathVariable double b) {
		return a + b;
	}

}
