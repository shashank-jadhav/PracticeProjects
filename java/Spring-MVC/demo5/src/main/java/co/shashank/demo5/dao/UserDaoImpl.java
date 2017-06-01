package co.shashank.demo5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.shashank.demo5.dto.UserDetailOut;
import co.shashank.demo5.hib.model.UserDetail;

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
		
      Query query = sessionFactory.getCurrentSession().getNamedQuery("GET_USER_DETAILS");
		 query.setString("suppliedEmail", "shashankjadhav08@gmail.com");
		return (UserDetailOut)query.uniqueResult();
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserDetail> getAllUsers() {
		  Query query = sessionFactory.getCurrentSession().getNamedQuery("GET_ALL_USERS");
		return query.list();
	}

	@Override
	public void deleteUser(Long userId) {
		
		  Query query = sessionFactory.getCurrentSession().getNamedQuery("DELETE_USER");
			query.setLong("suppliedId", userId);
		query.executeUpdate();
	}

	@Override
	public void addNewUser(UserDetail ud) {
		Session session = sessionFactory.getCurrentSession();
		session.save(ud);
		
	}

}
