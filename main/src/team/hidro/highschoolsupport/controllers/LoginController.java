package team.hidro.highschoolsupport.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import team.hidro.highschoolsupport.entities.StudentDetail;
import team.hidro.highschoolsupport.entities.TeacherDetail;

@Controller
public class LoginController {

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login(){
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(@RequestParam("id") String id, @RequestParam("password") String password, HttpSession session){
		
		//UserDetail user = userDao.checkUser(id, password);
		ModelAndView model = new ModelAndView();
		/*if(user == null){
			model.addObject("error", "Sai ID hoặc Password");
			model.setViewName("login");
		} else {
			
			session.setAttribute("rule", user.getRule());
			
			switch(user.getRule()){
			
				case 1 :
				case 2 :
				case 3 :
					TeacherDetail teacher = teachDao.getTeacher(user.getId());
					model.addObject("user", teacher);
					model.setViewName("redirect:home");
				case 4 :
					StudentDetail student = studentDao.getStudent(user.getId());
					model.addObject("user", student);
				default : ;
				
			}
			
		}*/
		return model;
	}
	
}
