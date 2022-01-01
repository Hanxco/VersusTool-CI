package curso.modelo.persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import curso.modelo.entity.AppDetail;
import curso.modelo.entity.Application;
import curso.modelo.entity.Criteria;

@Repository(value="daoappdetail")
public class AppDetailDAOjdbcTemplate implements AppDetailDAO {
	

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private AppDetailDAORowMapper appDetailDaoRowMapper;
	
	@Override
	public void insert(AppDetail app) {
		String query = "insert into appdetail (appId, comments, criteriaId, description) values (?,?,?,?)";
				
		jdbcTemplate.update(query,
							app.getAppId(),
							app.getComments(),
							app.getCriteriaId(),
							app.getDescription());
	}
	
	@Override
	public void modify(AppDetail app) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Integer app) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public AppDetail searchById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<AppDetail> getAllByAppId(Integer appId) {
		String query = "select * from appdetail WHERE appId = '" + appId + "'";
		return jdbcTemplate.query(query, appDetailDaoRowMapper); 
	}


}
