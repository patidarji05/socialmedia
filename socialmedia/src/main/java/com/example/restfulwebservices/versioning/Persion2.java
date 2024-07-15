package com.example.restfulwebservices.versioning;

public class Persion2 {

	private Name name;

	public Persion2(Name name) {
		super();
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Persion2 [name=" + name + "]";
	}

}
