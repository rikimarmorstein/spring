package app.core;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import app.core.entities.Book;

@Component
public class Demo1 implements CommandLineRunner {

	@Autowired
	private ApplicationContext ctx;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("demo 1 started---------------------------");
		Book book = new Book();
		book.setId(102);
		book.setTitle("spring basics 1");
		book.setPrice(17);
		book.setAuthor("riki");
		book.setPublication(LocalDate.of(2012, 12, 12));

		EntityManagerFactory factory = ctx.getBean(EntityManagerFactory.class);
		// session
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin(); // transaction start

			em.persist(book);
			em.getTransaction().commit();// transaction end success
		} catch (Exception e) {
			em.getTransaction().rollback();// transaction end fail
			e.printStackTrace();
		}
	}

}
