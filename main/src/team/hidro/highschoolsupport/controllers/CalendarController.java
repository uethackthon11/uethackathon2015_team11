package team.hidro.highschoolsupport.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import team.hidro.highschoolsupport.dao.ClassDao;
import team.hidro.highschoolsupport.entities.StudentDetail;
import team.hidro.highschoolsupport.service.StudentService;

@Controller
public class CalendarController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ClassDao classDao;
	
	@RequestMapping(value="/calendar", method =RequestMethod.GET)
	public ModelAndView show(HttpSession session) {
		int userId = Integer.parseInt(session.getAttribute("id").toString());
		StudentDetail studentDetail = studentService.getById(userId);
		ModelAndView model = new ModelAndView("calendar");
		String className = classDao.getById(studentDetail.getClassId()).getName();
		model.addObject("className", className);
		return model;
	}
	
	@RequestMapping(value="/lifeCalendar", method =RequestMethod.GET)
	public ModelAndView showlifeCalendar(HttpSession session) {
		int userId = Integer.parseInt(session.getAttribute("id").toString());
		StudentDetail studentDetail = studentService.getById(userId);
		ModelAndView model = new ModelAndView("lifecalendar");
		model.addObject("studentName", studentDetail.getName());
		return model;
	}

}
