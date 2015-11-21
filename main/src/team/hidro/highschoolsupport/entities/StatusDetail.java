package team.hidro.highschoolsupport.entities;

import java.util.List;

public class StatusDetail {
	private int id;
	private int groupId;
	private int userId;
	private String content;
	private Long dateTime;
	private List<CommentDetail> commentDetails;
	private WriterDetail writerDetail;
	private int enable;
	private int type;
	
	
	
	public StatusDetail(int id, int groupId, int userId, String content, Long dateTime,
			List<CommentDetail> commentDetails, WriterDetail writerDetail, int enable, int type) {
		super();
		this.id = id;
		this.groupId = groupId;
		this.userId = userId;
		this.content = content;
		this.dateTime = dateTime;
		this.commentDetails = commentDetails;
		this.writerDetail = writerDetail;
		this.enable = enable;
		this.type = type;
	}



	public StatusDetail(int id, int groupId, int userId, String content, Long dateTime,
			List<CommentDetail> commentDetails, WriterDetail writerDetail) {
		super();
		this.id = id;
		this.groupId = groupId;
		this.userId = userId;
		this.content = content;
		this.dateTime = dateTime;
		this.commentDetails = commentDetails;
		this.writerDetail = writerDetail;
	}
	
	

	public int getEnable() {
		return enable;
	}



	public void setEnable(int enable) {
		this.enable = enable;
	}



	public int getType() {
		return type;
	}



	public void setType(int type) {
		this.type = type;
	}



	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	
	
	public int getId() {
		return id;
	}

	public StatusDetail(int id, int userId, String content, Long dateTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.content = content;
		this.dateTime = dateTime;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public StatusDetail(String content, Long dateTime, List<CommentDetail> commentDetails, WriterDetail writerDetail) {
		super();
		this.content = content;
		this.dateTime = dateTime;
		this.commentDetails = commentDetails;
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

	public List<CommentDetail> getCommentDetails() {
		return commentDetails;
	}

	public void setCommentDetails(List<CommentDetail> commentDetails) {
		this.commentDetails = commentDetails;
	}

	public WriterDetail getWriterDetail() {
		return writerDetail;
	}

	public void setWriterDetail(WriterDetail writerDetail) {
		this.writerDetail = writerDetail;
	}
}
