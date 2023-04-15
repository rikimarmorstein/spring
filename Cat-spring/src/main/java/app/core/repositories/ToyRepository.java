package app.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Toy;

public interface ToyRepository extends JpaRepository<Toy, Integer> {

}
