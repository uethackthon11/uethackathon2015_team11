package team.hidro.highschoolsupport.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import team.hidro.highschoolsupport.entities.ListClassDetail;
import team.hidro.highschoolsupport.service.TeacherService;

@Controller
public class ScoreController {

	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping("/test/{id}")
	public @ResponseBody List<ListClassDetail> _getClass(@PathVariable("id") int id){
		return teacherService.getListClassByTeacherId(id);
	}
}
