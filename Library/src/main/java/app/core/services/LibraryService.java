package app.core.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.entities.Book;
import app.core.entities.Library;
import app.core.repositories.BookRepo;
import app.core.repositories.LibraryRepo;

@Service
@Transactional
public class LibraryService {
	@Autowired
	private BookRepo bookRepo;
	@Autowired
	private LibraryRepo libraryRepo;

//	public LibraryService(BookRepo bookRepo, LibraryRepo libraryRepo) {
//		super();
//		this.bookRepo = bookRepo;
//		this.libraryRepo = libraryRepo;
//	}

	public Library addLibrary(Library library) {
		if (!libraryRepo.existsById(library.getName())) {
			return libraryRepo.save(library);
		} else {
			throw new RuntimeException("addLibrary faild - already exists");
		}
	}

	public void addBookToLibrary(Book book) {
		Optional<Library> opt = libraryRepo.findById(book.getLibrary().getName());
		if (opt.isPresent()) {
			if (!bookRepo.existsById(book.getTitle())) {
				bookRepo.save(book);
//				Library library = opt.get();
//				library.addBook(book);
			} else {
				throw new RuntimeException("addBook faild - already exists");
			}
		} else {
			throw new RuntimeException("addBookToLibrary faild - library not fount");
		}

	}

	public void addBookToLibrary2(String nameLibrary, Book book) {
		Library library = libraryRepo.findById(nameLibrary)
				.orElseThrow(() -> new RuntimeException("library not found"));
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
			if (book.getLibrary().getName().equals(nameLibrary)) {
				booksLibrary = Arrays.asList(book);
			}
		}
		return booksLibrary;
	}

	public void updateBook(Book book) {
		Optional<Book> opt = bookRepo.findById(book.getTitle());
		if (opt.isPresent()) {
			Book bookup = opt.get();
			bookup.setAuthor(book.getAuthor());
			bookRepo.save(bookup);
		} else {
			throw new RuntimeException("updateBook faild - not exists");
		}
	}

	public void deleteBook(String title) {
		if (bookRepo.existsById(title)) {
			bookRepo.deleteById(title);
		}

	}

	public void deleteLibrary(String nameLib) {
		if (libraryRepo.existsById(nameLib)) {
			libraryRepo.deleteById(nameLib);
		} else {
			throw new RuntimeException("deleteLibrary faild - not exists");

		}

	}

}
