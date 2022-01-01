package curso.modelo.persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import curso.modelo.entity.AppDetail;
import curso.modelo.entity.Application;
import curso.modelo.entity.Criteria;
import curso.modelo.entity.ToolTypes;

@Repository(value="daotooltype")
public class ToolTypesDAOjdbcTemplate implements ToolTypesDAO {
	

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ToolTypesDAORowMapper toolTypesDaoRowMapper;

	@Override
	public void insert(AppDetail app) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(AppDetail app) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer appId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ToolTypes searchById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ToolTypes> getAllToolTypes() {
		String query = "select * from tooltypes";
		return jdbcTemplate.query(query, toolTypesDaoRowMapper); 
	}
	
	

}
