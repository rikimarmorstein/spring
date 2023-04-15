package app.core.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import app.core.entities.Author;
import app.core.entities.Book;

public class Demo {

	public static void main(String[] args) {

		RestTemplate rt = new RestTemplate();
		String url = "http://localhost:8080/api/library";
		try {

			List<Book> bookDan = new ArrayList<>();
			bookDan.add(new Book(0, "shemesh", 1999, null));
			bookDan.add(new Book(0, "gilim", 2001, null));
			// Author author = Author.builder().name("Dan").build();
			Author author = new Author(0, "Dan", bookDan);
			Author authorNew = rt.postForObject(url, author, Author.class);
			System.out.println(authorNew);

			rt.delete(url + "/2");

			Book[] books = rt.getForObject(url + "/getAllBooks", Book[].class);
			List<Book> allBooks = Arrays.asList(books);
			System.out.println(allBooks);

			Author getAuthor = rt.getForObject(url + "/getOneAuthor/1", Author.class);
			System.out.println(getAuthor);

			Book[] booksYear = rt.getForObject(url + "/getBooksFromYearToYear/1989/2000", Book[].class);
			List<Book> allBooksYear = Arrays.asList(booksYear);
			System.out.println(allBooksYear);

			int avg = rt.getForObject(url + "/avrage", Integer.class);
			System.out.println(avg);

			int avgOfAuthor = rt.getForObject(url + "/avrageOfAuthor/1", Integer.class);
			System.out.println(avgOfAuthor);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
