package curso.modelo.persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import curso.modelo.entity.Pelicula;

@Repository(value="daopelicula")
public class PeliculaDAOjdbcTemplate implements PeliculaDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private PeliculaDAORowMapper peliculaRowMapper;
	
	@Override
	public void insertar(Pelicula pelicula) {
		String query = "insert into peliculas (TITULO, DIRECTOR, GENERO, YEAR) values (?,?,?,?)";
		
		jdbcTemplate.update(query,
							pelicula.getTitulo(), 
							pelicula.getDirector(), 
							pelicula.getGenero(), 
							pelicula.getYear());
	}

	@Override
	public void modificar(Pelicula pelicula) {
		String query = "update peliculas set TITULO=?,DIRECTOR=?,GENERO=?,YEAR=? where id=?";

		jdbcTemplate.update(query,
					pelicula.getTitulo(), 
					pelicula.getDirector(), 
					pelicula.getGenero(), 
					pelicula.getYear(),
					pelicula.getId());
	}

	@Override
	public void borrar(Integer id) {
		System.out.println("BORRANDO");
		System.out.println(id);
		String query = "delete from peliculas where id=?";

		jdbcTemplate.update(query,id);		
	}

	@Override
	public Pelicula buscar(Integer id) {
		String query = "select * from peliculas where id=?";

/*		BeanPropertyRowMapper<Pelicula> bean = new BeanPropertyRowMapper<>(); */
		return jdbcTemplate.queryForObject(query, peliculaRowMapper, id); 
	}

	@Override
	public List<Pelicula> listarPeliculas() {
		String query = "select * from peliculas";

/*		BeanPropertyRowMapper<Pelicula> bean = new BeanPropertyRowMapper<>(); */
		return jdbcTemplate.query(query, peliculaRowMapper); 
	}

}
