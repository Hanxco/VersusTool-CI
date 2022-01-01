package curso.modelo.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import curso.modelo.entity.AppDetail;
import curso.modelo.entity.Application;
import curso.modelo.entity.Criteria;

@Component
public class AppDetailDAORowMapper implements RowMapper<AppDetail> {
	
	@Override
	public AppDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		AppDetail appDetail = new AppDetail();
		appDetail.setId(rs.getInt("id"));
		appDetail.setAppId(rs.getInt("appId"));
		appDetail.setComments(rs.getString("comments"));
		appDetail.setCriteriaId(rs.getInt("criteriaId"));
		appDetail.setDescription(rs.getString("description"));
		return appDetail;
	}
}
