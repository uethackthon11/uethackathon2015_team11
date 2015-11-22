package team.hidro.highschoolsupport.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.springframework.stereotype.Repository;

import team.hidro.highschoolsupport.dao.AutoWireJdbcDaoSupport;
import team.hidro.highschoolsupport.dao.ParentDao;
import team.hidro.highschoolsupport.entities.ParentDetail;
import team.hidro.highschoolsupport.entities.StudentDetail;
@Repository
public class ParentDaoImpl extends AutoWireJdbcDaoSupport implements ParentDao {

	@Override
	public List<ParentDetail> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParentDetail getById(Integer id) {
		Connection conn = null;
		PreparedStatement smt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "Select parent.*, student.user_id, user.username from parent inner join student on parent.student_user_id = student.user_id inner join user on student.user_id = user.id where parent.user_id = ?";
			smt = conn.prepareStatement(sql);

			smt.setInt(1, id);

			rs = smt.executeQuery();
			if (rs.next()) {
				int id1 = rs.getInt("parent.user_id");
				String name = rs.getString("parent.name");
				String email = rs.getString("parent.email");
				int childId = rs.getInt("student.user_id");
				String childName = rs.getString("user.username");
				ParentDetail parent = new ParentDetail(id1, name, email, childId, childName);
				return parent;
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
	public boolean save(ParentDetail item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean update(ParentDetail item) {
		// TODO Auto-generated method stub
		return false;
	}

}
