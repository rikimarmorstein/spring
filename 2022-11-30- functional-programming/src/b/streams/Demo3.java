package b.streams;

import java.util.ArrayList;
import java.util.List;

public class Demo3 {
	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("apple");
		list.add("Apple");
		list.add("Bananna");
		list.add("Orange");
		list.add("Peach");
		System.out.println(list);

		long startWithACount = list.stream().map(str -> str.toLowerCase()).filter(str -> str.startsWith("a")).count();
		System.out.println(list);
		System.out.println(startWithACount + " elements start with a or A");
	}
}
