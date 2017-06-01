package co.shashank.demo1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.shashank.demo1.dto.UserDetailOut;

import org.springframework.transaction.annotation.Propagation;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unused")
	@Override
	public UserDetailOut getDataOut() {
		 Session session = sessionFactory.getCurrentSession();
		 Query query = session.getNamedQuery("GET_USER_DETAILS");
		 query.setString("suppliedEmail", "shashankjadhav08@gmail.com");
		return (UserDetailOut)query.uniqueResult();
	}

}
