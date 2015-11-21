package team.hidro.highschoolsupport.service;

import java.util.List;

import team.hidro.highschoolsupport.entities.CommentProfile;
import team.hidro.highschoolsupport.entities.StudentDetail;
import team.hidro.highschoolsupport.entities.SubjectScore;

public interface StudentService extends Service<StudentDetail, Integer>{

	public StudentDetail getByName(String username);
	
	public List<StudentDetail> getListStudentByClassId(int id);
	
	public List<CommentProfile> getListCommentProfile(String id);
	public List<SubjectScore> getListSubjectScore(String username);
}
