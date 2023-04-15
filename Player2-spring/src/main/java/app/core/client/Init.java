package app.core.client;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import app.core.entities.Player;
import app.core.entities.Position;
import app.core.entities.Team;
import app.core.repositories.PlayerRepository;
import app.core.repositories.TeamRepository;

@Component
@Order(1)
public class Init implements CommandLineRunner {
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private TeamRepository teamRepository;

	@Override
	public void run(String... args) throws Exception {

		try {
			Team team1 = Team.builder().name("ppp").establishedYear(2000).build();
			Team team2 = new Team(0, "rrrr", 1980, null);
			Team team3 = new Team(0, "vvv", 2020, null);
			Team team4 = new Team(0, "sss", 1989, null);
			Team team5 = new Team(0, "llll", 2015, null);

			Player player1 = new Player(0, 25, "D", "V", Date.valueOf(LocalDate.of(1992, 8, 16)), false, 75,
					Position.PG, team1);

			Player player2 = new Player(0, 22, "David", "Ven", Date.valueOf(LocalDate.of(1986, 4, 4)), true, 89,
					Position.PG, team3);
			Player player3 = Player.builder().birthday(Date.valueOf(LocalDate.of(1992, 8, 16))).firstName("Efrat")
					.lastName("Choen").shirtNumber(20).team(team2).weight(60.5).build();
			Player player4 = new Player(0, 88, "Ruthi", "Veng", (Date.valueOf(LocalDate.of(2000, 6, 6))), false, 80,
					Position.C, team5);
			Player player5 = Player.builder().birthday(Date.valueOf(LocalDate.of(1992, 8, 16))).firstName("Efrat")
					.lastName("Choen").shirtNumber(20).team(team2).weight(60.5).build();
//				Player player5 = Player.builder().birthday(Date.valueOf(LocalDate.of(1992, 8, 16))).position(Position.SG)
//						.team(team4).build();
//			Player player6 = Player.builder().firstName("kkk").build();
			team1.setPlayers(List.of(player1));
			team2.setPlayers(List.of(player3));
			team3.setPlayers(List.of(player2));
			team4.setPlayers(List.of(player5));
//			team5.setPlayers(List.of(player4, player6));

			teamRepository.saveAll(List.of(team1, team2, team3, team4, team5));
			System.out.println(teamRepository.findAll());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
