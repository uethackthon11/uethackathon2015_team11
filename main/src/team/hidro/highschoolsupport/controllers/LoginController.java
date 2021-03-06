package team.hidro.highschoolsupport.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import team.hidro.highschoolsupport.entities.ParentDetail;
import team.hidro.highschoolsupport.entities.StudentDetail;
import team.hidro.highschoolsupport.entities.TeacherDetail;
import team.hidro.highschoolsupport.entities.UserDetail;
import team.hidro.highschoolsupport.service.ParentService;
import team.hidro.highschoolsupport.service.StudentService;
import team.hidro.highschoolsupport.service.TeacherService;
import team.hidro.highschoolsupport.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userSevice;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private ParentService parentService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login(){
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(@RequestParam("id") String id, @RequestParam("password") String password, HttpSession session){
		
		UserDetail user = userSevice.checkUser(id, password);
		ModelAndView model = new ModelAndView();
		if(user == null){
			model.addObject("error", "Sai ID hoặc Password");
			model.setViewName("login");
		} else {
			
			session.setAttribute("role", user.getRole());
			session.setAttribute("username", user.getUsername());
			
			//session.setAttribute("user", user);
			switch(user.getRole()){
				case 0 :
				case 1 :
					session.setAttribute("id", user.getId());
					StudentDetail student = studentService.getById(user.getId());
					session.setAttribute("user", student);
					session.setAttribute("avatar", student.getAvatar());
					session.setAttribute("name", student.getName());
					model.setViewName("redirect:" + user.getUsername() +"/profile");
					break;
				case 2 :
					
					ParentDetail parent = parentService.getById(user.getId());
					session.setAttribute("id", parent.getChildId());
					session.setAttribute("user", parent);
					session.setAttribute("avatar", "3.jpg");
					session.setAttribute("name", parent.getName());
					model.setViewName("redirect:" + parent.getChildName() +"/profile");
					break;
				case 3 :
					session.setAttribute("id", user.getId());
					TeacherDetail teacher = teacherService.getById(user.getId());
					session.setAttribute("user", teacher);
					session.setAttribute("avatar", teacher.getAvatar());
					session.setAttribute("name", teacher.getName());
					model.setViewName("redirect:home");
					break;
				default : ;
				
			}
			
		}
		return model;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession sesion){
		
		sesion.invalidate();
		
		return new ModelAndView("login");
	}
	
}
