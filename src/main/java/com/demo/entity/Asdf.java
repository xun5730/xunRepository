package com.demo.entity;

import java.io.Serializable;

public class Asdf implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5248414493915769628L;
	private Integer id;
	private String value;
	private String name;
	
	private Integer valid;
	
	public Integer getValid() {
		return valid;
	}
	public void setValid(Integer valid) {
		this.valid = valid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
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
		return "Asdf [id=" + id + ", value=" + value + ", name=" + name + "]";
	}
	
	

}
