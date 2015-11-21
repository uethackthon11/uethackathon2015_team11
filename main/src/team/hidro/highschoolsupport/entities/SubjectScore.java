package team.hidro.highschoolsupport.entities;

import java.util.ArrayList;

public class SubjectScore {

	private String name;
	private ArrayList<ScoreDetail> scores;

	public SubjectScore(String name, ArrayList<ScoreDetail> scores) {
		super();
		this.name = name;
		this.scores = scores;
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
