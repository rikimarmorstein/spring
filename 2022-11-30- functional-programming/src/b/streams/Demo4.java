package b.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo4 {

	public static void main(String[] args) {

		List<Person> list = new ArrayList<>();

		list.add(new Person(101, "Avi", 25));
		list.add(new Person(102, "Riki", 20));
		list.add(new Person(103, "Wal", 15));
		list.add(new Person(104, "Soli", 24));
		System.out.println(list);

		list.stream().peek(p -> {
			if (p.getAge() > 18) {
				p.setName(p.getName() + " Junior");
			} else {
				p.setName(p.getName() + " Senior");
			}
		}).forEach(p -> {
		});
		System.out.println(list);

		long count = Arrays.asList(1, 2, 3).stream().peek(System.out::println).filter(x -> x > 10).count();
		System.out.println(count);
	}

}
