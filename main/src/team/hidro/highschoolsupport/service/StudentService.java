package team.hidro.highschoolsupport.service;

import team.hidro.highschoolsupport.entities.StudentDetail;

public interface StudentService extends Service<StudentDetail, Integer>{

	public StudentDetail getByName(String username);
	
}
