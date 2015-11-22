package team.hidro.highschoolsupport.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.springframework.stereotype.Repository;

import team.hidro.highschoolsupport.dao.AutoWireJdbcDaoSupport;
import team.hidro.highschoolsupport.dao.ClassDao;
import team.hidro.highschoolsupport.entities.ClassDetail;

@Repository
public class ClassDaoImpl extends AutoWireJdbcDaoSupport implements ClassDao {

	@Override
	public List<ClassDetail> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClassDetail getById(Integer id) {
		Connection conn = null;
		PreparedStatement smt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "Select * from class where id = ?";
			smt = conn.prepareStatement(sql);

			smt.setInt(1, id);

			rs = smt.executeQuery();
			if (rs.next()) {
				int id1 = rs.getInt("id");
				String name = rs.getString("name");
				ClassDetail classDetail = new ClassDetail(id1, name);
				return classDetail;
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
	public boolean save(ClassDetail item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean update(ClassDetail item) {
		// TODO Auto-generated method stub
		return false;
	}

}
