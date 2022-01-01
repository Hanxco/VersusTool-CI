package curso.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import curso.modelo.entity.Pelicula;
import curso.modelo.persistencia.PeliculaDAO;

import java.util.List;

@Service
public class GestorPelicula {


	@Autowired
	private PeliculaDAO peliculaDao;

	public PeliculaDAO getPeliculaDao() {
		return peliculaDao;
	}

	public void setPeliculaDao(PeliculaDAO peliculaDao) {
		this.peliculaDao = peliculaDao;
	}
	
	public void modificarPelicula( Pelicula pelicula ) {
		this.peliculaDao.modificar(pelicula);
	}
	
	public List<Pelicula> getListaPeliculas(){
		System.out.println(peliculaDao.listarPeliculas());
		return peliculaDao.listarPeliculas();
	}
	
	public void insertar(Pelicula pelicula) throws Exception {
		// Validacion de campos
		// if("".equals(pelicula.getDirector())) { } 
		if(pelicula.getTitulo() != null && !pelicula.getDirector().equals("")) {
			this.peliculaDao.insertar(pelicula);			
		}else {
			throw new Exception("Fallo en el titulo");
		}
	}
	
	public void eliminar(Pelicula pelicula) {
		System.out.println("ELIMINAR GESTOR");
		System.out.println(pelicula);
		this.peliculaDao.borrar(pelicula.getId());
	}
	
	public Pelicula buscarPelicula( Integer id ) {
		return peliculaDao.buscar(id);
	}
	
}
