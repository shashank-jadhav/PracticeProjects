package co.shashank.demo1.dto;

import java.io.Serializable;

public class UserDetailOut implements Serializable {

	private static final long serialVersionUID = 1L;
	private String email;
	private Long userId;

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
