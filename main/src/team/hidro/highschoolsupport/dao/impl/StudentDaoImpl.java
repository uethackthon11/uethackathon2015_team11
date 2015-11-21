package team.hidro.highschoolsupport.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.springframework.stereotype.Repository;

import team.hidro.highschoolsupport.dao.AutoWireJdbcDaoSupport;
import team.hidro.highschoolsupport.dao.StudentDao;
import team.hidro.highschoolsupport.entities.ClassScoreStudent;
import team.hidro.highschoolsupport.entities.CommentProfile;
import team.hidro.highschoolsupport.entities.ScoreDetail;
import team.hidro.highschoolsupport.entities.StudentDetail;
import team.hidro.highschoolsupport.entities.SubjectScore;


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

	@Override
	public List<CommentProfile> getListCommentProfile(String username) {
		
		Connection conn = null;
		PreparedStatement smt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "select comment_teacher.*, teacher.name, teacher.avatar from comment_teacher inner join teacher on comment_teacher.teacher_user_id = teacher.user_id inner join user on comment_teacher.student_user_id = user.id  where user.username = ?";
			smt = conn.prepareStatement(sql);
			smt.setString(1, username);

			rs = smt.executeQuery();
			List<CommentProfile> commentProfiles = new ArrayList<CommentProfile>();
			while (rs.next()) {
				
				String name = rs.getString("teacher.name");
				String avatar = rs.getString("teacher.avatar");
				String content = rs.getString("comment_teacher.content");
				Long time = rs.getLong("comment_teacher.time");
				
				CommentProfile commentProfile = new CommentProfile(name, content, time, avatar);
				commentProfiles.add(commentProfile);
			}
			return commentProfiles;
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
	public List<SubjectScore> getListSubjectScore(String username) {
		
		Connection conn = null;
		PreparedStatement smt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "select score.*, subject.name from score inner join user on score.user_id = user.id inner join class_student on score.user_id = class_student.student_user_id inner join subject_year_class on class_student.class_id = subject_year_class.class_id inner join subject on subject_year_class.subject_year_id = subject.id  where class_student.year = ? and user.username = ?";
			smt = conn.prepareStatement(sql);
			smt.setInt(1, (new Date()).getYear());
			smt.setString(2, username);

			rs = smt.executeQuery();
			ArrayList<ClassScoreStudent> subjectScores = new ArrayList<ClassScoreStudent>();
			while (rs.next()) {
				
				String name = rs.getString("subject.name");
				int type = rs.getInt("score.type");
				float score = rs.getFloat("score.score");
				int ky = rs.getInt("ky");
				int id = rs.getInt("score.id");
				int userId = rs.getInt("score.user_id");
				int subjectYearId = rs.getInt("subject_uear_id");
				ScoreDetail scoreDetail = new ScoreDetail(id, score, type, userId, subjectYearId, ky);
				subjectScores.add(new ClassScoreStudent(scoreDetail, name));
			}
			return new SubjectScore(name, subjectScores);
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

}
