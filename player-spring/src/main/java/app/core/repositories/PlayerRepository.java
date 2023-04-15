package app.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.core.entities.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
	@Query(value = "select * from `player` where id=ANY (select players_id from `team_players` where team_id=?);", nativeQuery = true)
	List<Player> findAllByPlayers(int teamId);

	@Query(value = "select id from `player` join `team_players` on player.id = team_players.players_id where team_id =?1 and player.birthday = (select MAX(`birthday`) from `player` join `team_players` on player.id = team_players.players_id where team_id =?1 ) LIMIT 1;", nativeQuery = true)
	int findByBirthdayMin(int teamId);

//	@Query(value = "select id from `player` join `team_players` on player.id = team_players.players_id where team_id =1 and player.birthday = (select MAX(`birthday`) from `player`) LIMIT 1;", nativeQuery = true)
//	int findByBirthdayMax(int teamId);

	@Query(value = "select avg(shirt_number) from `player` join `team_players` on player.id = team_players.players_id where team_id =?;", nativeQuery = true)
	double findByShirtNumber(int teamId);

	@Query(value = "select sum(shirt_number) from `player` join `team_players` on player.id = team_players.players_id where team_id =?;", nativeQuery = true)
	double findByShirtNumberSum(int teamId);
}
