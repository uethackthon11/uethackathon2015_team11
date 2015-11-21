package team.hidro.highschoolsupport.dao;

import java.util.List;

import team.hidro.highschoolsupport.entities.StatusDetail;

public interface StatusDao extends Dao<StatusDetail,Integer> {
	List<StatusDetail> getListStatusByGroupId(int groupId);
}