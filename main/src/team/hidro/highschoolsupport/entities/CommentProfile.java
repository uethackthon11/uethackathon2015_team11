package team.hidro.highschoolsupport.entities;

public class CommentProfile {

	private String writer;
	private String content;
	private Long time;
	private String avatar;

	public CommentProfile(String writer, String content, Long time, String avatar) {
		super();
		this.writer = writer;
		this.content = content;
		this.time = time;
		this.avatar = avatar;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
