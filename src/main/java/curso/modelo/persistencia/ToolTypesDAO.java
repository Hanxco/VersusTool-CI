package curso.modelo.persistencia;

import java.util.List;

import curso.modelo.entity.AppDetail;
import curso.modelo.entity.ToolTypes;

public interface ToolTypesDAO {

	void insert(AppDetail app);
	void modify(AppDetail app);
	void delete(Integer appId);
	ToolTypes searchById(Integer id);
	List<ToolTypes> getAllToolTypes();
	
}



