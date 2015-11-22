package team.hidro.highschoolsupport.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.springframework.stereotype.Repository;

import team.hidro.highschoolsupport.dao.AutoWireJdbcDaoSupport;
import team.hidro.highschoolsupport.dao.UserDao;
import team.hidro.highschoolsupport.entities.CommentDetail;
import team.hidro.highschoolsupport.entities.GroupDetail;
import team.hidro.highschoolsupport.entities.StatusDetail;
import team.hidro.highschoolsupport.entities.UserDetail;
import team.hidro.highschoolsupport.entities.WriterDetail;

@Repository
public class UserDaoImpl extends AutoWireJdbcDaoSupport implements UserDao {

	@Override
	public UserDetail checkUser(String username, String password) {

		Connection conn = null;
		PreparedStatement smt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "select * from user where username = ? and password = ?";
			smt = conn.prepareStatement(sql);
			smt.setString(1, username);
			smt.setString(2, password);

			rs = smt.executeQuery();
			if (rs.next()) {

				int _id = rs.getInt("id");
				String _username = rs.getString("username");
				String _password = rs.getString("password");
				int _role = rs.getInt("role");

				return new UserDetail(_id, _username, _password, _role);

			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(rs);
			DbUtils.closeQuietly(smt);
			DbUtils.closeQuietly(conn);
		}
		return null;
	}

	@SuppressWarnings("resource")
	@Override
	public List<StatusDetail> setWriterForListStatus(List<StatusDetail> statusDetails) {
		Connection conn = null;
		PreparedStatement smt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			for (StatusDetail statusDetail : statusDetails) {
				int userId = statusDetail.getUserId();

				String sql = "Select * from user where id = ?";
				smt = conn.prepareStatement(sql);
				smt.setInt(1, userId);
				rs = smt.executeQuery();
				if (rs.next()) {
					int role = rs.getInt("role");
					WriterDetail writerDetail = null;
					if (role == 1) {
						sql = "Select * from student where user_id = ?";
						smt = conn.prepareStatement(sql);
						smt.setInt(1, userId);
						rs = smt.executeQuery();

						if (rs.next()) {
							String name = rs.getString("name");
							String avatar = rs.getString("avartar");
							writerDetail = new WriterDetail(name, userId, avatar);
						}

					} else {

						sql = "Select * from teacher where user_id = ?";
						smt = conn.prepareStatement(sql);
						smt.setInt(1, userId);
						rs = smt.executeQuery();

						if (rs.next()) {
							String name = rs.getString("name");
							String avatar = rs.getString("avatar");
							writerDetail = new WriterDetail(name, userId, avatar);
						}

					}
					statusDetail.setWriterDetail(writerDetail);
				}

			}
			return statusDetails;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(rs);
			DbUtils.closeQuietly(smt);
			DbUtils.closeQuietly(conn);
		}
		return null;
	}

	@SuppressWarnings("resource")
	@Override
	public List<CommentDetail> setWriterForListComment(List<CommentDetail> commentDetails) {
		Connection conn = null;
		PreparedStatement smt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			for (CommentDetail commentDetail : commentDetails) {
				int userId = commentDetail.getUserId();

				String sql = "Select * from user where id = ?";
				smt = conn.prepareStatement(sql);
				smt.setInt(1, userId);
				rs = smt.executeQuery();
				if (rs.next()) {
					int role = rs.getInt("role");
					WriterDetail writerDetail = null;
					if (role == 1) {
						sql = "Select * from student where user_id = ?";
						smt = conn.prepareStatement(sql);
						smt.setInt(1, userId);
						rs = smt.executeQuery();

						if (rs.next()) {
							String name = rs.getString("name");
							String avatar = rs.getString("avartar");
							writerDetail = new WriterDetail(name, userId, avatar);
						}

					} else {

						sql = "Select * from teacher where user_id = ?";
						smt = conn.prepareStatement(sql);
						smt.setInt(1, userId);
						rs = smt.executeQuery();

						if (rs.next()) {
							String name = rs.getString("name");
							String avatar = rs.getString("avatar");
							writerDetail = new WriterDetail(name, userId, avatar);
						}

					}
					commentDetail.setWriterDetail(writerDetail);
				}
			}

			return commentDetails;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(rs);
			DbUtils.closeQuietly(smt);
			DbUtils.closeQuietly(conn);
		}
		return null;
	}

	@SuppressWarnings("resource")
	@Override
	public StatusDetail setWriterForStatus(StatusDetail statusDetail) {
		Connection conn = null;
		PreparedStatement smt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			int userId = statusDetail.getUserId();

			String sql = "Select * from user where id = ?";
			smt = conn.prepareStatement(sql);
			smt.setInt(1, userId);
			rs = smt.executeQuery();
			if (rs.next()) {
				int role = rs.getInt("role");
				WriterDetail writerDetail = null;
				if (role == 1) {
					sql = "Select * from student where user_id = ?";
					smt = conn.prepareStatement(sql);
					smt.setInt(1, userId);
					rs = smt.executeQuery();

					if (rs.next()) {
						String name = rs.getString("name");
						String avatar = rs.getString("avartar");
						writerDetail = new WriterDetail(name, userId, avatar);
					}

				} else {

					sql = "Select * from teacher where user_id = ?";
					smt = conn.prepareStatement(sql);
					smt.setInt(1, userId);
					rs = smt.executeQuery();

					if (rs.next()) {
						String name = rs.getString("name");
						String avatar = rs.getString("avartar");
						writerDetail = new WriterDetail(name, userId, avatar);
					}

				}
				statusDetail.setWriterDetail(writerDetail);
			}

			return statusDetail;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(rs);
			DbUtils.closeQuietly(smt);
			DbUtils.closeQuietly(conn);
		}
		return null;
	}

	@Override
	public List<GroupDetail> getListGroupByUserId(int id) {
		Connection conn = null;
		PreparedStatement smt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "Select * from group_user inner join group on group_user.group_id=group.id where user_id = ?";
			smt = conn.prepareStatement(sql);
			smt.setInt(1, id);
			rs = smt.executeQuery();
			List<GroupDetail> groupDetails = new ArrayList<GroupDetail>();
			if (rs.next()) {
				String name = rs.getString("group.name");
				groupDetails.add(new GroupDetail(id, name));
			}
			return groupDetails;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(rs);
			DbUtils.closeQuietly(smt);
			DbUtils.closeQuietly(conn);
		}
		return null;
	}

}
