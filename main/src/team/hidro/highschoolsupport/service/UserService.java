package team.hidro.highschoolsupport.service;

import team.hidro.highschoolsupport.entities.UserDetail;

public interface UserService {

	public UserDetail checkUser(String username, String password);
	
}
