package team.hidro.highschoolsupport.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.dbutils.DbUtils;
import org.springframework.stereotype.Repository;

import team.hidro.highschoolsupport.dao.AutoWireJdbcDaoSupport;
import team.hidro.highschoolsupport.dao.UserDao;
import team.hidro.highschoolsupport.entities.UserDetail;

@Repository
public class UserDaoImpl extends AutoWireJdbcDaoSupport implements UserDao{

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


}
