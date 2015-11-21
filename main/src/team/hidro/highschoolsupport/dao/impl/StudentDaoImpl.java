package team.hidro.highschoolsupport.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.springframework.stereotype.Repository;

import team.hidro.highschoolsupport.dao.AutoWireJdbcDaoSupport;
import team.hidro.highschoolsupport.dao.StudentDao;
import team.hidro.highschoolsupport.entities.StudentDetail;


@Repository
public class StudentDaoImpl extends AutoWireJdbcDaoSupport implements StudentDao{

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
	public StudentDetail getByName(String usernme) {
		
		Connection conn = null;
		PreparedStatement smt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "Select * from student inner join user on student.user_id = user.id where user.username = ?";
			smt = conn.prepareStatement(sql);

			smt.setString(1, usernme);
			
			rs = smt.executeQuery();
			if (rs.next()) {
				int id1 = rs.getInt("id");
				String name = rs.getString("name");
				String birthday = rs.getString("birthday");
				String avatar = rs.getString("avartar");
				String address = rs.getString("address");
				String introduce = rs.getString("introduce");
				int sex = rs.getInt("sex");
				int classId = rs.getInt("class_id");
				StudentDetail studentDetail = new StudentDetail(id1, name, birthday, avatar, sex, address, introduce, classId);
				return studentDetail;
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
	public List<StudentDetail> getListStudentByClassId(int id) {
		Connection conn = null;
		PreparedStatement smt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "Select student.* from student inner join class_student on student.user_id = class_student.student_user_id "
					+ "where class_student.class_id = ?";
			smt = conn.prepareStatement(sql);
			smt.setInt(1, id);

			rs = smt.executeQuery();
			List<StudentDetail> studentDetails = new ArrayList<StudentDetail>();
			while (rs.next()) {
				int studentId = rs.getInt("user_id");
				String studentName = rs.getString("name");
				String studentBirthday = rs.getString("birthday");
				String studentAvartar = rs.getString("avartar");
				int studentSex = rs.getInt("sex");
				String studentAddress = rs.getString("address");
				int studentClassId = rs.getInt("class_id");
				String studentIntroduce = rs.getString("introduce");
				StudentDetail studentDetail = new StudentDetail(studentId, studentName, studentBirthday, studentAvartar,
						studentSex, studentAddress, studentIntroduce, studentClassId);
				studentDetails.add(studentDetail);
			}
			return studentDetails;
		} catch (Exception e) {
			// logger.error("queryPost", e);
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(rs);
			DbUtils.closeQuietly(smt);
			DbUtils.closeQuietly(conn);
		}
		return null;
	}

	@Override
	public boolean update(StudentDetail item) {
		// TODO Auto-generated method stub
		return false;
	}

}
