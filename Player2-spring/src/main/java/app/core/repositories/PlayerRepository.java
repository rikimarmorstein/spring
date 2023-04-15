package app.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.core.entities.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

	@Query(value = "select exists(select * from `players` where team_id= ? and id=?);", nativeQuery = true)
	int existsPlayerInTeam(int teamId, int playerId);

	List<Player> findByTeamId(int teamId);

	@Query(value = "select first_name, last_name, birthday from players where team_id=?1 and birthday=(select min(birthday) from players where team_id = ?1)limit 1;", nativeQuery = true)
	String findByBirthdayMin(int teamId);

	@Query(value = "select first_name, last_name, birthday from players where team_id=?1 and birthday=(select max(birthday) from players where team_id = ?1)limit 1;", nativeQuery = true)
	String findByBirthdayMax(int teamId);

	@Query(value = "select avg(shirt_number) from `players` where team_id =?;", nativeQuery = true)
	double findByShirtNumber(int teamId);

	@Query(value = "select sum(shirt_number) from `players` where team_id =?;", nativeQuery = true)
	double findByShirtNumberSum(int teamId);

}
