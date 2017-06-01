package co.shashank.demo1.hib.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "UserDetail.GET_USER_DETAILS", query = "SELECT ud.userId , ud.email FROM UserDetail ud WHERE ud.email = :suppliedEmail")

	 
})
@Table(name = "user", catalog = "samplepro")
public class UserDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId")
	private Long userId;

	@Column(name = "email")
	private String email;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
