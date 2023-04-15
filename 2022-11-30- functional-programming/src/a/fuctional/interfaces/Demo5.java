package a.fuctional.interfaces;

import java.util.function.Supplier;

public class Demo5 {

	public static void main(String[] args) {

		Supplier<Integer> randomizer = () -> (int) (Math.random() * 101);

		System.out.println(randomizer.get());
		System.out.println(randomizer.get());
		System.out.println(randomizer.get());
		System.out.println(randomizer.get());
		System.out.println(randomizer.get());
		System.out.println(randomizer.get());

		Supplier<Person2> personSupplier = () -> {

			Person2 p = new Person2();
			p.setAge(randomizer.get());
			String[] names = { "aaa", "sss", "ddd" };
			p.setName(names[randomizer.get() % names.length]);
			p.setId(id++);
			return p;

		};

		Person2 p1 = personSupplier.get();
		Person2 p2 = personSupplier.get();
		Person2 p3 = personSupplier.get();

		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
	}

	static int id = 101;
}

class Person2 {
	private int id;
	private String name;
	private int age;

	public Person2() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}