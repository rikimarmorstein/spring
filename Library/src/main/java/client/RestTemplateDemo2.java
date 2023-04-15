package client;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import app.core.entities.Book;
import app.core.entities.Library;

public class RestTemplateDemo2 {

	public static void main(String[] args) {

		RestTemplate rt = new RestTemplate();
		String url = "http://localhost:8080/api/fff";

		Library li = rt.getForObject(url, Library.class);
		System.out.println(li);

		String url1 = "http://localhost:8080/api/allBooksOfLibrary?nameLibrary=fff";

		try {

			Book[] books = rt.getForObject(url1, Book[].class);
			List<Book> list = Arrays.asList(books);
			System.out.println(list);

		} catch (RestClientException e) {
			System.out.println("Error: " + e.getMessage());
		}

		String url2 = "http://localhost:8080/api/allBooks";

		try {
			Book[] books = rt.getForObject(url2, Book[].class);
			List<Book> list = Arrays.asList(books);
			System.out.println(list);

		} catch (RestClientException e) {
			System.out.println("Error: " + e.getMessage());
		}

		String url3 = "http://localhost:8080/api?tltl=sa";

		try {
			Book book = rt.getForObject(url3, Book.class);
			System.out.println(book);

		} catch (RestClientException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
