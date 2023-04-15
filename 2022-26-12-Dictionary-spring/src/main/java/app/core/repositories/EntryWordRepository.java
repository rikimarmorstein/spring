package app.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.core.entities.EntryWord;

@Repository
public interface EntryWordRepository extends JpaRepository<EntryWord, Integer> {

}
