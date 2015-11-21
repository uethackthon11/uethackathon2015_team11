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
	public void remove(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<StudentScoreDetail> getListStudentScoreByListStudent(int subjectId, List<StudentDetail> students,int ky) {
		return scoreDao.getListStudentScoreByListStudent(subjectId, students, ky);
	}

	@Override
	public boolean save(ScoreDetail item) {
		return scoreDao.save(item);
	}

	@Override
	public boolean addOrUpdate(ScoreDetail scoreDetail) {
		return scoreDao.addOrUpdate(scoreDetail);
	}

	@Override
	public boolean update(ScoreDetail item) {
		return scoreDao.update(item);
	}
}
