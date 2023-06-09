package app.core;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("application.properties")
public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx;
		ctx = new AnnotationConfigApplicationContext(App.class);

		System.out.println("spring container is up");

		String[] beans = ctx.getBeanDefinitionNames();
		for (String beanName : beans) {
			System.out.println(beanName);
		}

		System.out.println("===========");
		Integer ran = ctx.getBean("randomNumberBean", Integer.class);
		System.out.println(ran);

		String hello = ctx.getBean("the-hello-string", String.class);
		System.out.println(hello);

		Person p = ctx.getBean("person", Person.class);
		p.speak();

		Person p2 = ctx.getBean("yakov", Person.class);
		p2.speak();
		System.out.println("age is: " + p2.age);

		System.out.println("==========================");

		try {
			TimeUnit.SECONDS.sleep(8);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		ctx.close();

	}

	@Bean
	public Person yakov() {
		Person p = new Person("Yakov");
		return p;
	}

	// bean methods
	// is call by the ctx when it is started
	@Bean
	public Integer randomNumberBean() {
		System.out.println("-----------------");
		return (int) (Math.random() * 101);
	}

	@Bean("the-hello-string")
	public String hello() {
		return "Hello";
	}

}
