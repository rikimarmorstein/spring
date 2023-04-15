package app.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import app.core.antities.Company;

//@Component
public class Test2 implements CommandLineRunner {

	@Autowired
	private EntityManagerFactory factory;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Test 2");

		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			// get a company
			Company company = em.find(Company.class, 1);
			System.out.println(company);
//delete the company
			em.remove(company);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

}
