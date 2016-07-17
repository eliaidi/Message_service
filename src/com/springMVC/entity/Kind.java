package com.springMVC.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kinds")
public class Kind {
	@Id
	@Column(name="kind_id")
	private int kind_id;
	
	@Column(name="kind_name")
	private String kind_name;

	public Kind(int kind_id, String kind_name) {
		super();
		this.kind_id = kind_id;
		this.kind_name = kind_name;
	}

	public Kind() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getKind_id() {
		return kind_id;
	}

	public void setKind_id(int kind_id) {
		this.kind_id = kind_id;
	}

	public String getKind_name() {
		return kind_name;
	}

	public void setKind_name(String kind_name) {
		this.kind_name = kind_name;
	}
	

}
