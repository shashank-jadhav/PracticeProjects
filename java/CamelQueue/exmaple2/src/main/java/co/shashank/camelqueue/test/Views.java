package co.shashank.camelqueue.test;

import java.io.Serializable;

public class Views  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int age = 30;
	 
	private int height = 190;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
	
}
