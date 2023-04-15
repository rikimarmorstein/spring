package app.core.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.models.Car;

@RestController
@RequestMapping("/api/cars")
public class CarController {
	private List<Car> cars = new ArrayList<>();

	@Autowired
	private ConfigurableApplicationContext ctx;

	// create a resource on the server - HTTP Post method
	@PostMapping
	public Car addCar(@RequestBody Car car) {
		cars.add(car);
		System.out.println(cars);
		return car;
	}

	@GetMapping(path = "/{number}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getCar(@PathVariable int number) {
		Car car = new Car();
		car.setNumber(number);
		int index = this.cars.indexOf(car);
		if (index != -1) {
			return ResponseEntity.ok(cars.get(index));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("the car number " + number + " not found");
		}
	}

	@GetMapping
	public List<Car> getAll() {
		return cars;
	}

	@PutMapping
	public Car updateCar(@RequestBody Car car) {
		try {
			Car carIn = (Car) getCar(car.getNumber()).getBody();
			carIn.setColor(car.getColor());
			carIn.setMake(car.getMake());
			return carIn;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "car " + car.getNumber() + " not found");
		}
	}

	// delete a resource on the server - HTTP Delete method
	@DeleteMapping
	public ResponseEntity<String> deleteCar(int number) {
		Iterator<Car> it = cars.iterator();
		while (it.hasNext()) {
			if (it.next().getNumber() == number) {
				it.remove();
				return ResponseEntity.ok("delete seccessful");
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("delete failed -" + number + " not found");
	}

	@DeleteMapping("/2")
	public String deleteCar2(int number) {
		Iterator<Car> it = cars.iterator();
		while (it.hasNext()) {
			if (it.next().getNumber() == number) {
				it.remove();
				return "delete seccessful";
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "delete failed -" + number + " not found");
	}

	@GetMapping("/x")
	public void shutWeb() {
		ctx.close();
	}

	@PostConstruct
	void init() {
		cars.add(new Car(101, "red", "skoda"));
		cars.add(new Car(102, "green", "skoda"));
		cars.add(new Car(103, "red", "ford"));
	}

}
