package team.hidro.highschoolsupport.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.springframework.stereotype.Repository;

import team.hidro.highschoolsupport.dao.AutoWireJdbcDaoSupport;
import team.hidro.highschoolsupport.dao.StatusDao;
import team.hidro.highschoolsupport.entities.StatusDetail;

@Repository
public class StatusDaoImpl extends AutoWireJdbcDaoSupport implements StatusDao {

	@Override
	public List<StatusDetail> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusDetail getById(Integer id) {
		Connection conn = null;
		PreparedStatement smt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "Select * from stt where id = ?";
			smt = conn.prepareStatement(sql);

			smt.setInt(1, id);
			rs = smt.executeQuery();
			if (rs.next()) {
				int id1 = rs.getInt("id");
				int groupId = rs.getInt("group_id");
				int userId = rs.getInt("user_id");
				String content = rs.getString("content");
				long dateTime = rs.getLong("time");
				StatusDetail statusDetail = new StatusDetail(id1, groupId, userId, content, dateTime, null, null);
				return statusDetail;
			}
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
	public boolean save(StatusDetail item) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "insert into stt VALUES (NULL,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, item.getUserId());
			ps.setInt(2, item.getGroupId());
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
			String sql = "delete from stt where id = ?";
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
	public boolean update(StatusDetail item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<StatusDetail> getListStatusByGroupId(int groupId) {

		Connection conn = null;
		PreparedStatement smt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "Select * from stt  where group_id = ?";
			smt = conn.prepareStatement(sql);

			smt.setInt(1, groupId);

			rs = smt.executeQuery();
			List<StatusDetail> statusDetails = new ArrayList<StatusDetail>();
			if (rs.next()) {
				int id1 = rs.getInt("id");
				int userId = rs.getInt("user_id");
				long time = rs.getLong("time");
				String content = rs.getString("content");
				statusDetails.add(new StatusDetail(id1, userId, content, time));
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

}
