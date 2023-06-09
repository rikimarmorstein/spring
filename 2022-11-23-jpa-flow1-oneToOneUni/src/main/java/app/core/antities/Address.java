package app.core.antities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String country;
	private String city;
	private String street;
	private int apt;

}
