package curso.modelo.persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import curso.modelo.entity.Criteria;

@Repository(value="daocriteria")
public class CriteriaDAOjdbcTemplate implements CriteriaDAO {
	

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private CriteriaDAORowMapper criteriaRowMapper;

	@Override
	public void insert(Criteria criteria) {
		String query = "insert into criteria (name, appId, category, subcategory, key) values (?,?,?,?)";
		
		jdbcTemplate.update(query,
							criteria.getName(),
							criteria.getAppId(),
							criteria.getCategory(),
							criteria.getSubcategory(),
							criteria.getKey());
	}

	@Override
	public void modify(Criteria criteria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer criteria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Criteria searchById(Integer id) {
		String query = "select * from criteria where id=?";
		return jdbcTemplate.queryForObject(query, criteriaRowMapper, id); 
	}

	@Override
	public List<Criteria> getAll() {
		String query = "select * from criteria";
		return jdbcTemplate.query(query, criteriaRowMapper); 
	}

}
