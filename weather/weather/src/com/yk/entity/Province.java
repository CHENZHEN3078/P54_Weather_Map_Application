package com.yk.entity;

import java.io.Serializable;

public class Province implements Serializable {

	private String id;
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Province [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
}
