package app.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.entities.Author;
import app.core.entities.Book;
import app.core.exceptions.LibraryCustomException;
import app.core.services.LibraryService;

@RestController
@RequestMapping("/api/library")
public class LibraryController {
	@Autowired
	private LibraryService libraryServiceImpl;

	@PostMapping
	public Author addAuthorWithBooks(@RequestBody Author author) {
		try {
			return libraryServiceImpl.addAuthorWithBooks(author);
		} catch (LibraryCustomException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@DeleteMapping("/{authorId}")
	public void deleteAuthor(@PathVariable int authorId) throws LibraryCustomException {
		try {
			libraryServiceImpl.deleteAuthor(authorId);
		} catch (LibraryCustomException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@GetMapping("/getAllBooks")
	public List<Book> getAllBooks() {
		return libraryServiceImpl.getAllBooks();
	}

	@GetMapping("/getOneAuthor/{authorId}")
	public Author getOneAuthor(@PathVariable int authorId) throws LibraryCustomException {
		try {
			return libraryServiceImpl.getAuthor(authorId);
		} catch (LibraryCustomException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@GetMapping("/getBooksFromYearToYear/{start}/{end}")
	public List<Book> getBooksFromYearToYear(@PathVariable int start, @PathVariable int end)
			throws LibraryCustomException {
		try {
			return libraryServiceImpl.getBooksFromYearToYear(start, end);
		} catch (LibraryCustomException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@GetMapping("/avrage")
	public int avrage() {
		return libraryServiceImpl.avrage();
	}

	@GetMapping("/avrageOfAuthor/{authorId}")
	public int avrageOfAuthor(@PathVariable int authorId) {
		return libraryServiceImpl.avrageOfAuthor(authorId);
	}

}
