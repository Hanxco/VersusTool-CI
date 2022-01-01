package curso.modelo.persistencia;

import java.util.List;

import curso.modelo.entity.Pelicula;

public interface PeliculaDAO {
	
	void insertar(Pelicula pelicula);
	void modificar(Pelicula pelicula);
	void borrar(Integer pelicula);
	Pelicula buscar(Integer id);
	List<Pelicula> listarPeliculas();
	
}
