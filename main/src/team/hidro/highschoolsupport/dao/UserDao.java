package team.hidro.highschoolsupport.dao;

import team.hidro.highschoolsupport.entities.UserDetail;

public interface UserDao {

	public UserDetail checkUser(String username, String password);
	
}
