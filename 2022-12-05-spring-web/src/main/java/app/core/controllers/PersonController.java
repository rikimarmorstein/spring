package app.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.core.entities.Person;
import app.core.services.PersonService;

@RestController
@RequestMapping("/api")
public class PersonController {

	@Autowired
	private PersonService personService;

	// http://localhost:8080?id=1
	@GetMapping
	public Person findPerson(@RequestParam int id) {
		return this.personService.getPerson(id);
	}

	@PostMapping
	public void createPerson(@RequestBody Person person) {
		person = this.personService.addPerson(person);
		System.out.println(person);
	}

	// http://localhost:8080/hello
	@RequestMapping(method = RequestMethod.POST, path = "/hello")
	public String hello() {
		String result = personService.hello();
		return result;
	}
}
