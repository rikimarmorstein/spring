package f.fuctional.interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Demo2 {

	public static void main(String[] args) {

		Predicate<Integer> divideBySeven = t -> t % 7 == 0;

		Predicate<Integer> greaterThan100 = x -> x > 100;

		Predicate<String> greaterThan25 = msg -> msg.length() <= 25;

		List<Integer> list = new ArrayList();
		list.addAll(Arrays.asList(2, 4, 6, 8, 1, 9, 7));
		System.out.println(list);
		list.removeIf(e -> e % 2 == 1);
		System.out.println(list);

	}

}
