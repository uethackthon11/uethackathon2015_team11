package team.hidro.highschoolsupport.service;

import java.util.List;

import team.hidro.highschoolsupport.entities.CommentDetail;
import team.hidro.highschoolsupport.entities.StatusDetail;

public interface CommentService extends Service<CommentDetail,Integer>{
	
	public List<StatusDetail> setListCommentForStatus(List<StatusDetail> statusDetails);

}
