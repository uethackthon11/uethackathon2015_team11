package team.hidro.highschoolsupport.dao;

import java.util.List;

import team.hidro.highschoolsupport.entities.StatusDetail;
import team.hidro.highschoolsupport.entities.UserDetail;

public interface UserDao {

	public UserDetail checkUser(String username, String password);
	
	public List<StatusDetail> setWriterForListStatus(List<StatusDetail> statusDetails);
	
}
