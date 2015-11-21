package team.hidro.highschoolsupport.dao;

import java.util.List;

import team.hidro.highschoolsupport.entities.CommentProfile;
import team.hidro.highschoolsupport.entities.StudentDetail;

public interface StudentDao extends Dao<StudentDetail, Integer> {
	
	public StudentDetail getByName(String usernme);
	
	public List<StudentDetail> getListStudentByClassId(int id);
	
	public List<CommentProfile> getListCommentProfile(String username);
}
