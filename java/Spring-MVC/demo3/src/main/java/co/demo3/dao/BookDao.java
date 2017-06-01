package co.demo3.dao;

import java.math.BigDecimal;
import java.util.List;

import co.demo3.dto.AddBook;
import co.demo3.model.Books;

public interface BookDao {

	public void addBook(AddBook addBook);
	
	public List<Books> getBooks();
}
