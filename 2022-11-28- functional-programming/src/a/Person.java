package a;

public class Person {

	private String name;
	private int age;

	public Person() {

	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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

	public void speak() {
		System.out.println("bla");
	}

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.speak();

		Person p2 = new Person() {

			@Override
			public void speak() {
				System.out.println("bla bla");
			}

		};
		p2.speak();

	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
