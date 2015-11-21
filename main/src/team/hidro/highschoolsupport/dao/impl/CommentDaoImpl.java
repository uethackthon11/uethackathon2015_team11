package team.hidro.highschoolsupport.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import team.hidro.highschoolsupport.dao.AutoWireJdbcDaoSupport;
import team.hidro.highschoolsupport.dao.CommentDao;
import team.hidro.highschoolsupport.entities.CommentDetail;

@Repository
public class CommentDaoImpl extends AutoWireJdbcDaoSupport implements CommentDao{

	@Override
	public List<CommentDetail> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommentDetail getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(CommentDetail item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean update(CommentDetail item) {
		// TODO Auto-generated method stub
		return false;
	}


}
