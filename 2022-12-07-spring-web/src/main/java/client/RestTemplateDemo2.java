package client;

import org.springframework.web.client.RestTemplate;

import app.core.models.Car;

public class RestTemplateDemo2 {

	public static void main(String[] args) {

		RestTemplate rt = new RestTemplate();
		System.out.println("this is a rest TemplateDemo");

		String url = "http://localhost:8080/api/cars";

		Car car = new Car(306, "silver", "audi");
		Car createCar = rt.postForObject(url, car, Car.class);
		System.out.println(createCar);

	}

}
