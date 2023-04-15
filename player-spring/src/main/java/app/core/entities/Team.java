package app.core.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, length = 40)
	private String name;
	private int establishedYear;
	@JsonIgnore
	@OneToMany(cascade = {

			CascadeType.DETACH,

			CascadeType.MERGE,

			CascadeType.PERSIST,

			CascadeType.REFRESH

	})
	private List<Player> players;

	public void addPlayer(Player player) {
		if (players == null) {
			players = new ArrayList<>();
		}
		this.players.add(player);
	}
}
