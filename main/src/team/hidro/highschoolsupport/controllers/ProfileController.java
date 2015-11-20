package team.hidro.highschoolsupport.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {

	@RequestMapping("/{id}/profile")
	public ModelAndView profileView(){
		
		return new ModelAndView("profile");
		
	}
	
}
