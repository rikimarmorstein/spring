package c;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		Calculator c1 = (x, y) -> x / y;
		System.out.println(c1.divide(100, 25));

		Calculator c2 = (a, b) -> {
			double res = a / b;
			return res;
		};
		// Calculator c = new Calculator() {
//			@Override
//			public double add(double a, double b) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//			//			@Override
//			public double divide(double a, double b) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//		}
		System.out.println(c2.divide(100, 25));

		List<Integer> list = Arrays.asList(2, 4, 6);
		System.out.println(list);
	}

}
