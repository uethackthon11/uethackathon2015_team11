package team.hidro.highschoolsupport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.hidro.highschoolsupport.dao.StatusDao;
import team.hidro.highschoolsupport.entities.StatusDetail;
import team.hidro.highschoolsupport.service.CommentService;
import team.hidro.highschoolsupport.service.StatusService;
import team.hidro.highschoolsupport.service.UserService;

@Service
public class StatusServiceImpl implements StatusService {
	@Autowired
	private StatusDao statusDao;
	@Autowired
	private CommentService commentService;
	@Autowired
	private UserService userService;
	
	
	@Override
	public boolean save(StatusDetail item) {
		
		return statusDao.save(item);
	}

	@Override
	public StatusDetail getById(Integer id) {
		return null;
	}

	@Override
	public List<StatusDetail> getList() {
		return null;
	}

	@Override
	public boolean update(StatusDetail item) {
		return false;
	}

	@Override
	public void remove(Integer id) {
	}

	@Override
	public List<StatusDetail> getListStatusByGroupId(int groupId) {
		List<StatusDetail> statusDetails = statusDao.getListStatusByGroupId(groupId);
		statusDetails = commentService.setListCommentForStatus(statusDetails);
		statusDetails = userService.setWriterForListStatus(statusDetails);
		return statusDetails;
	}

}
