package app.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.core.entities.Cat;

public interface CatRepository extends JpaRepository<Cat, Integer> {

	List<Cat> findByNameAndWeight(String nameCat, double weight);

	List<Cat> findByNameOrWeight(String name, double weight);

	List<Cat> findAllByOrderByWeight();

	List<Cat> findAllByOrderByWeightDesc();

	List<Cat> findByNameStartingWith(String letter);

	@Query(value = "select avg(weight)from cat", nativeQuery = true)
	double avgWeight();

}
