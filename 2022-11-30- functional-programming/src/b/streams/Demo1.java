package b.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Demo1 {
	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");

		Stream<String> stream = list.stream();

		stream = stream.map(str -> str.toUpperCase());

		stream.forEach(System.out::println);
	}

}
