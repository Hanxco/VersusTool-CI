package curso.modelo.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import curso.modelo.entity.Pelicula;

@Component
public class PeliculaDAORowMapper implements RowMapper<Pelicula> {

	@Override
	public Pelicula mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pelicula p = new Pelicula();
		p.setId(rs.getInt("ID"));
		p.setDirector(rs.getString("DIRECTOR"));
		p.setGenero(rs.getString("GENERO"));
		p.setTitulo(rs.getString("TITULO"));
		p.setYear(rs.getInt("YEAR"));
		return p;
	}
	
	
}
