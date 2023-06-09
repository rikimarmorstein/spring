package e.method.reference;

import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {

		// lambda expression
		Printer printer1 = msg -> System.out.println(msg);
		printer1.print("this is my message");

		// method reference
		Printer printer2 = System.out::println;
		printer2.print("this is my message");

		List<Integer> list = Arrays.asList(2, 4, 6, 8);
		list.forEach(System.out::println);

		TheSumClass subClass = new TheSumClass();
		list.forEach(subClass::add);
		System.out.println(subClass.getSum());
	}

}
