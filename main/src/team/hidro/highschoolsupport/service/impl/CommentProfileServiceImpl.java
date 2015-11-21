package team.hidro.highschoolsupport.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.hidro.highschoolsupport.dao.CommentProfileDao;
import team.hidro.highschoolsupport.service.CommentProfileService;

@Service
public class CommentProfileServiceImpl implements CommentProfileService{

	@Autowired
	private CommentProfileDao commentProfile;
	
	@Override
	public boolean addComment(int teacherId, int studentId, String content) {
		return commentProfile.addComment(teacherId, studentId, content);
	}

	
	
}
