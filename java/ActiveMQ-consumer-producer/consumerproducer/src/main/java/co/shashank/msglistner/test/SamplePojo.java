package co.shashank.msglistner.test;

import java.io.Serializable;

public class SamplePojo implements Serializable{

	String name;
	String city;

	
	public SamplePojo(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
