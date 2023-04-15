package app.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import app.core.antities.University;
import app.core.repos.StudentRepo;
import app.core.repos.UniversityRepo;

//@Component
public class Test2 implements CommandLineRunner {

	@Autowired
	private UniversityRepo compRepo;

	@Autowired
	private StudentRepo studentRepo;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Test 1");

		try {

			University u1 = new University(0, "Harvad");
			University u2 = new University(0, "Technion");

			compRepo.save(u1);
			compRepo.save(u2);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
