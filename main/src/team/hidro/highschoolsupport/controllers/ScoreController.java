package team.hidro.highschoolsupport.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import team.hidro.highschoolsupport.entities.StudentScoreDetail;
import team.hidro.highschoolsupport.service.ClassService;

@Controller
public class ScoreController {

	@Autowired
	private ClassService teacherService;
	
	@RequestMapping("/test/{id}")
	public @ResponseBody List<StudentScoreDetail> _getClass(@PathVariable("id") int id){
		return teacherService.getListStudentScoreByClassAndSubject(1, 4, 1);
	}
}
