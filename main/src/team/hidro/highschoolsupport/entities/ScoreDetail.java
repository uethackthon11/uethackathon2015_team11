package team.hidro.highschoolsupport.entities;

public class ScoreDetail {
	private int score;
	private int type;
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getType() {
		return type;
	}
	public ScoreDetail(int score, int type) {
		super();
		this.score = score;
		this.type = type;
	}
	public void setType(int type) {
		this.type = type;
	}

}
