package curso.modelo.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import curso.modelo.entity.Criteria;

@Component
public class CriteriaDAORowMapper implements RowMapper<Criteria> {
	
	@Override
	public Criteria mapRow(ResultSet rs, int rowNum) throws SQLException {
		Criteria p = new Criteria();
		p.setId(rs.getInt("id"));
		p.setAppId(rs.getInt("appId"));
		p.setCategory(rs.getString("category"));
		p.setSubcategory(rs.getString("subcategory"));
		p.setKey(rs.getString("key"));
		p.setName(rs.getString("name"));
		return p;
	}
}
