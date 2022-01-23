package com.Ty.Github.pojolib;

public class Project {

	String name;
	String description;
	
	public Project(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public Project() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
}
