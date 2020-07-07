package com.swagger.swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Stores the user details")
public class User {

	@ApiModelProperty(notes="Id of the user")
	private Integer id;
	
	@ApiModelProperty(notes="Name of the user")
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public User() {
	}

}
