package co.shashank.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.shashank.test.dao.UserDao;
import co.shashank.test.dto.UserDetailOut;

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
	
}
