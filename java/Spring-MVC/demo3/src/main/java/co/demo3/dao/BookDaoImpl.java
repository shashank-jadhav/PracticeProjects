package co.demo3.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.demo3.dto.AddBook;
import co.demo3.model.Books;

import org.springframework.transaction.annotation.Propagation;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class BookDaoImpl implements BookDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addBook(AddBook addBook) {
		Session session = sessionFactory.getCurrentSession();
		Books book = new Books();
		book.setBookName(addBook.getBookName());
		book.setBookPrice(addBook.getBookPrice());
		session.save(book);
		
	}
	
	public List<Books> getBooks()
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("GET_BOOKS");
		return (List<Books>)query.list();
	}

}
