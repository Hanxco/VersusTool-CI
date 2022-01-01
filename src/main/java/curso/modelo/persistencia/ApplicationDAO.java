package curso.modelo.persistencia;

import java.util.List;

import curso.modelo.entity.Application;

public interface ApplicationDAO {

	void insert(Application pelicula);
	void modify(Application pelicula);
	void delete(Integer pelicula);
	Application searchById(Integer id);
	List<Application> searchByType(Integer type);
	List<Application> getAll();
}



