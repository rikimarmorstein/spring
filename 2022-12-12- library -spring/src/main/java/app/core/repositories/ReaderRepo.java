package app.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Reader;

public interface ReaderRepo extends JpaRepository<Reader, Integer> {

	List<Reader> findByBooksId(int bookId);

}
