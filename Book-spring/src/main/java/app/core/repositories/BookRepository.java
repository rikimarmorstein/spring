package app.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.core.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	List<Book> findByYearBetween(int start, int end);

	@Query(value = "select avg(year)from book", nativeQuery = true)
	int avgYear();

	@Query(value = "select avg(year)from book join author_books on book.id=author_books.books_id where author_id = (?)", nativeQuery = true)
	int avgYearOfLibrary(int authorId);
}
