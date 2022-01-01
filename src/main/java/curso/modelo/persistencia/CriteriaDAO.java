package curso.modelo.persistencia;

import java.util.List;

import curso.modelo.entity.Criteria;

public interface CriteriaDAO {

	void insert(Criteria pelicula);
	void modify(Criteria pelicula);
	void delete(Integer pelicula);
	Criteria searchById(Integer id);
	List<Criteria> getAll();
}



