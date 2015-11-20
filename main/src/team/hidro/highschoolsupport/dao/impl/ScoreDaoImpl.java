package team.hidro.highschoolsupport.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.springframework.stereotype.Repository;

import team.hidro.highschoolsupport.dao.AutoWireJdbcDaoSupport;
import team.hidro.highschoolsupport.dao.ScoreDao;
import team.hidro.highschoolsupport.entities.ScoreDetail;
import team.hidro.highschoolsupport.entities.StudentDetail;
import team.hidro.highschoolsupport.entities.StudentScoreDetail;

@Repository
public class ScoreDaoImpl extends AutoWireJdbcDaoSupport implements ScoreDao{

	@Override
	public List<ScoreDetail> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScoreDetail getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(ScoreDetail item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ScoreDetail item) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<StudentScoreDetail> getListStudentScoreByListStudent(List<StudentDetail> students,int ky) {
		List<StudentScoreDetail> studentScoreDetails = new ArrayList<StudentScoreDetail>();
		for (StudentDetail studentDetail : students) {
			StudentScoreDetail studentScoreDetail = getStudentStoreDetailByStudent(studentDetail,ky);
			if(studentScoreDetail!=null) {
				studentScoreDetails.add(studentScoreDetail);
			}

		}
		return studentScoreDetails;
		
		
		
		
	}

	private StudentScoreDetail getStudentStoreDetailByStudent(StudentDetail studentDetail,int ky) {
		Connection conn = null;
		PreparedStatement smt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "Select * from score inner where user_id = ? and ky= ?";
			smt = conn.prepareStatement(sql);
			smt.setInt(1, studentDetail.getUserId());
			smt.setInt(2, ky);

			rs = smt.executeQuery();
			List<ScoreDetail> scoreDetails = new ArrayList<ScoreDetail>();
			while (rs.next()) {
				int score = rs.getInt("score");
				int type = rs.getInt("type");
				ScoreDetail scoreDetail = new ScoreDetail(score, type);
				scoreDetails.add(scoreDetail);
			}
			return new StudentScoreDetail(scoreDetails,studentDetail);
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
