package client;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import app.core.entities.Book;

public class RestTemplateDemo3 {

	public static void main(String[] args) {

		RestTemplate rt = new RestTemplate();
		String url = "http://localhost:8080/api";

		try {
			String name = "sa";
			rt.delete(url, name);

		} catch (RestClientException e) {
			System.out.println("Error: " + e.getMessage());
		}

		String url2 = "http://localhost:8080/api/";

		try {
			String name = "sa";
			rt.delete(url2, name);

		} catch (RestClientException e) {
			System.out.println("Error: " + e.getMessage());
		}

		String url3 = "http://localhost:8080/api/put";

		try {
			Book book = Book.builder().title("gil").author("ggg").build();
			rt.put(url3, book);

		} catch (RestClientException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
