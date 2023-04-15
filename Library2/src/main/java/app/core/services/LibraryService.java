package app.core.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import app.core.entities.Book;
import app.core.entities.Library;
import app.core.repositories.BookRepo;
import app.core.repositories.LibraryRepo;

@Service
public class LibraryService {
	@Autowired
	private BookRepo bookRepo;
	@Autowired
	private LibraryRepo libraryRepo;

	public LibraryService(BookRepo bookRepo, LibraryRepo libraryRepo) {
		super();
		this.bookRepo = bookRepo;
		this.libraryRepo = libraryRepo;
	}

	@PostMapping
	public Library addLibrary(Library library) {
		if (!libraryRepo.existsById(library.getName())) {
			return libraryRepo.save(library);
		} else {
			throw new RuntimeException("addLibrary faild - already exists");
		}
	}

	public void addBookToLibrary(String libraryID, Book book) {
		Library library = libraryRepo.findById(libraryID).orElseThrow();
		library.addBook(book);
	}

	public Library getLibrary(String nameLibrary) {
		if (libraryRepo.existsById(nameLibrary)) {
			Optional<Library> opt = libraryRepo.findById(nameLibrary);
			Library library = opt.get();
			return library;
		} else {
			throw new RuntimeException("getLibrary faild - not exists");
		}
	}

	public Book getBook(String title) {
		// if (bookRepo.existsById(title)) {
		Optional<Book> opt = bookRepo.findById(title);
		if (opt.isPresent()) {
			Book book = opt.get();
			return book;
		} else {
			throw new RuntimeException("getBook faild - not exists");
		}
	}

	public List<Book> getAllBook() {
		List<Book> books = bookRepo.findAll();
		return books;
	}

	public List<Book> getAllBookFromLibrary(String nameLibrary) {
		List<Book> books = bookRepo.findAll();
		List<Book> booksLibrary = null;
		for (Book book : books) {
			if (book.getLibrary().getName() == nameLibrary) {
				booksLibrary = Arrays.asList(book);
			}
		}
		return booksLibrary;
	}

	public void updateBook(Book book) {
		if (bookRepo.existsById(book.getTitle())) {
			Book bookUpdate = getBook(book.getTitle());
			bookUpdate.setLibrary(book.getLibrary());
			bookUpdate.setAuthor(book.getAuthor());
			bookRepo.save(bookUpdate);
		}
	}

	public void deleteBook(String title) {
		if (bookRepo.existsById(title)) {
			bookRepo.deleteById(title);
		}

	}

}
