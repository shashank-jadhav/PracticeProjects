package co.shashank.demo6.dto;

import java.io.Serializable;

public class UserDetailOut implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long userId;
	private String email;
	
	
	

	public UserDetailOut(Long userId, String email) {
		super();
		this.userId = userId;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
