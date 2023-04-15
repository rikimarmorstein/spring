package a.fuctional.interfaces;

import java.time.LocalDate;

public class Person {

	private int age;
	private String name;
	private LocalDate tl;

	public Person(int age, String name, LocalDate tl) {
		super();
		this.age = age;
		this.name = name;
		this.tl = tl;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getTl() {
		return tl;
	}

	public void setTl(LocalDate tl) {
		this.tl = tl;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", tl=" + tl + "]";
	}

}
