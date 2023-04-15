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
	public Author addAuthorWithBooks(Author author) throws LibraryCustomException {
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
		return authorRepository.findById(authorId)
				.orElseThrow(() -> new LibraryCustomException("id " + authorId + " not found"));
	}

	@Override
	public List<Book> getBooksFromYearToYear(int start, int end) throws LibraryCustomException {
		if (end < start) {
			throw new LibraryCustomException("Incorrect data, end date before start date");
		}
		return bookRepository.findAllByYearBetween(start, end);
	}

	@Override
	public int avrage() {
		return bookRepository.avgYear();
	}

	@Override
	public int avrageOfAuthor(int authorId) {
		return bookRepository.avgYearOfAuthor(authorId);
	}

}
