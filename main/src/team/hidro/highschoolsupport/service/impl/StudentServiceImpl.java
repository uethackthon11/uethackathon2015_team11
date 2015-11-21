package team.hidro.highschoolsupport.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.hidro.highschoolsupport.dao.StudentDao;
import team.hidro.highschoolsupport.entities.CommentProfile;
import team.hidro.highschoolsupport.entities.ScoreDetail;
import team.hidro.highschoolsupport.entities.StudentDetail;
import team.hidro.highschoolsupport.entities.SubjectScore;
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
	public List<StudentDetail> getList() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StudentDetail getById(Integer id) {
		return studentDao.getById(id);
	}

	@Override
	public StudentDetail getByName(String username) {
		return studentDao.getByName(username);
	}
	
	
	@Override
	public List<StudentDetail> getListStudentByClassId(int id) {
		return studentDao.getListStudentByClassId(id);
	}

	@Override
	public boolean save(StudentDetail item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(StudentDetail item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CommentProfile> getListCommentProfile(String id) {
		
		List<CommentProfile> commentProfiles = studentDao.getListCommentProfile(id);
		
		Collections.sort(commentProfiles, new Comparator<CommentProfile>() {

			@Override
			public int compare(CommentProfile o1, CommentProfile o2) {
				if (o1.getTime() < o2.getTime()) {
					return 1;
				} else {
					if (o1.getTime() == o2.getTime()) {
						return 0;
					} else {
						return -1;
					}
				}
			}
		});
		
		return commentProfiles;
	}

	@Override
	public List<SubjectScore> getListSubjectScore(String username) {
		List<SubjectScore> subjectScores = studentDao.getListSubjectScore(username);
		
		return subjectScores;
	}

}
