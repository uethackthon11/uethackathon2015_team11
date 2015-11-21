package team.hidro.highschoolsupport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.hidro.highschoolsupport.dao.CommentDao;
import team.hidro.highschoolsupport.entities.CommentDetail;
import team.hidro.highschoolsupport.entities.StatusDetail;
import team.hidro.highschoolsupport.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentDao commentDao;

	@Override
	public boolean save(CommentDetail item) {
		return commentDao.save(item);
	}

	@Override
	public CommentDetail getById(Integer id) {
		return null;
	}

	@Override
	public List<CommentDetail> getList() {
		return null;
	}

	@Override
	public boolean update(CommentDetail item) {
		return false;
	}

	@Override
	public void remove(Integer id) {
		
	}

	@Override
	public List<StatusDetail> setListCommentForStatus(List<StatusDetail> statusDetails) {
		return commentDao.setListCommentForStatus(statusDetails);
	}

}
