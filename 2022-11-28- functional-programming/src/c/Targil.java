package c;

public class Targil {

	public static void main(String[] args) {

		Thread t = new Thread(() -> System.out.println("hello"));
		t.start();
	}

}
