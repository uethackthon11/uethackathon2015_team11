package team.hidro.highschoolsupport.dao;

import java.util.List;

import team.hidro.highschoolsupport.entities.CommentDetail;
import team.hidro.highschoolsupport.entities.StatusDetail;

public interface CommentDao extends Dao<CommentDetail,Integer>{
	public List<StatusDetail> setListCommentForStatus(List<StatusDetail> statusDetails);
	public List<CommentDetail> getListCommentByStatusId(int statusId);
}
