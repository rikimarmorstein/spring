package client;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import app.core.models.Car;

public class RestTemplateDemo3 {

	public static void main(String[] args) {

		RestTemplate rt = new RestTemplate();
		System.out.println("this is a rest TemplateDemo");

		String url = "http://localhost:8080/api/cars/101";
		try {

			Car car = rt.getForObject(url, Car.class);
			System.out.println(car);
		} catch (RestClientException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
