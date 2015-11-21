package team.hidro.highschoolsupport.entities;

public class ClassScoreStudent {

	private ScoreDetail scoreDetail;
	private String name;

	public ClassScoreStudent(ScoreDetail scoreDetail, String name) {
		super();
		this.scoreDetail = scoreDetail;
		this.name = name;
	}

	public ScoreDetail getScoreDetail() {
		return scoreDetail;
	}

	public void setScoreDetail(ScoreDetail scoreDetail) {
		this.scoreDetail = scoreDetail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
