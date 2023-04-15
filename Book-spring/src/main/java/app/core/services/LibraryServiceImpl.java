package app.core.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.entities.Author;
import app.core.entities.Book;
import app.core.exceptions.LibraryCustomException;
import app.core.repositories.AuthorRepository;
import app.core.repositories.BookRepository;

@Service
@Transactional
public class LibraryServiceImpl implements LibraryService {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public Author addAuthorWithBooks(Author author) {
		return authorRepository.save(author);
	}

	@Override
	public void deleteAuthor(int authorId) throws LibraryCustomException {
		authorRepository.findById(authorId)
				.orElseThrow(() -> new LibraryCustomException("id " + authorId + " not found"));
		authorRepository.deleteById(authorId);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Author getAuthor(int authorId) throws LibraryCustomException {
		Author author = authorRepository.findById(authorId)
				.orElseThrow(() -> new LibraryCustomException("id " + authorId + " not found"));
		return author;
	}

	@Override
	public List<Book> getBooksFromYearToYear(int start, int end) throws LibraryCustomException {
		if (start > end) {
			throw new LibraryCustomException("You entered a start date greater than an end date");
		}
		return bookRepository.findByYearBetween(start, end);
	}

	@Override
	public int avrage() {
		return bookRepository.avgYear();
	}

	@Override
	public int avrageOfAuthor(int authorId) {

		return bookRepository.avgYearOfLibrary(authorId);

	}

}
