package team.hidro.highschoolsupport.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.hidro.highschoolsupport.dao.ParentDao;
import team.hidro.highschoolsupport.entities.ParentDetail;
import team.hidro.highschoolsupport.service.ParentService;

@Service
public class ParentServiceImpl implements ParentService {

	@Autowired
	private ParentDao parentDao;
	@Override
	public ParentDetail getById(Integer id) {
		return parentDao.getById(id);
	}

}
