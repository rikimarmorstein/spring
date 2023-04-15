package app.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.core.antities.Address;
import app.core.antities.Company;
import app.core.repos.CompanyRepo;

@Component
public class Test3 implements CommandLineRunner {

	@Autowired
	private CompanyRepo companyRepo;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Test 3");

		try {

			Address address = new Address(0, "Israel", "Tel Aviv", "Herzel", 40);
			Company company = new Company(0, "Elite", null);
			company.setAddress(address);
			companyRepo.save(company);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
