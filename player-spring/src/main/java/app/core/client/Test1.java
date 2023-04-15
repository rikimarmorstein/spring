package app.core.client;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import app.core.entities.Player;
import app.core.entities.Position;
import app.core.entities.Team;
import app.core.repositories.PlayerRepository;
import app.core.repositories.TeamRepository;

//@Component
public class Test1 implements CommandLineRunner {
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private TeamRepository teamRepository;

	@Override
	public void run(String... args) throws Exception {

		List<Player> player1 = new ArrayList<>();
		player1.add(new Player(0, 2, "Dan", "Dana", Date.valueOf("1989-02-02"), true, 60.5, Position.C));
		player1.add(new Player(0, 3, "Gan", "Gana", Date.valueOf("1999-02-04"), true, 55.5, Position.PF));
		player1.add(new Player(0, 4, "Fan", "Fana", Date.valueOf("2000-10-02"), true, 55.55, Position.SF));
		List<Player> player2 = new ArrayList<>();
		player2.add(new Player(0, 2, "Ran", "Rana", Date.valueOf("2002-02-02"), true, 60.5, Position.SF));
		player2.add(new Player(0, 3, "Gil", "Gili", Date.valueOf("1999-02-04"), true, 55.5, Position.PF));
		player2.add(new Player(0, 4, "Sim", "Simi", Date.valueOf("1979-03-02"), true, 55.55, Position.SG));

		Team team1 = new Team(0, "team1", 1960, player1);
		Team team2 = new Team(0, "team2", 1980, player2);
		teamRepository.save(team1);
		teamRepository.save(team2);

	}

}
