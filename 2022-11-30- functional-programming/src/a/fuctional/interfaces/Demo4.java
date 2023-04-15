package a.fuctional.interfaces;

import java.util.function.BinaryOperator;

public class Demo4 {

	public static void main(String[] args) {

		BinaryOperator<Integer> add = (a, b) -> a + b;
		BinaryOperator<Integer> add2 = Integer::sum;

		int sum = add.apply(5, 9);
		int sum2 = add.apply(5, 9);

		System.out.println(sum);
		System.out.println(sum2);

	}

}
