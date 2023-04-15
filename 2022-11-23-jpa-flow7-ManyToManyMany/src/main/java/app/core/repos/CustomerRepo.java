package app.core.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.antities.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
