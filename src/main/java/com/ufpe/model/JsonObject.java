package com.ufpe.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class JsonObject {
	
	private String name;
	private String cnpj;
	private String observations;
	private String startDate;
	private String endDate;
	private Property property;
	private Laboratory laboratory;
	
	
	public JsonObject(String name, String cnpj, String observations, String startDate, String endDate,
			Property property, Laboratory laboratory) {
		super();
		this.name = name;
		this.cnpj = cnpj;
		this.observations = observations;
		this.startDate = startDate;
		this.endDate = endDate;
		this.property = property;
		this.laboratory = laboratory;
	}
	
	
	public Laboratory getLaboratory() {
		return laboratory;
	}


	public void setLaboratory(Laboratory laboratory) {
		this.laboratory = laboratory;
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
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
	}
	
	
}
