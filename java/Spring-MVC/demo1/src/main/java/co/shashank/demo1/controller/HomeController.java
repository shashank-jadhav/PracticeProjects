package co.shashank.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.shashank.demo1.dto.UserDetailOut;
import co.shashank.demo1.service.MyService;

@Controller
public class HomeController {

	@Autowired
	private MyService myService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView homePageView() {
		ModelAndView model = new ModelAndView();
		System.out.println("INSIDE");
		UserDetailOut user = myService.getDataOut();
		model.addObject("email", user.getEmail());
		model.setViewName("home");
		return model;
	}

	/*@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView getUserEmail() {
		ModelAndView model = new ModelAndView();

		UserDetailOut user = myService.getDataOut();
		model.addObject("email", user.getEmail());
		model.setViewName("user");
		return model;
	}*/
}
