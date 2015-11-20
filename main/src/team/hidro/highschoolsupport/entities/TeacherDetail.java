package team.hidro.highschoolsupport.entities;

public class TeacherDetail {

	private String userId;
	private String name;
	private String detail;
	private String avatar;

	public TeacherDetail(String userId, String name, String detail, String avatar) {
		super();
		this.userId = userId;
		this.name = name;
		this.detail = detail;
		this.avatar = avatar;
	}

	public TeacherDetail() {
		super();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
