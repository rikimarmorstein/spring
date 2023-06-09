package app.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import app.core.antities.Student;
import app.core.repos.StudentRepo;
import app.core.repos.UniversityRepo;

//@Component
public class Test1 implements CommandLineRunner {

	@Autowired
	private UniversityRepo compRepo;

	@Autowired
	private StudentRepo studentRepo;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Test 1");

		try {

			Student st1 = new Student(0, "Yaron", 25, null);
			Student st2 = new Student(0, "Ari", 35, null);

			studentRepo.save(st1);
			studentRepo.save(st2);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
