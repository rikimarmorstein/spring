package app.core.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.core.entities.Author;
import app.core.entities.Book;
import app.core.repositories.AuthorRepository;

@Component
public class Test implements CommandLineRunner {
//	@Autowired
//	private BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public void run(String... args) throws Exception {

		List<Book> books1 = new ArrayList<>();
		List<Book> books2 = new ArrayList<>();

		books1.add(new Book(0, "ddd", 2000));
		books1.add(new Book(0, "ccc", 1989));
		books2.add(new Book(0, "bbb", 1989));
		books2.add(new Book(0, "aaa", 1999));

		Author author1 = new Author(0, "Moshe", books1);
		Author author2 = new Author(0, "David", books2);
		authorRepository.save(author1);
		authorRepository.save(author2);

	}

}
