package client;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import app.core.models.Car;

public class RestTemplateDemo {

	public static void main(String[] args) {

		RestTemplate rt = new RestTemplate();
		System.out.println("this is a rest TemplateDemo");

		String url = "http://localhost:8080/api/cars";
		RequestEntity<Car> request = RequestEntity.post(url).body(new Car(404, "white", "opel"));
		ResponseEntity<Car> respones = rt.exchange(request, Car.class);
		Car createCar = respones.getBody();
		System.out.println(createCar);

		System.out.println(respones.getStatusCodeValue());
		System.out.println(respones.getStatusCode());

	}

}
