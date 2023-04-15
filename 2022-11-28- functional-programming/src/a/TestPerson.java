package a;

import java.util.Arrays;
import java.util.List;

public class TestPerson {

	public static void main(String[] args) {

		Person p1 = new Person("bbb", 22);
		Person p2 = new Person("aaa", 12);
		Person p3 = new Person("ccc", 14);

		List<Person> list = Arrays.asList(p1, p2, p3);
		System.out.println(list);

//sort by name
		list.sort((x, y) -> x.getName().compareTo(y.getName()));
		System.out.println(list);
//sort by age
		list.sort((x, y) -> x.getAge() - y.getAge());
		System.out.println(list);

	}

}
