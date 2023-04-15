package b.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo7 {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 1, 3, 1, 4, 5, 2, 3);
		System.out.println(list);

		List<Integer> distinct = list.stream().distinct().collect(Collectors.toList());
		System.out.println(distinct);
	}

}
