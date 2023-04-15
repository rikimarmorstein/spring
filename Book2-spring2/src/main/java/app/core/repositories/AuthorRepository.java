package app.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.core.entities.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
