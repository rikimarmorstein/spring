package app.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.core.entities.Book;
import app.core.entities.Library;
import app.core.services.LibraryService;

//@Controller
@RestController
@RequestMapping("/api")
public class LibraryController {

	@Autowired
	private LibraryService libraryService;

	@PostMapping("/")
	public void addLibrary(@RequestBody Library library) {
		libraryService.addLibrary(library);
	}

//	@PostMapping("/addBook")
//	public void addBook(@RequestBody Book book) {
//		libraryService.addBook(book);
//	}

	@PostMapping("/book")
	public void addBookToLibrary(@RequestBody Book book) {
		libraryService.addBookToLibrary(book);
	}

	@PostMapping("/booknew")
	public void addBookToLibrary2(@RequestParam String nameLibrary, @RequestBody Book book) {
		libraryService.addBookToLibrary2(nameLibrary, book);
	}

	@GetMapping(path = "/{nameLibrary}", produces = MediaType.APPLICATION_JSON_VALUE)
	Library getLibrary(@PathVariable String nameLibrary) {
		Library library = libraryService.getLibrary(nameLibrary);
		return library;
	}

	@GetMapping
	public Book getB(@RequestParam String tltl) {
		return libraryService.getBook(tltl);
	}

	@GetMapping("/allBooks")
	public List<Book> getAll() {
		List<Book> books = libraryService.getAllBook();
		return books;
	}

	@GetMapping("/allBooksOfLibrary")
	public List<Book> getAllOfLibrary(@RequestParam String nameLibrary) {
		List<Book> books = libraryService.getAllBookFromLibrary(nameLibrary);
		return books;
	}

	@DeleteMapping
	public void delete(String title) {
		libraryService.deleteBook(title);
	}

	@DeleteMapping("/")
	public void deleteLibrary(String nameLibrary) {
		libraryService.deleteLibrary(nameLibrary);
	}

	@PutMapping("/put")
	public void updateBook(@RequestBody Book book) {
		libraryService.updateBook(book);
	}

}
