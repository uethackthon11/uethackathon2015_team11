package team.hidro.highschoolsupport.entities;

import java.util.List;

public class StatusDetail {
	private String content;
	private Long dateTime;
	private List<CommentDetail> commentDetails;
	private WriterDetail writerDetail;

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
