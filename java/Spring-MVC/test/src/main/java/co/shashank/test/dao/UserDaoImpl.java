package co.shashank.test.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.shashank.test.dto.UserDetailOut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.config.BeanDefinition;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unused")
	@Override
	public UserDetailOut getDataOut() {
		Session session = sessionFactory.getCurrentSession();
      Query query = sessionFactory.getCurrentSession().getNamedQuery("GET_USER_DETAILS");
		 query.setString("suppliedEmail", "shashankjadhav08@gmail.com");
		return (UserDetailOut)query.uniqueResult();
	
	}

}
