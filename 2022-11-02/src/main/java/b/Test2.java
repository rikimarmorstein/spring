package b;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import c.Car;

public class Test2 {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class)) {

			Car car = ctx.getBean(Car.class);
			System.out.println("max speed = ");

			car.start();
			System.out.println("=======");
			car.drive();
			System.out.println("=======");
			car.stop();
			System.out.println("=======");

		}
	}

}
