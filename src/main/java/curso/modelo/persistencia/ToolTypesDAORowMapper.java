package curso.modelo.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import curso.modelo.entity.AppDetail;
import curso.modelo.entity.Application;
import curso.modelo.entity.Criteria;
import curso.modelo.entity.ToolTypes;

@Component
public class ToolTypesDAORowMapper implements RowMapper<ToolTypes> {
	
	@Override
	public ToolTypes mapRow(ResultSet rs, int rowNum) throws SQLException {
		ToolTypes tool = new ToolTypes();
		tool.setDeveloperName(rs.getString("developername"));
		tool.setId(rs.getInt("id"));
		tool.setLabel(rs.getString("label"));
		return tool;
	}
}
