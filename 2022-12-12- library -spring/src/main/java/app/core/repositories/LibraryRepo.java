package app.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Library;

public interface LibraryRepo extends JpaRepository<Library, Integer> {

	Library findByBooksId(int bookID);

	boolean existsByName(String libraryName);

	boolean existsByIdAndBooksTitle(int libraryId, String bookName);

}
