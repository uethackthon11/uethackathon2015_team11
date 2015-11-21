package team.hidro.highschoolsupport.dao;

import java.util.List;

import team.hidro.highschoolsupport.entities.ListClassDetail;
import team.hidro.highschoolsupport.entities.TeacherDetail;

public interface TeacherDao extends Dao<TeacherDetail,Integer>{
	public List<ListClassDetail> getListClassByTeacherId(int id);
	public TeacherDetail getByName(String usernme);
}
