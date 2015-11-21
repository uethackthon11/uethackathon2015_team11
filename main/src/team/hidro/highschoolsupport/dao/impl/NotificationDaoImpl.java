package team.hidro.highschoolsupport.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.springframework.stereotype.Repository;

import team.hidro.highschoolsupport.dao.AutoWireJdbcDaoSupport;
import team.hidro.highschoolsupport.dao.NotificationDao;
import team.hidro.highschoolsupport.entities.Notification;

@Repository
public class NotificationDaoImpl extends AutoWireJdbcDaoSupport implements NotificationDao {

	@Override
	public List<Notification> getAllNotification(int id) {
		Connection conn = null;
		PreparedStatement smt = null;
		PreparedStatement smt1 = null;
		PreparedStatement smt2 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		List<Notification> notifications = new ArrayList<Notification>();
		try {
			conn = dataSource.getConnection();
			String sql = "select * from notification where reciever_id = ?";
			smt = conn.prepareStatement(sql);
			smt.setInt(1, id);
			rs = smt.executeQuery();
			while(rs.next()){
				String senderName = "";
				String recieverName = "bạn";
				int _id = rs.getInt("id");
				int sender_id = rs.getInt("sender_id");
				int reciever_id = rs.getInt("reciever_id");
				long time = rs.getLong("time");
				String message = rs.getString("message");
				int status = rs.getInt("status");
				int type = rs.getInt("type");
				String sql1 = "Select * from user where id = ?";
				smt1 = conn.prepareStatement(sql1);
				smt1.setInt(1, id);
				rs1 = smt1.executeQuery();
				if (rs1.next()) {
					int role = rs1.getInt("role");
					if (role == 1) {
						
						int senderId = rs.getInt("sender_id");
						
						sql = "Select * from teacher where user_id = ?";
						smt2 = conn.prepareStatement(sql);
						smt2.setInt(1, senderId);
						rs2 = smt2.executeQuery();
						if (rs2.next()) {
							senderName = rs2.getString("name");
						}

					} else {
						
						int senderId = rs.getInt("sender_id");
						
						sql = "Select * from student where user_id = ?";
						smt2 = conn.prepareStatement(sql);
						smt2.setInt(1, senderId);
						rs2 = smt2.executeQuery();

						if (rs2.next()) {
							senderName = rs2.getString("name");
						}

					}
				}
				
				notifications.add(new Notification(_id, sender_id, senderName, reciever_id, recieverName, time, message, status, type));
				
			}
			return notifications;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(rs);
			DbUtils.closeQuietly(rs1);
			DbUtils.closeQuietly(rs2);
			DbUtils.closeQuietly(smt);
			DbUtils.closeQuietly(smt1);
			DbUtils.closeQuietly(smt2);
			DbUtils.closeQuietly(conn);
		}
		return null;

	}

	@Override
	public boolean updateNotificationStatus(int id, int status) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addNotification(Notification notification) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "insert into notification value(?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, null);
			ps.setInt(2, notification.getSender_id());
			ps.setInt(3, notification.getReciever());
			ps.setLong(4, notification.getTime());
			ps.setString(5, notification.getMessage());
			ps.setInt(6, notification.getStatus());
			ps.setInt(7, notification.getType());
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

}
