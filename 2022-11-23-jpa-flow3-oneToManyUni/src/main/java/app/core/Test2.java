package app.core;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import app.core.antities.Company;
import app.core.antities.Employee;
import app.core.repos.CompanyRepo;

//@Component
public class Test2 implements CommandLineRunner {

	@Autowired
	private CompanyRepo compRepo;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Test 2");

		try (Scanner sc = new Scanner(System.in);) {

			System.out.println("enter companyID");
			int companyID = sc.nextInt();
			Optional<Company> opt = compRepo.findById(companyID);
			if (opt.isPresent()) {
				Company company = opt.get();
				System.out.println(company.getEmployees());
				company.addEmployee(new Employee(0, "Yoav", 23));
				compRepo.save(company);
			} else {
				System.out.println("company not found");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
