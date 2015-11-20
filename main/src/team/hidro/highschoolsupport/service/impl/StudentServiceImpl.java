package team.hidro.highschoolsupport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.hidro.highschoolsupport.dao.StudentDao;
import team.hidro.highschoolsupport.entities.StudentDetail;
import team.hidro.highschoolsupport.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	public StudentDao studentDao;

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public Integer save(StudentDetail item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentDetail> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(StudentDetail item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StudentDetail getById(Integer id) {
		return studentDao.getById(id);
	}

}
