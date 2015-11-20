package team.hidro.highschoolsupport.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import team.hidro.highschoolsupport.dao.AutoWireJdbcDaoSupport;
import team.hidro.highschoolsupport.dao.TeacherDao;
import team.hidro.highschoolsupport.entities.ClassDetail;
import team.hidro.highschoolsupport.entities.ListClassDetail;
import team.hidro.highschoolsupport.entities.TeacherDetail;

public class TeacherDaoImpl extends AutoWireJdbcDaoSupport implements TeacherDao {

	@Override
	public List<TeacherDetail> getList() {
		return null;
	}

	@Override
	public TeacherDetail getById(Integer id) {
		return null;
	}

	@Override
	public boolean save(TeacherDetail item) {
		return false;
	}

	@Override
	public void remove(Integer id) {

	}

	@Override
	public void update(TeacherDetail item) {

	}

	@Override
	public List<ListClassDetail> getListClassByTeacherId(int id) {
		Connection conn = null;
		PreparedStatement smt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "Select * from subject_year inner join subject on subject_year.subject_id = subject.id"
					+ "inner join subject_year_class syc on subject_year.id = syc.subject_year_id"
					+ "inner join class on class.id = syc.class_id"
					+ " where subject_year.year = ? and subject_year.teacher_user_id = ?";
			smt = conn.prepareStatement(sql);
			int year = getCurrentYear();
			smt.setInt(1, year);
			smt.setInt(2, id);

			rs = smt.executeQuery();
			List<ListClassDetail> listClassDetails = new ArrayList<ListClassDetail>();
			while (rs.next()) {
				int subjectId = rs.getInt("subject.id");
				String subjectName = rs.getString("subject.name");
				int classId = rs.getInt("class.id");
				String className = rs.getString("class.name");
				ClassDetail classDetail = new ClassDetail(classId, className);
				ListClassDetail listClassDetail = new ListClassDetail(subjectId, subjectName, classDetail);
				listClassDetails.add(listClassDetail);
			}
			return listClassDetails;
		} catch (Exception e) {
			logger.error("queryPost", e);
		} finally {
			DbUtils.closeQuietly(rs);
			DbUtils.closeQuietly(smt);
			DbUtils.closeQuietly(conn);
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	private int getCurrentYear() {
		Date a = new Date();
		return a.getYear();
	}

}
