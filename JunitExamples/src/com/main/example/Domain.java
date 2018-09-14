package com.main.example;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Domain")
public class Domain {
	private String name;
	private String age;

	@XmlElement
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Domain(String name, String age) {
		this.name = name;
		this.age = age;
	}

	public Domain() {
		super();
	}

}
