package app.core.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.antities.Company;

public interface CompanyRepo extends JpaRepository<Company, Integer> {

}
