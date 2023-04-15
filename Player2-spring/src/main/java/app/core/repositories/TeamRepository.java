package app.core.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.core.entities.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

	boolean existsByName(String name);

	@Query(value = "select * from teams where established_year = (select max(established_year) from teams)limit 1;", nativeQuery = true)
	Optional<Team> findByEstablishedYearMax();

	@Query(value = "select * from teams where established_year = (select min(established_year) from teams)limit 1;", nativeQuery = true)
	Optional<Team> findByEstablishedYearMin();

	List<Team> findAllByNameStartingWith(String letter);

	List<Team> findAllByNameEndingWith(String letter);

	List<Team> findAllByNameContaining(String letter);

	List<Team> findAllByOrderByName();

	List<Team> findAllByOrderByNameDesc();

	List<Team> findAllByOrderByEstablishedYear();

	List<Team> findAllByOrderByEstablishedYearDesc();

}
