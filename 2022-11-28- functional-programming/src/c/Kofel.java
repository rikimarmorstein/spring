package c;

public interface Kofel {

	int kfol(int val);

	static void doSomething() {
		System.out.println("doSomething");
	}

	default void doSomethingElse() {
		System.out.println("doSomething else");
	}

}
