package team.hidro.highschoolsupport.entities;

public class ScoreDetail {
	private int id;
	private int score;
	private int type;
	private int userId;
	private int subjectYearId;
	private int ky;
	
	public ScoreDetail(int type) {
		super();
		this.type = type;
	}
	public ScoreDetail(int id, int score, int type) {
		super();
		this.id = id;
		this.score = score;
		this.type = type;
	}
	public ScoreDetail(int score, int type) {
		super();
		this.score = score;
		this.type = type;
	}
	public ScoreDetail(int score, int type, int userId, int subjectYearId, int ky) {
		super();
		this.score = score;
		this.type = type;
		this.userId = userId;
		this.subjectYearId = subjectYearId;
		this.ky = ky;
	}
	public ScoreDetail(int id, int score, int type, int userId, int subjectYearId, int ky) {
		super();
		this.id = id;
		this.score = score;
		this.type = type;
		this.userId = userId;
		this.subjectYearId = subjectYearId;
		this.ky = ky;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getSubjectYearId() {
		return subjectYearId;
	}
	
	
	public void setSubjectYearId(int subjectYearId) {
		this.subjectYearId = subjectYearId;
	}
	public int getKy() {
		return ky;
	}
	public void setKy(int ky) {
		this.ky = ky;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
