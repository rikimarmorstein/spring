package app.core.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@Table(name = "players")
@ToString(exclude = "team")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int shirtNumber;
	@Column(nullable = false, length = 40)
	private String firstName;
	@Column(nullable = false, length = 40)
	private String lastName;
	private Date birthday;
	private boolean isForeign;
	private double weight;
	private Position position;
	@ManyToOne // (fetch = FetchType.LAZY)
	// @ToString.Exclude
	private Team team;

}
