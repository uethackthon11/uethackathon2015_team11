package team.hidro.highschoolsupport.service;

import java.util.List;

import team.hidro.highschoolsupport.entities.ClassDetail;
import team.hidro.highschoolsupport.entities.StudentScoreDetail;


public interface ClassService extends Service<ClassDetail,Integer> {
	public List<StudentScoreDetail> getListStudentScoreByClassAndSubject(int classId,int subjectId,int ky);
}
