package team.hidro.highschoolsupport.entities;

import java.util.List;

public class StudentScoreDetail {
	private List<ScoreDetail> scores;
	private StudentDetail studentDetail;
	
	public List<ScoreDetail> getScores() {
		return scores;
	}
	public void setScores(List<ScoreDetail> scores) {
		this.scores = scores;
	}
	public StudentScoreDetail(List<ScoreDetail> scores, StudentDetail studentDetail) {
		super();
		this.scores = scores;
		this.studentDetail = studentDetail;
	}
	public StudentDetail getStudentDetail() {
		return studentDetail;
	}
	public void setStudentDetail(StudentDetail studentDetail) {
		this.studentDetail = studentDetail;
	}

}
