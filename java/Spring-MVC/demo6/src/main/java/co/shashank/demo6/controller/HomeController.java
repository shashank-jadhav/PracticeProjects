package co.shashank.demo6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.shashank.demo6.dto.UserDetailOut;
import co.shashank.demo6.hib.model.UserDetail;
import co.shashank.demo6.service.MyService;

@Controller
public class HomeController {

	@Autowired
	private MyService myService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcome() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView homePageView() {
		ModelAndView model = new ModelAndView();
		System.out.println("INSIDE");
		UserDetailOut user = myService.getDataOut();
		System.out.println("USER :: "+user);
		model.addObject("email", user.getEmail());
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/get/all/users", method = RequestMethod.GET)
	public ModelAndView getAllUsers()
	{
		ModelAndView model = new ModelAndView();
		List<UserDetail> users = myService.getAllUsers();
		model.addObject("usersList",users);   //bind data to get the list into jsp page
		model.setViewName("users");   // jsp page name
		return model;
	}
	
	
	@RequestMapping(value = "/get/all/delete/{u.userId}")
	public ModelAndView getAllUsersss(@PathVariable("u.userId") Long userID)
	{
		ModelAndView model = new ModelAndView();
		
		myService.deleteUser(userID);
		
		List<UserDetail> users = myService.getAllUsers();
		model.addObject("usersList",users);   //bind data to get the list into jsp page
		model.setViewName("users");   // jsp page name
		return model;
	}
	//Below method will open the insert page which have three input fields 
	@RequestMapping(value = "/add-book", method = RequestMethod.GET)
	public ModelAndView addNewUser()
	{
		ModelAndView model = new ModelAndView();  //this two lines should be written first ok yedi
		model.addObject("user",new UserDetail());  //this is binding of a model object or in your word it is pojo class
		model.setViewName("insert");    //name of jsp page
		return model;
	}
	
	//Below method will call after submitting the form 
	@RequestMapping(value = "/add-book", method = RequestMethod.POST)
	public ModelAndView submitAddNewUser(@ModelAttribute("user") UserDetail ud)
	{
		ModelAndView model = new ModelAndView(); 
		// buiness logic
		myService.addNewUser(ud);
		model.setViewName("user-details");
		return model;
	}
	
}
