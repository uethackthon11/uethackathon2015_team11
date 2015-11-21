package team.hidro.highschoolsupport.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import org.apache.commons.dbutils.DbUtils;
import org.springframework.stereotype.Repository;

import team.hidro.highschoolsupport.dao.AutoWireJdbcDaoSupport;
import team.hidro.highschoolsupport.dao.CommentProfileDao;

@Repository
public class CommentProfileDaoImpl extends AutoWireJdbcDaoSupport implements CommentProfileDao {

	@Override
	public boolean addComment(int teacherId, int studentId, String content) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "insert into comment_teacher value(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, null);
			ps.setInt(2, studentId);
			ps.setInt(3, teacherId);
			ps.setLong(4, (new Date()).getTime());
			ps.setString(5, content);
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
