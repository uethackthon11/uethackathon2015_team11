package team.hidro.highschoolsupport.entities;

public class Notification {

	private int id;
	private int sender_id;
	private String sender_name;
	private int reciever;
	private String reciever_name;
	private long time;
	private String message;
	private int status;
	private int type;

	public Notification(int id, int sender_id, String sender_name, int reciever, String reciever_name, long time,
			String message, int status, int type) {
		super();
		this.id = id;
		this.sender_id = sender_id;
		this.sender_name = sender_name;
		this.reciever = reciever;
		this.reciever_name = reciever_name;
		this.time = time;
		this.message = message;
		this.status = status;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSender_id() {
		return sender_id;
	}

	public void setSender_id(int sender_id) {
		this.sender_id = sender_id;
	}

	public String getSender_name() {
		return sender_name;
	}

	public void setSender_name(String sender_name) {
		this.sender_name = sender_name;
	}

	public int getReciever() {
		return reciever;
	}

	public void setReciever(int reciever) {
		this.reciever = reciever;
	}

	public String getReciever_name() {
		return reciever_name;
	}

	public void setReciever_name(String reciever_name) {
		this.reciever_name = reciever_name;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
