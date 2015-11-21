package team.hidro.highschoolsupport.entities;

import java.util.ArrayList;
import java.util.List;

public class SubjectScore {

	private String name;
	private ArrayList<ClassScoreStudent> scores;

	public SubjectScore(String name, ArrayList<ClassScoreStudent> scores) {
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

	public ArrayList<ClassScoreStudent> getScores() {
		return scores;
	}

	public void setScores(ArrayList<ClassScoreStudent> scores) {
		this.scores = scores;
	}

}
