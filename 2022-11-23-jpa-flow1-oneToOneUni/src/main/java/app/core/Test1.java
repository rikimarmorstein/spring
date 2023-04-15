package app.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import app.core.antities.Address;
import app.core.antities.Company;

//@Component
public class Test1 implements CommandLineRunner {

	@Autowired
	private EntityManagerFactory factory;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Test 1");

		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			Address address = new Address(0, "Israel", "Tel Aviv", "Alenbi", 12);
			Company company = new Company(0, "Telma", null);
			company.setAddress(address);

			em.persist(company);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

}
