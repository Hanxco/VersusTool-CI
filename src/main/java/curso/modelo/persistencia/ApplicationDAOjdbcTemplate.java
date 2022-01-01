package curso.modelo.persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import curso.modelo.entity.Application;
import curso.modelo.entity.Criteria;

@Repository(value="daoapplication")
public class ApplicationDAOjdbcTemplate implements ApplicationDAO {
	

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private ApplicationDAORowMapper applicationDaoRowMapper;
	
	@Override
	public void insert(Application app) {
		String query = "insert into application (name, type, description, link) values (?,?,?,?)";
				
		jdbcTemplate.update(query,
							app.getName(),
							app.getType(),
							app.getDescription(),
							app.getLink());
		
	}
	@Override
	public void modify(Application pelicula) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Integer pelicula) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Application searchById(Integer id) {
		String query = "select * from application where id ='" + id + "'";
		List<Application> lst = jdbcTemplate.query(query, applicationDaoRowMapper);
		Application retNew = null;
		if (!lst.isEmpty()) {
			retNew = lst.get(0);
		}
		return retNew;
	}
	
	@Override
	public List<Application> getAll() {
		String query = "select * from application";
		return jdbcTemplate.query(query, applicationDaoRowMapper); 
	}
	@Override
	public List<Application> searchByType(Integer type) {
		String query = "select * from application WHERE type = '" + type + "'";
		return jdbcTemplate.query(query, applicationDaoRowMapper); 
	}
}
