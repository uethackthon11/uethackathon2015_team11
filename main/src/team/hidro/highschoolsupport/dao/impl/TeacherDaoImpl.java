package team.hidro.highschoolsupport.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.springframework.stereotype.Repository;

import team.hidro.highschoolsupport.dao.AutoWireJdbcDaoSupport;
import team.hidro.highschoolsupport.dao.TeacherDao;
import team.hidro.highschoolsupport.entities.ClassDetail;
import team.hidro.highschoolsupport.entities.ListClassDetail;
import team.hidro.highschoolsupport.entities.TeacherDetail;

@Repository
public class TeacherDaoImpl extends AutoWireJdbcDaoSupport implements TeacherDao {

	@Override
	public List<TeacherDetail> getList() {
		return null;
	}

	@Override
	public TeacherDetail getById(Integer id) {
		Connection conn = null;
		PreparedStatement smt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "select * from teacher where user_id = ?";
			smt = conn.prepareStatement(sql);
			smt.setInt(1, id);

			rs = smt.executeQuery();
			if (rs.next()) {
				int _id = rs.getInt("user_id");
				String name = rs.getString("name");
				String detail = rs.getString("details");
				String avatar = rs.getString("avatar");
				
				return new TeacherDetail(_id, name, detail, avatar);
			}
			return null;
		} catch (Exception e) {
//			logger.error("queryPost", e);
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(rs);
			DbUtils.closeQuietly(smt);
			DbUtils.closeQuietly(conn);
		}
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
	public List<ListClassDetail> getListClassByTeacherId(int id) {
		Connection conn = null;
		PreparedStatement smt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "Select * from subject_year inner join subject on subject_year.subject_id = subject.id "
					+ "inner join subject_year_class syc on subject_year.id = syc.subject_year_id "
					+ "inner join class on class.id = syc.class_id"
					+ " where subject_year.year = ? and subject_year.teacher_user_id = ?";
			smt = conn.prepareStatement(sql);
			int year = Calendar.getInstance().get(Calendar.YEAR);
			smt.setInt(1, year);
			smt.setInt(2, id);

			rs = smt.executeQuery();
			List<ListClassDetail> listClassDetails = new ArrayList<ListClassDetail>();
			int i=0;
			System.out.println(year+" "+id);
			while (rs.next()) {
				System.out.println(i++);
				int subjectId = rs.getInt("subject_year.id");
				String subjectName = rs.getString("subject.name");
				int classId = rs.getInt("class.id");
				String className = rs.getString("class.name");
				ClassDetail classDetail = new ClassDetail(classId, className);
				ListClassDetail listClassDetail = new ListClassDetail(subjectId, subjectName, classDetail);
				listClassDetails.add(listClassDetail);
			}
			return listClassDetails;
		} catch (Exception e) {
//			logger.error("queryPost", e);
			e.printStackTrace();
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

	@Override
	public TeacherDetail getByName(String usernme) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(TeacherDetail item) {
		// TODO Auto-generated method stub
		return false;
	}

}