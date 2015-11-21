package team.hidro.highschoolsupport.entities;

import java.util.ArrayList;

public class SubjectScore {

	private String name;
	private int teacherId;
	private ArrayList<ScoreDetail> scores;

	public SubjectScore(String name, int teacherId, ArrayList<ScoreDetail> scores) {
		super();
		this.name = name;
		this.teacherId = teacherId;
		this.scores = scores;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<ScoreDetail> getScores() {
		return scores;
	}

	public void setScores(ArrayList<ScoreDetail> scores) {
		this.scores = scores;
	}

}
