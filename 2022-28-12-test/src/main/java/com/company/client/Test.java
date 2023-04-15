package com.company.client;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.company.beans.Employee;
import com.company.beans.Job;

public class Test {

	public static void main(String[] args) {
		try {
			RestTemplate rt = new RestTemplate();
			String url = "http://localhost:8080/api/company";
			System.out.println("====addEmployee====");
			List<Job> job = new ArrayList<>();
			Employee employee = new Employee(0, "Ron", 10000, job);
			job.add(new Job(0, "Clean the room", Date.valueOf("2022-12-28"), employee));
			job.add(new Job(0, "Go to the Bank", Date.valueOf("2023-01-01"), employee));
			long id = rt.postForObject(url, employee, Long.class);
			System.out.println("Employee id " + id + " Added successfully");
			List<Job> job2 = new ArrayList<>();
			Employee employee2 = new Employee(0, "Dan", 20000, job2);
			job.add(new Job(0, "Finish the project", Date.valueOf("2023-02-28"), employee2));
			job.add(new Job(0, "Provide guidance to the team", Date.valueOf("2023-01-02"), employee2));
			long id2 = rt.postForObject(url, employee2, Long.class);
			System.out.println("Employee id " + id2 + " Added successfully");
			System.out.println("====getEmployee====");
			System.out.println(rt.getForObject(url + "/getEmployee/1", Employee.class));
			System.out.println("====getEmployees====");
			Arrays.asList(rt.getForObject(url + "/getEmployees", Employee[].class)).forEach(System.out::println);
			System.out.println("====getEmployeesByName====");
			Arrays.asList(rt.getForObject(url + "/getEmployeesByName?name=Ron", Employee[].class))
					.forEach(System.out::println);
			System.out.println("====getJobs====");
			Arrays.asList(rt.getForObject(url + "/getJobs", Job[].class)).forEach(System.out::println);
			System.out.println("====getJobsByendDate====");
			Arrays.asList(rt.getForObject(url + "/getJobsByendDate?endDate=2022-12-28", Job[].class))
					.forEach(System.out::println);
			System.out.println("====getJobsByendDateBetweenDates====");
			Arrays.asList(
					rt.getForObject(url + "/getJobsByendDateBetweenDates?start=1999-01-01&end=2023-01-01", Job[].class))
					.forEach(System.out::println);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
