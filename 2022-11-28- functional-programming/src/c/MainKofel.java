package c;

public class MainKofel {

	public static void main(String[] args) {

		Kofel k1 = a -> a * 2;
		System.out.println(k1.kfol(3));

		Kofel k2 = a -> a * 5;
		System.out.println(k2.kfol(3));

		Kofel k3 = a -> a * 100;
		System.out.println(k3.kfol(3));

	}

}
