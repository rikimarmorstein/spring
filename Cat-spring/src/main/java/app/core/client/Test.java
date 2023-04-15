package app.core.client;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.core.entities.Cat;
import app.core.entities.Toy;
import app.core.repositories.CatRepository;
import app.core.repositories.ToyRepository;

@Component
public class Test implements CommandLineRunner {

	@Autowired
	CatRepository catRepository;
	@Autowired
	ToyRepository repository;

	@Override
	public void run(String... args) throws Exception {
//		Toy t1 = new Toy(0, "jox");
//		Toy t2 = new Toy(0, "jox");
		List<Toy> toys = new ArrayList<>();
		toys.add(new Toy(0, "jox"));
		toys.add(new Toy(0, "jin"));
		List<Toy> toys2 = new ArrayList<>();
		toys2.add(new Toy(0, "jox"));
		toys2.add(new Toy(0, "jin"));
		Cat cat1 = new Cat(0, "mozi", 15, Date.valueOf("2022-01-01"), toys);
		catRepository.save(cat1);
		Cat cat2 = new Cat(0, "cuti", 14, Date.valueOf("2021-01-01"), toys2);
		catRepository.save(cat2);

	}

}
