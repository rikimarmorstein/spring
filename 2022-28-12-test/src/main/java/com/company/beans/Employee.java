package com.company.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private double salary;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.EAGER)
	private List<Job> jobs;

	public void addJob(Job job) {
		if (jobs == null) {
			jobs = new ArrayList<>();
		}
		job.setEmployee(this);
		jobs.add(job);
	}

	public void setJobs(List<Job> jobs) {
		for (Job job : jobs) {
			job.setEmployee(this);
		}
		this.jobs = jobs;
	}

}
