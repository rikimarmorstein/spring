package app.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.core.entities.Library;
import app.core.services.LibraryService;

@RestController
@RequestMapping("/api")
public class LibraryController {

	@Autowired
	private LibraryService libraryService;

	@PostMapping
	public void addLibrary(@RequestBody Library library) {
		libraryService.addLibrary(library);
	}

//	@GetMapping
//	public Book getB(String tltl) {
//		return libraryService.getBook(tltl);
//	}

}
