package curso.modelo.negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.modelo.entity.Application;
import curso.modelo.entity.ToolTypes;
import curso.modelo.persistencia.ApplicationDAO;

@Service
public class ApplicationGestor {
	
	@Autowired
	private ApplicationDAO applicationDAO;
	@Autowired
	private ToolTypesGestor toolTypesGestor;
	
	public ApplicationDAO getCriteriaDao() {
		return applicationDAO;
	}
	
	public void setCriteriaDao(ApplicationDAO applicationDAO) {
		this.applicationDAO = applicationDAO;
	}
	
	public List<Application> getAllApps() {
		return setLabelFields(applicationDAO.getAll());
	}
	
	public Application getAppById(Integer id) {
		List<Application> arrayApp = new ArrayList<Application>();
		arrayApp.add(applicationDAO.searchById(id));
		return setLabelFields(arrayApp).get(0);
	}
	
	public List<Application> searchByType(Integer type) {
		return setLabelFields(applicationDAO.searchByType(type));
	}
	
	public List<Application> setLabelFields(List<Application> lstReq) {
		List<Application> lstApp = new ArrayList<Application>();
		HashMap<Integer, ToolTypes> mapToolTypes = toolTypesGestor.mapToolTypes();
		for (Application app : lstReq) {
			app.setType_label(mapToolTypes.get(app.getType()).getLabel());
			lstApp.add(app);
		}
		return lstApp;
	}
	  
	public void insertApp(Application app) {
		applicationDAO.insert(app);
	}
	
}
