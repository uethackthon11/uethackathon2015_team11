package team.hidro.highschoolsupport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.hidro.highschoolsupport.dao.TeacherDao;
import team.hidro.highschoolsupport.entities.ListClassDetail;
import team.hidro.highschoolsupport.entities.TeacherDetail;
import team.hidro.highschoolsupport.service.TeacherService;


@Service
public class TeacherServiceImpl implements TeacherService{
	@Autowired
	private TeacherDao teacherDao;
	

	@Override
	public TeacherDetail getById(Integer id) {
		return teacherDao.getById(id);
	}

	@Override
	public List<TeacherDetail> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(TeacherDetail item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ListClassDetail> getListClassByTeacherId(int id) {
		return teacherDao.getListClassByTeacherId(id);
	}

	public TeacherDao getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	@Override
	public boolean save(TeacherDetail item) {
		// TODO Auto-generated method stub
		return false;
	}

}
