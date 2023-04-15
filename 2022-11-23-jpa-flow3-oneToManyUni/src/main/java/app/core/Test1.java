package app.core;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import app.core.antities.Company;
import app.core.antities.Employee;
import app.core.repos.CompanyRepo;

//@Component
public class Test1 implements CommandLineRunner {

	@Autowired
	private CompanyRepo compRepo;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Test 1");

		try {
			Company company1 = new Company(0, "Tadiran", null);
			Company company2 = new Company(0, "Amkor", null);

			Employee e1 = new Employee(0, "Dan", 25);
			Employee e2 = new Employee(0, "Lea", 23);
			Employee e3 = new Employee(0, "Nir", 12);
			Employee e4 = new Employee(0, "Nira", 15);
			Employee e5 = new Employee(0, "Soli", 25);

			List<Employee> com1Emp = Arrays.asList(e1, e2, e3);
			List<Employee> com2Emp = Arrays.asList(e4, e5);

			company1.setEmployees(com1Emp);
			company2.setEmployees(com2Emp);
			// save
			compRepo.save(company1);
			compRepo.save(company2);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
