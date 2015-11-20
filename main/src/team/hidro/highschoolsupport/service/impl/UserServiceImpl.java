package team.hidro.highschoolsupport.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.hidro.highschoolsupport.dao.UserDao;
import team.hidro.highschoolsupport.entities.UserDetail;
import team.hidro.highschoolsupport.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetail checkUser(String username, String password) {

		return userDao.checkUser(username, password);
	}

}
