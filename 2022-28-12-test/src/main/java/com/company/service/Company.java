package com.company.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.beans.Employee;
import com.company.beans.Job;
import com.company.exceptions.CompanyException;
import com.company.repo.EmployeeRepository;
import com.company.repo.JobRepository;

@Service
@Transactional
public class Company {

	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private JobRepository jobRepo;

	public Long addEmployee(Employee e) {
		empRepo.save(e);
		return e.getId();
	}

	public Employee getEmployee(long empId) throws CompanyException {
		return empRepo.findById(empId).orElseThrow(() -> new CompanyException("id " + empId + " not found"));
	}

	public List<Employee> getEmployee(String name) {
		return empRepo.findEmployeeByName(name);
	}

	public List<Employee> getEmployees() {
		return empRepo.findAll();
	}

	public List<Job> getJobs() {
		return jobRepo.findAll();
	}

	public List<Job> getJobs(Date endDate) {
		return jobRepo.findJobByEndDate(endDate);
	}

	public List<Job> getJobs(Date start, Date end) throws CompanyException {
		if (end.before(start)) {
			throw new CompanyException("Incorrect data, end date cannot be before start date");
		}
		return jobRepo.findJobByEndDateBetween(start, end);
	}
}
