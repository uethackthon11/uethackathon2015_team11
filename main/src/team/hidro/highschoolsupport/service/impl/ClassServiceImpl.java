package team.hidro.highschoolsupport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.hidro.highschoolsupport.entities.ClassDetail;
import team.hidro.highschoolsupport.entities.StudentDetail;
import team.hidro.highschoolsupport.entities.StudentScoreDetail;
import team.hidro.highschoolsupport.service.ClassService;
import team.hidro.highschoolsupport.service.ScoreService;
import team.hidro.highschoolsupport.service.StudentService;


@Service
public class ClassServiceImpl implements ClassService {
	@Autowired
	private StudentService studentService;
	@Autowired
	private ScoreService scoreService;


	@Override
	public ClassDetail getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClassDetail> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ClassDetail item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<StudentScoreDetail> getListStudentScoreByClassAndSubject(int classId, int subjectId,int ky) {
		
		List<StudentDetail> students = studentService.getListStudentByClassId(classId);
		return scoreService.getListStudentScoreByListStudent(students, ky);
	}

	@Override
	public boolean save(ClassDetail item) {
		// TODO Auto-generated method stub
		return false;
	}

}
