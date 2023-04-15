package app.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.core.entities.Rate;

@Repository
public interface RateRepository extends JpaRepository<Rate, Integer> {
	@Query(value = "select exists(select * from `rate` where movie_id=? and id=?);", nativeQuery = true)
	int existsRateOfMovie(int movieId, int rateId);
}
