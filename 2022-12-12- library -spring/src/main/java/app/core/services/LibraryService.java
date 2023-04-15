package app.core.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.entities.Book;
import app.core.entities.Library;
import app.core.entities.Reader;
import app.core.exceptions.LibraryException;
import app.core.repositories.BookRepo;
import app.core.repositories.LibraryRepo;
import app.core.repositories.ReaderRepo;

@Service
@Transactional
public class LibraryService {
	@Autowired
	private BookRepo bookRepo;
	@Autowired
	private LibraryRepo libraryRepo;
	@Autowired
	private ReaderRepo readerRepo;

//	public LibraryService(BookRepo bookRepo, LibraryRepo libraryRepo) {
//		super();
//		this.bookRepo = bookRepo;
//		this.libraryRepo = libraryRepo;
//	}

	public Library addLibrary(Library library) throws LibraryException {
		if (libraryRepo.existsByName(library.getName())) {
			throw new LibraryException("addLibrary faild - " + library.getName() + " already exists");
		}
		if (libraryRepo.existsById(library.getId())) {
			throw new LibraryException("addLibrary faild - " + library.getId() + " already exists");
		}
		return libraryRepo.save(library);
	}

	public void addBookToLibrary(Book book, int libraryID) throws LibraryException {
		Library library = libraryRepo.findById(libraryID)
				.orElseThrow(() -> new LibraryException("addBookToLibrary - library not found"));
		if (libraryRepo.existsByIdAndBooksTitle(libraryID, book.getTitle())) {
			throw new LibraryException("addBook faild - title's book already exists in this library");

		}
		library.addBook(book);
	}

	public void addReaderToBook(Reader reader, int bookId) throws LibraryException {
		if (!readerRepo.existsById(reader.getId())) {
			readerRepo.save(reader);
		}
		Book book = bookRepo.findById(bookId).orElseThrow(() -> new LibraryException("book not found"));
		book.addReader(reader);
	}

	public Library findLibrary(int libraryId) throws LibraryException {
		return libraryRepo.findById(libraryId)
				.orElseThrow(() -> new LibraryException("findLibrary failed - not found"));
	}

	public Book findBook(int bookId) throws LibraryException {
		return bookRepo.findById(bookId).orElseThrow(() -> new LibraryException("findBook failed - not found"));
	}

	public List<Book> getAllBooks() {
		return this.bookRepo.findAll();
	}

	public List<Book> getAllBooks(int libraryId) {
		return this.bookRepo.findByLibraryId(libraryId);
	}

	public Library getLibrary(int nameLibrary) throws LibraryException {
		if (libraryRepo.existsById(nameLibrary)) {
			Optional<Library> opt = libraryRepo.findById(nameLibrary);
			Library library = opt.get();
			return library;
		} else {
			throw new LibraryException("getLibrary faild - not exists");
		}
	}

	public Book getBook(int title) {
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
		Optional<Book> opt = bookRepo.findById(book.getId());
		if (opt.isPresent()) {
			Book bookup = opt.get();
			bookup.setAuthor(book.getAuthor());
			bookRepo.save(bookup);
		} else {
			throw new RuntimeException("updateBook faild - not exists");
		}
	}

	public void deleteBook(int title) {
		if (bookRepo.existsById(title)) {
			bookRepo.deleteById(title);
		}

	}

	public void deleteLibrary(int nameLib) {
		if (libraryRepo.existsById(nameLib)) {
			libraryRepo.deleteById(nameLib);
		} else {
			throw new RuntimeException("deleteLibrary faild - not exists");

		}

	}

}
