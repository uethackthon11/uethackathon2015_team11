package team.hidro.highschoolsupport.entities;

public class WriterDetail {
	private String name;
	private int id;
	private String avatar;
	public WriterDetail(String name, int id, String avatar) {
		super();
		this.name = name;
		this.id = id;
		this.avatar = avatar;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
}
