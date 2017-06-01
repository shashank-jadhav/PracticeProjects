package co.shashank.demo5.service;

import java.util.List;

import co.shashank.demo5.dto.UserDetailOut;
import co.shashank.demo5.hib.model.UserDetail;

public interface MyService {
	
	
	public UserDetailOut getDataOut();
	
	public List<UserDetail> getAllUsers();
	
	public void deleteUser(Long userId);
	
	public void addNewUser(UserDetail ud);
}
