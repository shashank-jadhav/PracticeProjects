package co.demo3.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.demo3.dto.AddBook;
import co.demo3.model.Books;
import co.demo3.service.BookService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public ModelAndView viewHomePage()
	{
		ModelAndView model = new ModelAndView();
		model.addObject("addBook", new AddBook());
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping(value = "/home",method = RequestMethod.POST)
	public ModelAndView addBook(@Valid @ModelAttribute("addBook") AddBook addBook)
	{
		ModelAndView model = new ModelAndView();
		System.out.println("addBook : "+ addBook.toString());
		bookService.addBook(addBook);
		model.setViewName("display");
		return model;
	}
	
	@RequestMapping(value = "/displayBook",method = RequestMethod.POST)
	public ModelAndView getBooks()
	{
		ModelAndView model = new ModelAndView();
		List<Books> books = bookService.getBooks();
		
		model.addObject("bookList",books);
		return model;
	}
	
	
	
}
