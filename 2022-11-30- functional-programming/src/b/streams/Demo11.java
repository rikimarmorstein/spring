package b.streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Demo11 {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>(Arrays.asList(2, 4, 1, 6, 8));

		int min = set.stream().min((a, b) -> a - b).get();
		System.out.println(min);

		int max = set.stream().max((a, b) -> a - b).get();
		System.out.println(max);

		int sum = set.stream().reduce((acu, e) -> acu += e).get();
		System.out.println(sum);
	}

}
