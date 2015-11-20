package team.hidro.highschoolsupport.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import team.hidro.highschoolsupport.dao.AutoWireJdbcDaoSupport;
import team.hidro.highschoolsupport.dao.PostDaoImpl;
import team.hidro.highschoolsupport.dao.StudentDao;
import team.hidro.highschoolsupport.entities.StudentDetail;


@Repository
public class StudentDaoImpl extends AutoWireJdbcDaoSupport implements StudentDao{
	static Logger logger = Logger.getLogger(PostDaoImpl.class);

	@Override
	public List<StudentDetail> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentDetail getById(Integer id) {
		
		
		Connection conn = null;
		PreparedStatement smt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "Select * from student where id = ?";
			smt = conn.prepareStatement(sql);

			smt.setInt(1, id);
			
			rs = smt.executeQuery();
			if (rs.next()) {
				int id1 = rs.getInt("id");
				String name = rs.getString("name");
				String birthday = rs.getString("birthday");
				String avatar = rs.getString("avatar");
				String address = rs.getString("address");
				String introduce = rs.getString("introduce");
				int sex = rs.getInt("sex");
				int classId = rs.getInt("class_id");
				StudentDetail studentDetail = new StudentDetail(id1, name, birthday, avatar, sex, address, introduce, classId);
				return studentDetail;
			}
		} catch (Exception e) {
			logger.error("queryPost",e);
		} finally {
			DbUtils.closeQuietly(rs);
			DbUtils.closeQuietly(smt);
			DbUtils.closeQuietly(conn);
		}
		return null;
	}

	@Override
	public boolean save(StudentDetail item) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "insert into post value(?,?,?,?,?,?,?,?,?)";
			return (ps.executeUpdate() > 0) ? true : false;

		} catch (Exception e) {
			logger.error("addPost",e);
		} finally {
			DbUtils.closeQuietly(rs);
			DbUtils.closeQuietly(ps);
			DbUtils.closeQuietly(conn);
		}
		return false;
	}

	@Override
	public void remove(Integer id) {
		
	}

	@Override
	public void update(StudentDetail item) {
		
		
	}

}
