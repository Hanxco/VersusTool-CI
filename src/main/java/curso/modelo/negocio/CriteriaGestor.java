package curso.modelo.negocio;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.modelo.entity.AppDetail;
import curso.modelo.entity.Application;
import curso.modelo.entity.Criteria;
import curso.modelo.entity.ToolTypes;
import curso.modelo.persistencia.AppDetailDAO;
import curso.modelo.persistencia.ApplicationDAO;
import curso.modelo.persistencia.CriteriaDAO;

@Service
public class CriteriaGestor {
	
	@Autowired
	private CriteriaDAO criteriaDAO;
	@Autowired
	private AppDetailDAO appDetailDAO;
	@Autowired
	private ApplicationDAO appDAO;
	@Autowired
	private ToolTypesGestor toolTypesGestor;
	
	public CriteriaDAO getCriteriaDao() {
		return criteriaDAO;
	}
	
	public void setCriteriaDao(CriteriaDAO criteriaDao) {
		this.criteriaDAO = criteriaDao;
	}
	
	public HashMap<Integer, Criteria> getMapCriteria() {
		HashMap<Integer, Criteria> mapHash = new HashMap<Integer, Criteria>();
		for (Criteria criteria : criteriaDAO.getAll()) {
			mapHash.put(criteria.getId(), criteria);
		}
		return mapHash;		
	}
	
	public List<Criteria> getAllCriteria() {
		List<Criteria> lstCriteria = new ArrayList<Criteria>();
		HashMap<Integer, ToolTypes> mapToolTypes = toolTypesGestor.mapToolTypes();
		for (Criteria criteria : criteriaDAO.getAll()) {
			if (criteria.getAppId() == 0) {				
				criteria.setApp_label("Generico");
			} else {
				criteria.setApp_label(mapToolTypes.get(criteria.getAppId()).getLabel());
			}
			lstCriteria.add(criteria);				
		}
		return lstCriteria;
	}
	
	public List<Criteria> getCriteriaAvailableApp(Integer appId) {
		Application application = appDAO.searchById(appId);
		List<AppDetail> appDetail = appDetailDAO.getAllByAppId(appId);
		HashMap<Integer, AppDetail> mapAppDetail = new HashMap<Integer, AppDetail>();
		for (AppDetail app : appDetail) {
			mapAppDetail.put(app.getCriteriaId(), app);
		}
		
		List<Criteria> lstCriteria = criteriaDAO.getAll();
		List<Criteria> retNew = new ArrayList<Criteria>();
		for (Criteria item : lstCriteria) {
			if (!mapAppDetail.containsKey(item.getId())) {
				if (item.getAppId() == 0 || item.getAppId() == application.getType()) {
					retNew.add(item);
				}
			}
		}
		return retNew;
	}
	
	public Criteria getCriteriaById(Integer id) {
		return criteriaDAO.searchById(id);
	}
	
	public void insert(Criteria criteria) {
		criteriaDAO.insert(criteria);
	}
	
	
	
}


