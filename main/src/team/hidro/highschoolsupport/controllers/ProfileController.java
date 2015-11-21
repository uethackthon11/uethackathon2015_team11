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
import team.hidro.highschoolsupport.service.StudentService;

@Controller
public class ProfileController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/{id}/profile")
	public ModelAndView profileView() {

		return new ModelAndView("profile");

	}

	@RequestMapping("/{username}/user_detail")
	public @ResponseBody StudentDetail getStudent(@PathVariable("username") String username) {

		return studentService.getByName(username);

	}

	@RequestMapping("/{id}/comments")
	public @ResponseBody List<CommentProfile> getComments(@PathVariable("id") int id) {
		return studentService.getListCommentProfile(id);
	}

}
