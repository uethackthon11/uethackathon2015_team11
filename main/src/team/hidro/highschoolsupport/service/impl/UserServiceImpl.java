package team.hidro.highschoolsupport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.hidro.highschoolsupport.dao.UserDao;
import team.hidro.highschoolsupport.entities.CommentDetail;
import team.hidro.highschoolsupport.entities.StatusDetail;
import team.hidro.highschoolsupport.entities.UserDetail;
import team.hidro.highschoolsupport.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetail checkUser(String username, String password) {

		return userDao.checkUser(username, password);
	}

	@Override
	public List<StatusDetail> setWriterForListStatus(List<StatusDetail> statusDetails) {
		return userDao.setWriterForListStatus(statusDetails);
	}

	@Override
	public List<CommentDetail> setWriterForListComment(List<CommentDetail> listCommentDetails) {
		return userDao.setWriterForListComment(listCommentDetails);
	}

	@Override
	public StatusDetail setWriterForStatus(StatusDetail statusDetail) {
		return userDao.setWriterForStatus(statusDetail);
	}

}
