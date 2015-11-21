package team.hidro.highschoolsupport.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import team.hidro.highschoolsupport.entities.CommentProfile;
import team.hidro.highschoolsupport.entities.StudentDetail;
import team.hidro.highschoolsupport.entities.SubjectScore;
import team.hidro.highschoolsupport.entities.TeacherDetail;
import team.hidro.highschoolsupport.service.CommentProfileService;
import team.hidro.highschoolsupport.service.StudentService;

@Controller
public class ProfileController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private CommentProfileService commentProfile;

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
	@RequestMapping(value = "/{username}/profile/add_comment", method = RequestMethod.POST)
	public @ResponseBody void addComment(@PathVariable("username") String username,@RequestParam Map<String,String> params, HttpSession session){
		StudentDetail student = studentService.getByName(username);
		if(student == null)
			student = studentService.getById(Integer.parseInt(username));
		TeacherDetail teacher = (TeacherDetail)session.getAttribute("user"); 
		String message = params.toString();
		message = message.split(":")[1];
		message = message.substring(1, message.length() - 4);
		commentProfile.addComment(teacher.getUserId(), student.getUserId(),message);
	}

}
