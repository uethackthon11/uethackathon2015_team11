package team.hidro.highschoolsupport.service;

import java.util.List;

import team.hidro.highschoolsupport.entities.InitialStatusDetail;
import team.hidro.highschoolsupport.entities.StatusDetail;

public interface StatusService extends Service<StatusDetail,Integer>{

	List<StatusDetail> getListStatusByGroupId(int groupId);
	InitialStatusDetail getListInitialStatusByGroupId(int groupId);
	
}
