package b.streams;

import java.util.Arrays;
import java.util.List;

public class Demo5 {
	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 1, 3, 1, 4, 5, 2, 3);
		list.stream().peek(e -> System.out.println("===" + e)).distinct().forEach(System.out::println);

	}
}
