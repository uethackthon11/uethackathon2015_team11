package team.hidro.highschoolsupport.entities;

import java.util.List;

public class ListClassDetail {
	private String subjectName;
	private ClassDetail classDetail;
	private int subjectId;
	
	
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public ClassDetail getClassDetail() {
		return classDetail;
	}
	public ListClassDetail(int subjectId, String subjectName, ClassDetail classDetail) {
		super();
		this.subjectId=subjectId;
		this.subjectName = subjectName;
		this.classDetail = classDetail;
	}
	public void setClassDetail(ClassDetail classDetail) {
		this.classDetail = classDetail;
	}
	

}
