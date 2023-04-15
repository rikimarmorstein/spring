package app.core.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.antities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
