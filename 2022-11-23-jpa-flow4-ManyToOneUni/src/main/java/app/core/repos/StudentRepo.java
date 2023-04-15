package app.core.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.antities.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
