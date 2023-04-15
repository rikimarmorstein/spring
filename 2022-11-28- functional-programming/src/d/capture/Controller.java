package d.capture;

public class Controller {

	public int instanceVar = 1000;

	public Randomizer getRandomizer() {
		int localVar = 101;
		Randomizer r = () -> {
			int x = (int) (Math.random() * localVar + instanceVar);
			return x;
		};
		return r;
	}

	public static void main(String[] args) {
		Controller con = new Controller();
		Randomizer ran = con.getRandomizer();
		System.out.println(ran.get());
	}

}
