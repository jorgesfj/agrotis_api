package com.ufpe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Laboratory {
	
	@Id
	@Column(name="id")
	private long id;
	
	@Column(name="name")
	@NotEmpty
	private String name;
	
	public Laboratory() {
		super();
	}

	public Laboratory(long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
}
