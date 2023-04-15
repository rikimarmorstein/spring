package client;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class RestTemplateDemo5 {

	public static void main(String[] args) {

		RestTemplate rt = new RestTemplate();
		System.out.println("this is a rest TemplateDemo");

		String url = "http://localhost:8080/api/cars?number=102";

		try {
			rt.delete(url);

		} catch (RestClientException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
