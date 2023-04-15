package com.company.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.beans.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

	List<Job> findJobByEndDate(Date endDate);

	List<Job> findJobByEndDateBetween(Date startDate, Date endDate);
}
