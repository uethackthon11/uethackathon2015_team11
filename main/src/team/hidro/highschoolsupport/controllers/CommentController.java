package team.hidro.highschoolsupport.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import team.hidro.highschoolsupport.entities.CommentDetail;
import team.hidro.highschoolsupport.service.CommentService;

@Controller
public class CommentController {
	@Autowired
	private CommentService commentService;
	

	@RequestMapping(value = "/{userId}/{idStatus}/newComment", method = RequestMethod.POST)
	public @ResponseBody boolean createComment(@PathVariable("userId") int userId,
			@PathVariable("idStatus") int statusId, @RequestParam("content") String content) {
		long dateTime = System.currentTimeMillis();
		CommentDetail commentDetail = new CommentDetail(content, dateTime, userId, statusId, null);
		return commentService.save(commentDetail);
	}
	
	@RequestMapping(value = "/{userId}/{idComment}/vote", method = RequestMethod.GET)
	public @ResponseBody boolean vote(@PathVariable("userId") int userId,@RequestParam("content") String content) {
		long dateTime = System.currentTimeMillis();
		CommentDetail commentDetail = new CommentDetail(content, dateTime, userId, 0, null);
		return commentService.save(commentDetail);
	}
	
	
	
	
	

}
