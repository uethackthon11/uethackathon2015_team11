package team.hidro.highschoolsupport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.hidro.highschoolsupport.dao.ScoreDao;
import team.hidro.highschoolsupport.entities.ScoreDetail;
import team.hidro.highschoolsupport.entities.StudentDetail;
import team.hidro.highschoolsupport.entities.StudentScoreDetail;
import team.hidro.highschoolsupport.service.ScoreService;
@Service
public class ScoreSeviceImpl implements ScoreService {
	@Autowired
	private ScoreDao scoreDao; 
	

	@Override
	public Integer save(ScoreDetail item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScoreDetail getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ScoreDetail> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ScoreDetail item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<StudentScoreDetail> getListStudentScoreByListStudent(List<StudentDetail> students,int ky) {
		return scoreDao.getListStudentScoreByListStudent(students, ky);
	}
}
