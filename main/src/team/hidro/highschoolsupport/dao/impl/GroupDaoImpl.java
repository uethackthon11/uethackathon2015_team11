package team.hidro.highschoolsupport.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import team.hidro.highschoolsupport.dao.AutoWireJdbcDaoSupport;
import team.hidro.highschoolsupport.dao.GroupDao;
import team.hidro.highschoolsupport.entities.GroupDetail;

@Repository
public class GroupDaoImpl extends AutoWireJdbcDaoSupport implements GroupDao{

	@Override
	public List<GroupDetail> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupDetail getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(GroupDetail item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean update(GroupDetail item) {
		// TODO Auto-generated method stub
		return false;
	}

}
