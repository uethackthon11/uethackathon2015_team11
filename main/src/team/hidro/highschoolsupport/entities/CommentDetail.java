package team.hidro.highschoolsupport.entities;

public class CommentDetail {
	private String content;
	private Long dateTime;
	private int userId;
	private int statusId;
	private String vote;
	private String unVote;
	private int voteScore;
	private WriterDetail writerDetail;
	
	
	public CommentDetail(String content, Long dateTime, int userId, int statusId, String vote, String unVote,
			int voteScore, WriterDetail writerDetail) {
		super();
		this.content = content;
		this.dateTime = dateTime;
		this.userId = userId;
		this.statusId = statusId;
		this.vote = vote;
		this.unVote = unVote;
		this.voteScore = voteScore;
		this.writerDetail = writerDetail;
	}

	public CommentDetail(String content, Long dateTime, int userId, int statusId, WriterDetail writerDetail) {
		super();
		this.content = content;
		this.dateTime = dateTime;
		this.userId = userId;
		this.statusId = statusId;
		this.writerDetail = writerDetail;
	}
	
	public int getVoteScore() {
		return voteScore;
	}

	public void setVoteScore(int voteScore) {
		this.voteScore = voteScore;
	}

	public String getVote() {
		return vote;
	}

	public void setVote(String vote) {
		this.vote = vote;
	}

	public String getUnVote() {
		return unVote;
	}

	public void setUnVote(String unVote) {
		this.unVote = unVote;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getUserId() {
		return userId;
	}

	public CommentDetail(String content, Long dateTime, int userId) {
		super();
		this.content = content;
		this.dateTime = dateTime;
		this.userId = userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public CommentDetail(String content, Long dateTime, WriterDetail writerDetail) {
		super();
		this.content = content;
		this.dateTime = dateTime;
		this.writerDetail = writerDetail;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getDateTime() {
		return dateTime;
	}

	public void setDateTime(Long dateTime) {
		this.dateTime = dateTime;
	}

	public WriterDetail getWriterDetail() {
		return writerDetail;
	}

	public void setWriterDetail(WriterDetail writerDetail) {
		this.writerDetail = writerDetail;
	}
}
