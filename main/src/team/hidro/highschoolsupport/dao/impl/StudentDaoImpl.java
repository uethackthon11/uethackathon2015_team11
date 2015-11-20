package team.hidro.highschoolsupport.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import team.hidro.highschoolsupport.dao.AutoWireJdbcDaoSupport;
import team.hidro.highschoolsupport.dao.StudentDao;
import team.hidro.highschoolsupport.entities.StudentDetail;


@Repository
public class StudentDaoImpl extends AutoWireJdbcDaoSupport implements StudentDao{

	@Override
	public List<StudentDetail> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentDetail getById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer save(StudentDetail item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(StudentDetail item) {
		// TODO Auto-generated method stub
		
	}

}
