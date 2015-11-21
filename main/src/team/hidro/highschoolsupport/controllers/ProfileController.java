package team.hidro.highschoolsupport.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import team.hidro.highschoolsupport.entities.CommentProfile;
import team.hidro.highschoolsupport.entities.StudentDetail;
import team.hidro.highschoolsupport.entities.SubjectScore;
import team.hidro.highschoolsupport.service.StudentService;

@Controller
public class ProfileController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/{username}/profile")
	public ModelAndView profileView(@PathVariable("username") String username) {
		ModelAndView model = new ModelAndView("profile");
		model.addObject("student_name", username);
		return model;

	}

	@RequestMapping("/{username}/user_detail")
	public @ResponseBody StudentDetail getStudent(@PathVariable("username") String username) {

		return studentService.getByName(username);

	}

	@RequestMapping("/{username}/comments")
	public @ResponseBody List<CommentProfile> getComments(@PathVariable("username") String username) {
		return studentService.getListCommentProfile(username);
	}
	@RequestMapping("/{username}/scores")
	public @ResponseBody List<SubjectScore> getSubjectScore(@PathVariable("username") String username){
		
		return studentService.getListSubjectScore(username);
		
	}

}
