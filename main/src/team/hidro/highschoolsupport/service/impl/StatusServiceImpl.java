package team.hidro.highschoolsupport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.hidro.highschoolsupport.dao.StatusDao;
import team.hidro.highschoolsupport.entities.InitialStatusDetail;
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
		StatusDetail statusDetail = statusDao.getById(id);
		statusDetail = commentService.setCommentForStatus(statusDetail);
		statusDetail = userService.setWriterForStatus(statusDetail);
		return statusDetail;
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
		statusDetails = userService.setWriterForListStatus(statusDetails);
		return statusDetails;
	}

	@Override
	public InitialStatusDetail getListInitialStatusByGroupId(int groupId) {
		InitialStatusDetail initialStatusDetail = statusDao.getListInitialStatusByGroupId(groupId);
		initialStatusDetail.setHoiDaps(userService.setWriterForListStatus(initialStatusDetail.getHoiDaps()));
		initialStatusDetail.setThongBaos(userService.setWriterForListStatus(initialStatusDetail.getThongBaos()));
		initialStatusDetail.setTaiLieus(userService.setWriterForListStatus(initialStatusDetail.getTaiLieus()));
		return initialStatusDetail;
	}

	@Override
	public List<StatusDetail> getListStatusByGroupIdType1(int groupId) {
		List<StatusDetail> statusDetails = statusDao.getListStatusByGroupIdType1(groupId);
		statusDetails = userService.setWriterForListStatus(statusDetails);
		return statusDetails;
	}

	@Override
	public List<StatusDetail> getListStatusByGroupIdType2(int groupId) {
		List<StatusDetail> statusDetails = statusDao.getListStatusByGroupIdType2(groupId);
		statusDetails = userService.setWriterForListStatus(statusDetails);
		return statusDetails;
	}

	@Override
	public List<StatusDetail> getListStatusByGroupIdType3(int groupId) {
		List<StatusDetail> statusDetails = statusDao.getListStatusByGroupIdType3(groupId);
		statusDetails = userService.setWriterForListStatus(statusDetails);
		return statusDetails;
	}

}
