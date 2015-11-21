package team.hidro.highschoolsupport.dao;

import java.util.List;

import team.hidro.highschoolsupport.entities.GroupDetail;
import team.hidro.highschoolsupport.entities.StatusDetail;

public interface GroupDao extends Dao<GroupDetail,Integer>{
	List<StatusDetail> getListStatusByGroupId(int groupId);
}