package team.hidro.highschoolsupport.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import team.hidro.highschoolsupport.dao.AutoWireJdbcDaoSupport;
import team.hidro.highschoolsupport.dao.StatusDao;
import team.hidro.highschoolsupport.entities.StatusDetail;

@Repository
public class StatusDaoImpl extends AutoWireJdbcDaoSupport implements StatusDao{

	@Override
	public List<StatusDetail> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusDetail getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(StatusDetail item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean update(StatusDetail item) {
		// TODO Auto-generated method stub
		return false;
	}

}
