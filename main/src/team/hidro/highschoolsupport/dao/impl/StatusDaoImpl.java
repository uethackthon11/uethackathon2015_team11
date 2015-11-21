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
import team.hidro.highschoolsupport.entities.InitialStatusDetail;
import team.hidro.highschoolsupport.entities.StatusDetail;

@Repository
public class StatusDaoImpl extends AutoWireJdbcDaoSupport implements StatusDao {

	@Override
	public List<StatusDetail> getList() {
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
				int enable = rs.getInt("enable");
				int type = rs.getInt("type");
				String title = rs.getString("title");
				StatusDetail statusDetail = new StatusDetail(id1, groupId, userId, content, dateTime, null, null,
						enable, type, title);
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
			String sql = "insert into stt VALUES (NULL,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, item.getUserId());
			ps.setInt(2, item.getGroupId());
			ps.setString(3, item.getContent());
			ps.setInt(4, item.getEnable());
			ps.setLong(5, item.getDateTime());
			ps.setInt(6, item.getType());
			ps.setString(7, item.getTitle());
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
				String title = rs.getString("title");
				statusDetails.add(new StatusDetail(id1, userId, content, title, time));
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
	public InitialStatusDetail getListInitialStatusByGroupId(int groupId) {
		Connection conn = null;
		PreparedStatement smt = null;
		ResultSet rs = null;
		try {

			conn = dataSource.getConnection();
			String sql = "Select * from stt  where group_id = ? and type= ? ORDER BY time DESC LIMIT 3";

			List<StatusDetail> thongBaos = new ArrayList<StatusDetail>();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, groupId);
			smt.setInt(2, 1);
			rs = smt.executeQuery();
			while (rs.next()) {
				int id1 = rs.getInt("id");
				int userId = rs.getInt("user_id");
				long time = rs.getLong("time");
				String content = rs.getString("content");
				String title = rs.getString("title");
				thongBaos.add(new StatusDetail(id1, userId, content, title, time));
			}

			List<StatusDetail> hoiDaps = new ArrayList<StatusDetail>();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, groupId);
			smt.setInt(2, 2);
			rs = smt.executeQuery();
			while (rs.next()) {
				int id1 = rs.getInt("id");
				int userId = rs.getInt("user_id");
				long time = rs.getLong("time");
				String content = rs.getString("content");
				String title = rs.getString("title");
				hoiDaps.add(new StatusDetail(id1, userId, content, title, time));
			}

			List<StatusDetail> taiLieus = new ArrayList<StatusDetail>();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, groupId);
			smt.setInt(2, 3);
			rs = smt.executeQuery();
			while (rs.next()) {
				int id1 = rs.getInt("id");
				int userId = rs.getInt("user_id");
				long time = rs.getLong("time");
				String content = rs.getString("content");
				String title = rs.getString("title");
				taiLieus.add(new StatusDetail(id1, userId, content, title, time));
			}
			return new InitialStatusDetail(thongBaos, hoiDaps, taiLieus);
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
	public List<StatusDetail> getListStatusByGroupIdType1(int groupId) {
		Connection conn = null;
		PreparedStatement smt = null;
		ResultSet rs = null;
		try {

			conn = dataSource.getConnection();
			String sql = "Select * from stt  where group_id = ? and type= ? ORDER BY time DESC";

			List<StatusDetail> thongBaos = new ArrayList<StatusDetail>();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, groupId);
			smt.setInt(2, 1);
			rs = smt.executeQuery();
			while (rs.next()) {
				int id1 = rs.getInt("id");
				int userId = rs.getInt("user_id");
				long time = rs.getLong("time");
				String content = rs.getString("content");
				String title = rs.getString("title");
				thongBaos.add(new StatusDetail(id1, userId, content, title, time));
			}

			return thongBaos;
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
	public List<StatusDetail> getListStatusByGroupIdType2(int groupId) {
		Connection conn = null;
		PreparedStatement smt = null;
		ResultSet rs = null;
		try {

			conn = dataSource.getConnection();
			String sql = "Select * from stt  where group_id = ? and type= ? ORDER BY time DESC";

			List<StatusDetail> hoiDaps = new ArrayList<StatusDetail>();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, groupId);
			smt.setInt(2, 2);
			rs = smt.executeQuery();
			while (rs.next()) {
				int id1 = rs.getInt("id");
				int userId = rs.getInt("user_id");
				long time = rs.getLong("time");
				String content = rs.getString("content");
				String title = rs.getString("title");
				hoiDaps.add(new StatusDetail(id1, userId, content, title, time));
			}

			return hoiDaps;
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
	public List<StatusDetail> getListStatusByGroupIdType3(int groupId) {
		Connection conn = null;
		PreparedStatement smt = null;
		ResultSet rs = null;
		try {

			conn = dataSource.getConnection();
			String sql = "Select * from stt  where group_id = ? and type= ? ORDER BY time DESC";

			List<StatusDetail> taiLieus = new ArrayList<StatusDetail>();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, groupId);
			smt.setInt(2, 3);
			rs = smt.executeQuery();
			while (rs.next()) {
				int id1 = rs.getInt("id");
				int userId = rs.getInt("user_id");
				long time = rs.getLong("time");
				String content = rs.getString("content");
				String title = rs.getString("title");
				taiLieus.add(new StatusDetail(id1, userId, content, title, time));
			}

			return taiLieus;
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
