package app.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.server.ResponseStatusException;

import app.core.entities.Book;
import app.core.entities.Library;
import app.core.entities.Reader;
import app.core.exceptions.LibraryException;
import app.core.services.LibraryService;

@RestController
@RequestMapping("/api/library")
public class LibraryController {

	@Autowired
	private LibraryService libraryService;

	@PostMapping("/addLibrary")
	public Library addLibrary(@RequestBody Library library) {
		try {
			return this.libraryService.addLibrary(library);
		} catch (LibraryException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@PostMapping(path = "/{libraryId}")
	public void addBookToLibrary(@RequestBody Book book, @PathVariable int libraryId) {
		try {
			this.libraryService.addBookToLibrary(book, libraryId);
		} catch (LibraryException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}

	@PostMapping("/addReader{bookId}")
	public void addReaderToBook(@RequestBody Reader reader, @PathVariable int bookId) {
		try {
			this.libraryService.addReaderToBook(reader, bookId);
		} catch (LibraryException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}

	@GetMapping("/find-library/{libraryId}")
	public Library findLibrary(@PathVariable int libraryId) {
		try {
			return this.libraryService.findLibrary(libraryId);
		} catch (LibraryException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@GetMapping("find-book")
	public Book findBook(@RequestParam(required = true) int bookId) {
		try {
			return this.libraryService.findBook(bookId);
		} catch (LibraryException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@GetMapping("all-books")
	public List<Book> getAllBooks() {
		return this.libraryService.getAllBooks();
	}

	@GetMapping("all-library-books")
	public List<Book> getAllBooks(@RequestParam(required = true) int libraryId) {
		return this.libraryService.getAllBooks(libraryId);
	}

	@GetMapping(path = "/{nameLibrary}", produces = MediaType.APPLICATION_JSON_VALUE)
	Library getLibrary(@PathVariable int nameLibrary) {
		Library library;
		try {
			library = libraryService.getLibrary(nameLibrary);
		} catch (LibraryException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());

		}
		return library;
	}

	@GetMapping
	public Book getB(@RequestParam int tltl) {
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
	public void delete(int title) {
		libraryService.deleteBook(title);
	}

	@DeleteMapping("/")
	public void deleteLibrary(int nameLibrary) {
		libraryService.deleteLibrary(nameLibrary);
	}

	@PutMapping("/put")
	public void updateBook(@RequestBody Book book) {
		libraryService.updateBook(book);
	}

}
