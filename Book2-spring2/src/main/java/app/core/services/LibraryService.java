package app.core.services;

import java.util.List;

import app.core.entities.Author;
import app.core.entities.Book;
import app.core.exceptions.LibraryCustomException;

public interface LibraryService {

	Author addAuthorWithBooks(Author author) throws LibraryCustomException;

	void deleteAuthor(int authorId) throws LibraryCustomException;

	List<Book> getAllBooks();

	Author getAuthor(int authorId) throws LibraryCustomException;

	List<Book> getBooksFromYearToYear(int start, int end) throws LibraryCustomException;

	int avrage();

	int avrageOfAuthor(int authorId);

}
