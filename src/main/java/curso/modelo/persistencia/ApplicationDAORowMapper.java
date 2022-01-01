package curso.modelo.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import curso.modelo.entity.Application;
import curso.modelo.entity.Criteria;

@Component
public class ApplicationDAORowMapper implements RowMapper<Application> {
	
	@Override
	public Application mapRow(ResultSet rs, int rowNum) throws SQLException {
		Application app = new Application();
		app.setId(rs.getInt("id"));
		app.setName(rs.getString("name"));
		app.setDescription(rs.getString("description"));
		app.setType(rs.getInt("type"));
		app.setLink(rs.getString("link"));
		return app;
	}
}
