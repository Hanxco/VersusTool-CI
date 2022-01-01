package curso.modelo.negocio;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.modelo.entity.Application;
import curso.modelo.entity.ToolTypes;
import curso.modelo.persistencia.ToolTypesDAO;

@Service
public class ToolTypesGestor {
	
	@Autowired
	private ToolTypesDAO toolTypeDAO;
	
	public List<ToolTypes> getAllToolTypes() {
		return toolTypeDAO.getAllToolTypes();
	}
	
	public HashMap<Integer, ToolTypes> mapToolTypes() {
		HashMap<Integer, ToolTypes> mapToolTypes = new HashMap<Integer, ToolTypes>();
		for (ToolTypes tool : toolTypeDAO.getAllToolTypes()) {
			mapToolTypes.put(tool.getId(), tool);
		}
		return mapToolTypes;
	}
	
	
}
