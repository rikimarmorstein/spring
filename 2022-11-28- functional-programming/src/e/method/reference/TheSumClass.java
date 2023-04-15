package e.method.reference;

import java.util.Arrays;
import java.util.List;

public class TheSumClass {

	private int sum = 100;

	public void add(int val) {
		sum += val;
	}

	public int getSum() {
		return sum;
	}

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(2, 4, 6);
		TheSumClass subClass = new TheSumClass();
		list.forEach(subClass::add);
		System.out.println(subClass.getSum());

	}

}
