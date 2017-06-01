package co.shashank.demo5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.shashank.demo5.dao.UserDao;
import co.shashank.demo5.dto.UserDetailOut;
import co.shashank.demo5.hib.model.UserDetail;

@Service
public class MyServiceImpl implements MyService {
	
	
	private UserDao userDao;
	
	
	@Autowired
	public MyServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
	}



	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public UserDetailOut getDataOut()
	{
		return userDao.getDataOut();
	}



	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public List<UserDetail> getAllUsers() {
		return userDao.getAllUsers();
	}



	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void deleteUser(Long userId) {
		userDao.deleteUser(userId);
		
	}



	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW) //always mark this with every service method
	public void addNewUser(UserDetail ud) {
		userDao.addNewUser(ud);
		
	}
	
}
