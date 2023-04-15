package client;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import app.core.models.Car;

public class RestTemplateDemo6 {

	public static void main(String[] args) {

		RestTemplate rt = new RestTemplate();
		System.out.println("this is a rest TemplateDemo");

		String url = "http://localhost:8080/api/cars";

		try {

			Car[] car = rt.getForObject(url, Car[].class);
			List<Car> list = Arrays.asList(car);
			System.out.println(list);
		} catch (RestClientException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
