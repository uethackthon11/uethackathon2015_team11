package team.hidro.highschoolsupport.dao;

import java.util.List;

import team.hidro.highschoolsupport.entities.ScoreDetail;
import team.hidro.highschoolsupport.entities.StudentDetail;
import team.hidro.highschoolsupport.entities.StudentScoreDetail;

public interface ScoreDao extends Dao<ScoreDetail, Integer> {
	public List<StudentScoreDetail> getListStudentScoreByListStudent(int subjectId, List<StudentDetail> students,int ky);
	public boolean addOrUpdate(ScoreDetail scoreDetail);
}