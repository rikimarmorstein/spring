
package c;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class FamilyCar implements Car {

	@Autowired
	private Engine engine;
	// @Value("${}")
	// private int maxSpeed;

	@Override
	public void start() {
		engine.turnOn();
		System.out.println("FamilyCar started");
	}

	@Override
	public void drive() {
		System.out.println("FamilyCar driving");
	}

	@Override
	public void stop() {
		engine.turnOff();
		System.out.println("FamilyCar stopped");
	}

}
