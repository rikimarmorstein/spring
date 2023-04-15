package b.streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Demo10 {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>(Arrays.asList(2, 4, 1, 6, 8));
		System.out.println(set);
		Integer[] arr = set.stream().map(e -> e * 2).toArray(size -> new Integer[size]);
		System.out.println(Arrays.toString(arr));
	}

}
