package app.core;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.core.antities.Student;
import app.core.antities.University;
import app.core.repos.StudentRepo;
import app.core.repos.UniversityRepo;

@Component
public class Test3 implements CommandLineRunner {

	@Autowired
	private UniversityRepo uniRepo;

	@Autowired
	private StudentRepo studentRepo;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Test 3");

		try {

			Optional<Student> opt = studentRepo.findById(1);
			Optional<University> opt2 = uniRepo.findById(1);

			if (opt.isPresent() && opt2.isPresent()) {
				Student student = opt.get();
				University unversity = opt2.get();

				student.setUniversity(unversity);
				studentRepo.save(student);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
