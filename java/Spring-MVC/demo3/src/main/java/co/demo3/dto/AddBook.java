package co.demo3.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class AddBook implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String bookName;
	private BigDecimal bookPrice;

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public BigDecimal getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(BigDecimal bookPrice) {
		this.bookPrice = bookPrice;
	}

}
