package co.shashank.demo6.service;

import java.util.List;

import co.shashank.demo6.dto.UserDetailOut;
import co.shashank.demo6.hib.model.UserDetail;

public interface MyService {
	
	
	public UserDetailOut getDataOut();
	
	public List<UserDetail> getAllUsers();
	
	public void deleteUser(Long userId);
	
	public void addNewUser(UserDetail ud);
}
