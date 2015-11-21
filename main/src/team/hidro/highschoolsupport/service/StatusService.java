package team.hidro.highschoolsupport.service;

import java.util.List;

import team.hidro.highschoolsupport.entities.StatusDetail;

public interface StatusService extends Service<StatusDetail,Integer>{

	public List<StatusDetail> getListStatusByGroupId(int groupId);
}
