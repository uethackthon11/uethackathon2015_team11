package team.hidro.highschoolsupport.service;

import java.util.List;

import team.hidro.highschoolsupport.entities.StudentDetail;

public interface StudentService extends Service<StudentDetail, Integer>{

	public StudentDetail getByName(String username);
	
	public List<StudentDetail> getListStudentByClassId(int id);
}
