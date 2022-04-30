package com.ufpe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "company")
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	@NotEmpty
	private String name;
	
	@Column(name="cnpj")
	@NotEmpty
	private String cnpj;
	
	@Column(name="observations")
	@NotEmpty
	private String observations;
	
	@Column(name="startDate")
	@NotEmpty
	private String startDate;
	
	@Column(name="endDate")
	@NotEmpty
	private String endDate;
	
	@Column(name="property")
	@NotEmpty
	private long property;
	
	@Column(name="laboratory")
	@NotEmpty
	private long laboratory;
	
	
	public Company(){
		super();
	}
	
	public Company(String name, String cnpj, String observations, String startDate, String endDate, long property, long laboratory) {
		super();
		this.name = name;
		this.cnpj = cnpj;
		this.observations = observations;
		this.startDate = startDate;
		this.endDate = endDate;
		this.property = property;
		this.laboratory = laboratory;
	}

	
	public long getLaboratory() {
		return laboratory;
	}

	public void setLaboratory(long laboratory) {
		this.laboratory = laboratory;
	}

	public long getProperty() {
		return property;
	}

	public void setProperty(long property) {
		this.property = property;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
	
	
}
