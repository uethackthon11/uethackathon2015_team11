package team.hidro.highschoolsupport.entities;

public class StudentDetail {

	private int userId;
	private String name;
	private String birthday;
	private String avatar;
	private int sex;
	private String address;
	private String introduce;
	private int classId;

	public StudentDetail(int userId, String name, String birthday, String avatar, int sex, String address,
			String introduce, int classId) {
		super();
		this.userId = userId;
		this.name = name;
		this.birthday = birthday;
		this.avatar = avatar;
		this.sex = sex;
		this.address = address;
		this.introduce = introduce;
		this.classId = classId;
	}

	public StudentDetail() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

}
