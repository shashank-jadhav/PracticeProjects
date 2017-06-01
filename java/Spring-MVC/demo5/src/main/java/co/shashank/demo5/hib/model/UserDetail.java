package co.shashank.demo5.hib.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "GET_USER_DETAILS", query = "SELECT NEW co.nworks.demo5.dto.UserDetailOut( ud.userId , ud.email ) FROM UserDetail ud WHERE ud.email = :suppliedEmail")
,
		 @NamedQuery(name = "GET_ALL_USERS", query = "SELECT u from UserDetail u "),
		 @NamedQuery(name = "DELETE_USER", query = "DELETE UserDetail u WHERE u.userId =:suppliedId ")
		}	)
@Table(name = "user", catalog = "samplepro")
public class UserDetail implements Serializable {
 
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "userId")
	private Long userId;         

	@Column(name = "email")
	private String email;
	
	@Column(name = "password")      //this name should be same as the database field name
	private String password;
	
	@Column(name = "user_name")   //always use _underscore to seperate the two words  in DATABASE not in pojo
	private String userName;     //in pojo use camel case convention

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
