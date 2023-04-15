package app.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.core.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
	@Query(value = "select id from movie where year= (select max(year) from movie) limit 1;", nativeQuery = true)
	int findByMaxYear();

	@Query(value = "select id from movie where year= (select min(year) from movie) limit 1;", nativeQuery = true)
	int findByMinYear();

	List<Movie> findAllByNameStartingWith(String Startletter);
}
