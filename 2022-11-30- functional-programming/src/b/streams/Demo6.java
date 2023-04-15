package b.streams;

import java.util.Arrays;
import java.util.List;

public class Demo6 {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 1, 3, 1, 4, 5, 2, 3);
		boolean x = list.stream().anyMatch(e -> e == 4);
		System.out.println(x);
		boolean y = list.stream().allMatch(e -> e % 2 == 0);
		System.out.println(y);
		boolean r = list.stream().noneMatch(e -> e % 2 == 0);
		System.out.println(r);
	}

}
