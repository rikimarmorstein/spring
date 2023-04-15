package b.streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Demo9 {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>(Arrays.asList(2, 4, 6, 8));
		Integer x = set.stream().findAny().orElseGet(() -> null);
		System.out.println(x);
	}

}
