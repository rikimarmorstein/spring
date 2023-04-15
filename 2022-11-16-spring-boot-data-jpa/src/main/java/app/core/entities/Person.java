package app.core.entities;

import javax.persistence.Id;

import lombok.Data;

@Data

public class Person {

	@Id
	private int id;
	private String name;
	private int age;

}
