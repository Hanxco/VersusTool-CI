package curso.modelo.negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.modelo.entity.AppDetail;
import curso.modelo.entity.AppDetailWrapper;
import curso.modelo.entity.Application;
import curso.modelo.entity.Criteria;
import curso.modelo.entity.VersusWrapper;
import curso.modelo.persistencia.AppDetailDAO;

@Service
public class AppDetailGestor {
	
	
	@Autowired
	private AppDetailDAO appDetailDAO;
	
	@Autowired
	private CriteriaGestor criteriaGestor;
	
	public AppDetailDAO getAppDetailDAO() {
		return appDetailDAO;
	}
	
	public void setAppDetailDAO(AppDetailDAO appDetailDAO) {
		this.appDetailDAO = appDetailDAO;
	}
	
	public HashMap<Integer, AppDetail> getAppDetailList(Integer appId) {
		HashMap<Integer, AppDetail> hashMap = new HashMap<Integer, AppDetail>();
		for (AppDetail appDetail : appDetailDAO.getAllByAppId(appId)) {
			hashMap.put(appDetail.getCriteriaId(), appDetail);
		}
		return hashMap;
	}
	
	public List<AppDetailWrapper> getAppsDetailByAppId(Integer appId) {
		List<AppDetailWrapper> lstAppWrapper = new ArrayList<AppDetailWrapper>();
		List<AppDetail> lstAppDetail = appDetailDAO.getAllByAppId(appId);
		System.out.println("lstAppDetail => " + lstAppDetail);

		for (AppDetail appDetail : lstAppDetail) {
			if (appDetail.getCriteriaId() != null) {				
				AppDetailWrapper appWrapper = new AppDetailWrapper(appDetail, criteriaGestor.getCriteriaById(appDetail.getCriteriaId()));
				lstAppWrapper.add(appWrapper);
			}
		}
		return lstAppWrapper;
	}
	
	public List<VersusWrapper> getVersusWrapper(List<Application> lstApplications) {
		List<HashMap<Integer, AppDetail>> lstHashMap = new ArrayList<HashMap<Integer, AppDetail>>();
		for (Application app : lstApplications) {	
			HashMap<Integer, AppDetail> mapAppDetail = getAppDetailList(app.getId());
			lstHashMap.add(mapAppDetail);
		}
		HashMap<Integer, Criteria> criteriaMap = criteriaGestor.getMapCriteria();

		List<VersusWrapper> lstTableWrapper = new ArrayList<VersusWrapper>();
		
		if (lstHashMap.size() > 1) {			
			for (Integer keyUnit : criteriaMap.keySet()) {
				final String category = criteriaMap.get(keyUnit).getCategory();
				String typeData = "text";
				if (category.equals("Integraciones") || category.equals("Funcionalidades")) {
					typeData = "boolean";
				}
				AppDetail res1 = lstHashMap.get(0).get(keyUnit);
				AppDetail res2 = lstHashMap.get(1).get(keyUnit);
				String resStr1 = res1 != null ? res1.getDescription() : "";
				String resStr2 = res2 != null ? res2.getDescription() : "";
				if (resStr1 != "" || resStr2 != "") {			
					VersusWrapper vsWrapp = new VersusWrapper(keyUnit, criteriaMap.get(keyUnit).getName(), resStr1, resStr2, typeData);
					lstTableWrapper.add(vsWrapp);
				}
			}
		}
		return lstTableWrapper;
	}
	
	public void insertAppDetail(AppDetail app) {
		appDetailDAO.insert(app);
	}
	
}
