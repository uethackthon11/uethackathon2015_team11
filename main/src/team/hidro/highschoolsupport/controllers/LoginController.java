package team.hidro.highschoolsupport.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import team.hidro.highschoolsupport.entities.StudentDetail;
import team.hidro.highschoolsupport.entities.TeacherDetail;
import team.hidro.highschoolsupport.entities.UserDetail;
import team.hidro.highschoolsupport.service.TeacherService;
import team.hidro.highschoolsupport.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userSevice;
	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login(){
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(@RequestParam("id") String id, @RequestParam("password") String password, HttpSession session){
		
		UserDetail user = userSevice.checkUser(id, password);
		ModelAndView model = new ModelAndView();
		if(user == null){
			System.out.println("ko");
			model.addObject("error", "Sai ID hoặc Password");
			model.setViewName("login");
		} else {
			
			session.setAttribute("role", user.getRole());
			//session.setAttribute("user", user);
			switch(user.getRole()){
			
				case 0 :
				case 1 :
				case 2 :
					/*TeacherDetail teacher = teachDao.getTeacher(user.getId());
					model.addObject("user", teacher);
					model.setViewName("redirect:home");*/
				case 3 :
					TeacherDetail teacher = teacherService.getById(user.getId());
					session.setAttribute("user", teacher);
					model.setViewName("redirect:home");
				default : ;
				
			}
			
		}
		return model;
	}
	
}
