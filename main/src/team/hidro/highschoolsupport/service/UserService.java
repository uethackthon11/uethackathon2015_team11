package team.hidro.highschoolsupport.service;

import java.util.List;

import team.hidro.highschoolsupport.entities.StatusDetail;
import team.hidro.highschoolsupport.entities.UserDetail;

public interface UserService {

	public UserDetail checkUser(String username, String password);
	
	public List<StatusDetail> setWriterForListStatus(List<StatusDetail> statusDetails);
	
}
