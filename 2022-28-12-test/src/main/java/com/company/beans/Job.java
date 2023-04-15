package com.company.beans;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "employee")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String description;
	private Date endDate;
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private Employee employee;

}
