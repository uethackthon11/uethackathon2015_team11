package team.hidro.highschoolsupport.service;

import java.util.List;

import team.hidro.highschoolsupport.entities.ClassDetail;
import team.hidro.highschoolsupport.entities.ListClassDetail;
import team.hidro.highschoolsupport.entities.TeacherDetail;

public interface TeacherService extends Service<TeacherDetail,Integer>{
	public List<ListClassDetail> getListClassByTeacherId(int id);

}
