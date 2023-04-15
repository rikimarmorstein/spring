package a.fuctional.interfaces;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Demo2 {

	public static void main(String[] args) {

		Predicate<Integer> divideBySeven = t -> t % 7 == 0;
		if (divideBySeven.test(10)) {
			System.out.println("divide by 7");
		} else {
			System.out.println("divide by 7 not");
		}
		Predicate<Integer> greaterThan100 = x -> x > 100;
		if (greaterThan100.test(1200)) {
			System.out.println("greaterThan100");
		} else {
			System.out.println("greaterThan100 not");
		}
		Predicate<String> greaterThan25 = msg -> msg.length() <= 25;
		if (greaterThan25.test("cdscdsvdsfsdfsdfdsfdfdfdsfdsfdfdfdsfdsfdsfdsfcsd")) {
			System.out.println("this string is  ok");
		} else {
			System.out.println("this string is not ok ");
		}
		List<Integer> list = new ArrayList(Arrays.asList(2, 4, 6, 8, 1, 9, 7));
		System.out.println(list);
		list.removeIf(e -> e % 2 == 1);
		System.out.println(list);

		List<String> listString = new ArrayList(Arrays.asList("aaaaaa", "asd", "defrtgg"));
		System.out.println(listString);
		listString.removeIf(e -> e.length() > 5 && e.startsWith("a"));
		System.out.println(listString);

		Person p1 = new Person(1, "x", LocalDate.of(1992, 11, 11));
		Person p2 = new Person(2, "x", LocalDate.of(2012, 11, 11));
		Person p3 = new Person(3, "dd", LocalDate.of(2022, 11, 11));
		Person p4 = new Person(4, "x", LocalDate.of(2012, 11, 11));
		Person p5 = new Person(5, "x", LocalDate.of(2000, 11, 11));
		Person p6 = new Person(8, "x", LocalDate.of(2012, 11, 11));
		Person p7 = new Person(10, "x", LocalDate.of(2001, 11, 11));
		Person p8 = new Person(12, "x", LocalDate.of(2012, 11, 11));

		List<Person> persons = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8));

		persons.forEach(System.out::println);
		// persons.removeIf(e -> e.getTl().isBefore(LocalDate.of(2004, 11, 30)));
		persons.removeIf(e -> e.getTl().isAfter(LocalDate.now().minusYears(18)));

		System.out.println("===================");
		persons.forEach(System.out::println);
	}

}
