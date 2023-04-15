package app.core.client;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import app.core.entities.Cat;
import app.core.entities.Toy;

public class RestTemplateDemo {
	public static void main(String[] args) {

		RestTemplate rt = new RestTemplate();

		String url = "http://localhost:8080/api/cats";

		List<Toy> toys = new ArrayList<>();
		toys.add(new Toy(0, "aa"));
		toys.add(new Toy(0, "bb"));
		List<Toy> toyss = new ArrayList<>();
		toys.add(new Toy(0, "aa"));
		toys.add(new Toy(0, "bb"));
		Cat cat1 = new Cat(0, "muzi", 15.2, Date.valueOf("2021-01-01"), toys);
		Cat cat2 = new Cat(0, "muzizi", 12.2, Date.valueOf("2022-01-01"), toyss);
		try {
			Cat createCat1 = rt.postForObject(url, cat1, Cat.class);
			Cat createCat2 = rt.postForObject(url, cat2, Cat.class);
			System.out.println(createCat1);
			System.out.println(createCat2);
		} catch (RestClientException e) {
			System.out.println("Error: " + e.getMessage());
		}
		String url2 = "http://localhost:8080/api/cats";
		try {
			Cat updateCat = Cat.builder().id(2).birthday(Date.valueOf("2022-02-01")).name("mozzi").weight(10).build();
			rt.put(url2, updateCat, Cat.class);
		} catch (RestClientException e) {
		}

		String url3 = "http://localhost:8080/api/cats/one?catId=2";
		try {
			Cat cat = rt.getForObject(url3, Cat.class);
			System.out.println(cat);
		} catch (RestClientException e) {
			System.out.println("Error: " + e.getMessage());
		}

		String url4 = "http://localhost:8080/api/cats/nameAndWeight?nameCat=muz&weight=1";
		try {
			Cat[] cat = rt.getForObject(url4, Cat[].class);
			List<Cat> list = Arrays.asList(cat);
			System.out.println(list);
		} catch (RestClientException e) {
			System.out.println("Error: " + e.getMessage());
		}
		String url5 = "http://localhost:8080/api/cats/ByWeightUp";
		try {
			Cat[] cat = rt.getForObject(url5, Cat[].class);
			List<Cat> list = Arrays.asList(cat);
			System.out.println(list);
		} catch (RestClientException e) {
			System.out.println("Error: " + e.getMessage());
		}

		String url6 = "http://localhost:8080/api/cats/7";
		try {
			rt.delete(url6);
		} catch (RestClientException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}
}
