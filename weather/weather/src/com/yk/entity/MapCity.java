package com.yk.entity;

import java.io.Serializable;

public class MapCity implements Serializable {
	
	private Integer value;
	private String name;
	
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "City [value=" + value + ", name=" + name + "]";
	}
	
	

}
