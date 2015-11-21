package team.hidro.highschoolsupport.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team.hidro.highschoolsupport.dao.AutoWireJdbcDaoSupport;
import team.hidro.highschoolsupport.dao.CommentDao;
import team.hidro.highschoolsupport.entities.CommentDetail;
import team.hidro.highschoolsupport.entities.StatusDetail;
import team.hidro.highschoolsupport.service.UserService;

@Repository
public class CommentDaoImpl extends AutoWireJdbcDaoSupport implements CommentDao {
	@Autowired
	private UserService userService;

	@Override
	public List<CommentDetail> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommentDetail getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(CommentDetail item) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "insert into comment_stt VALUES (NULL,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, item.getStatusId());
			ps.setInt(2, item.getUserId());
			ps.setString(3, item.getContent());
			ps.setLong(4, item.getDateTime());
			return (ps.executeUpdate() > 0) ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(rs);
			DbUtils.closeQuietly(ps);
			DbUtils.closeQuietly(conn);
		}
		return false;
	}

	@Override
	public void remove(Integer id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "delete from comment_stt where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(rs);
			DbUtils.closeQuietly(ps);
			DbUtils.closeQuietly(conn);
		}

	}

	@Override
	public boolean update(CommentDetail item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<StatusDetail> setListCommentForStatus(List<StatusDetail> statusDetails) {
		for (StatusDetail statusDetail : statusDetails) {
			statusDetail.setCommentDetails(
					userService.setWriterForListComment(getListCommentByStatusId(statusDetail.getId())));
		}
		return statusDetails;
	}

	@Override
	public List<CommentDetail> getListCommentByStatusId(int statusId) {
		Connection conn = null;
		PreparedStatement smt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "Select * from comment_stt where stt_id = ?";
			smt = conn.prepareStatement(sql);
			smt.setInt(1, statusId);
			rs = smt.executeQuery();
			List<CommentDetail> commentDetails = new ArrayList<CommentDetail>();
			if (rs.next()) {
				String content = rs.getString("content");
				int userId = rs.getInt("user_id");
				long dateTime = rs.getLong("time");
				CommentDetail commentDetail = new CommentDetail(content, dateTime, userId);
				commentDetails.add(commentDetail);
			}

			return commentDetails;
		} catch (Exception e) {
			logger.error("queryPost", e);
		} finally {
			DbUtils.closeQuietly(rs);
			DbUtils.closeQuietly(smt);
			DbUtils.closeQuietly(conn);
		}
		return null;
	}

}
