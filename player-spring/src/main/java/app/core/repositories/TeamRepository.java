package app.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.core.entities.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

	boolean existsByName(String name);

	@Query(value = "select id from `team` where  `established_year`= (select  MAX( `established_year`) from `team`) LIMIT 1;", nativeQuery = true)
	int getTeamYoung();

	@Query(value = "select id from `team` where  `established_year`= (select  MIN( `established_year`) from `team`) LIMIT 1;", nativeQuery = true)
	int getTeamGraduate();

	List<Team> findAllByNameStartingWith(String letter);

	List<Team> findAllByNameEndingWith(String letter);

	List<Team> findAllByNameContaining(String letter);

	List<Team> findAllByOrderByName();

	List<Team> findAllByOrderByNameDesc();

	List<Team> findAllByOrderByEstablishedYear();

	List<Team> findAllByOrderByEstablishedYearDesc();

	@Query(value = "select exists(select * from `team_players` where team_id=? and players_id=?)", nativeQuery = true)
	int existsPlayerInTeam(int teamId, int playerId);

	@Modifying
	@Query(value = "delete from `team_players` where team_id=? and players_id=?;", nativeQuery = true)
	void deletePlayerFromTeam(int teamId, int playerId);

}
