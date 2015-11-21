package team.hidro.highschoolsupport.service;

import java.util.List;

import team.hidro.highschoolsupport.entities.InitialStatusDetail;
import team.hidro.highschoolsupport.entities.StatusDetail;

public interface StatusService extends Service<StatusDetail,Integer>{

	List<StatusDetail> getListStatusByGroupId(int groupId);
	List<StatusDetail> getListStatusByGroupIdType1(int groupId);
	List<StatusDetail> getListStatusByGroupIdType2(int groupId);
	List<StatusDetail> getListStatusByGroupIdType3(int groupId);
	InitialStatusDetail getListInitialStatusByGroupId(int groupId);
	
}
