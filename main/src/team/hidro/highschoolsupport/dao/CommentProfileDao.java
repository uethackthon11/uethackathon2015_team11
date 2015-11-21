package team.hidro.highschoolsupport.dao;

public interface CommentProfileDao {

	public boolean addComment(int teacherId, int studentId, String content);
	
}
