package team.hidro.highschoolsupport.entities;

public class ParentDetail {

	private int id;
	private String name;
	private String email;
	private int childId;
	private String childName;

	public ParentDetail(int id, String name, String email, int childId, String childName) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.childId = childId;
		this.childName = childName;
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getChildId() {
		return childId;
	}

	public void setChildId(int childId) {
		this.childId = childId;
	}

}
