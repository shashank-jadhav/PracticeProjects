package co.shashank.demo1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.shashank.demo1.dao.UserDao;
import co.shashank.demo1.dto.UserDetailOut;

@Service
public class MyServiceImpl implements MyService {
	
	@Autowired
	private UserDao userDao;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public UserDetailOut getDataOut()
	{
		return userDao.getDataOut();
	}
	
}
