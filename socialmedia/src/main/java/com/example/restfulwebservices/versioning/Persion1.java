package com.example.restfulwebservices.versioning;

public class Persion1 {
	private String name;

	public Persion1(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Persion1 [name=" + name + "]";
	}

}
