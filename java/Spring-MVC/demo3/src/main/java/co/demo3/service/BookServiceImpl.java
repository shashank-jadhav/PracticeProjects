package co.demo3.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.demo3.dao.BookDao;
import co.demo3.dto.AddBook;
import co.demo3.model.Books;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao bookDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addBook(AddBook addBook) {
		bookDao.addBook(addBook);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public List<Books> getBooks() {
	return bookDao.getBooks();
	}

}
