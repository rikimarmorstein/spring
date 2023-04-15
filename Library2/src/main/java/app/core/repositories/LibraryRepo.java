package app.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Library;

public interface LibraryRepo extends JpaRepository<Library, String> {

}
