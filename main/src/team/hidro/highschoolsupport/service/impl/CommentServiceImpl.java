package team.hidro.highschoolsupport.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import team.hidro.highschoolsupport.entities.CommentDetail;
import team.hidro.highschoolsupport.entities.StatusDetail;
import team.hidro.highschoolsupport.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService{

	@Override
	public boolean save(CommentDetail item) {
		return false;
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
		// TODO Auto-generated method stub
		return null;
	}

}
