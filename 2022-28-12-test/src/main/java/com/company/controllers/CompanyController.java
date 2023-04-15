package com.company.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.company.beans.Employee;
import com.company.beans.Job;
import com.company.exceptions.CompanyException;
import com.company.service.Company;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
	@Autowired
	private Company company;

	@PostMapping
	public long addEmployee(@RequestBody Employee e) {
		return company.addEmployee(e);
	}

	@GetMapping("/getEmployee/{empId}")
	public Employee getEmployee(@PathVariable long empId) {
		try {
			return company.getEmployee(empId);
		} catch (CompanyException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@GetMapping("/getEmployees")
	public List<Employee> getEmployees() {
		return company.getEmployees();
	}

	@GetMapping("/getEmployeesByName")
	public List<Employee> getEmployees(String name) {
		return company.getEmployee(name);
	}

	@GetMapping("/getJobs")
	public List<Job> getJobs() {
		return company.getJobs();
	}

	@GetMapping("/getJobsByendDate")
	public List<Job> getJobs(@RequestParam Date endDate) {
		return company.getJobs(endDate);
	}

	@GetMapping("/getJobsByendDateBetweenDates")
	public List<Job> getJobs(@RequestParam Date start, @RequestParam Date end) {
		try {
			return company.getJobs(start, end);
		} catch (CompanyException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
}
