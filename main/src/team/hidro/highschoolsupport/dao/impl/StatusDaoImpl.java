package team.hidro.highschoolsupport.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.springframework.stereotype.Repository;

import team.hidro.highschoolsupport.dao.AutoWireJdbcDaoSupport;
import team.hidro.highschoolsupport.dao.StatusDao;
import team.hidro.highschoolsupport.entities.StatusDetail;

@Repository
public class StatusDaoImpl extends AutoWireJdbcDaoSupport implements StatusDao{

	@Override
	public List<StatusDetail> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusDetail getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(StatusDetail item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean update(StatusDetail item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<StatusDetail> getListStatusByGroupId(int groupId) {
		
		Connection conn = null;
		PreparedStatement smt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "Select * from status  where group_id = ?";
			smt = conn.prepareStatement(sql);

			smt.setInt(1, groupId);
			
			rs = smt.executeQuery();
			List<StatusDetail> statusDetails = new ArrayList<StatusDetail>();
			if (rs.next()) {
				String id1 = rs.getString("post.id");
				String pageid = rs.getString("page_id");
				
			}
			return statusDetails;
		} catch (Exception e) {
			logger.error("queryPost",e);
		} finally {
			DbUtils.closeQuietly(rs);
			DbUtils.closeQuietly(smt);
			DbUtils.closeQuietly(conn);
		}
		return null;
	}

}
