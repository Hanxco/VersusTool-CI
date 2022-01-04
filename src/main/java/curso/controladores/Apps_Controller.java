package curso.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import curso.modelo.entity.AppDetail;
import curso.modelo.entity.AppDetailWrapper;
import curso.modelo.entity.Application;
import curso.modelo.entity.ToolTypes;
import curso.modelo.negocio.AppDetailGestor;
import curso.modelo.negocio.ApplicationGestor;
import curso.modelo.negocio.CriteriaGestor;
import curso.modelo.negocio.ToolTypesGestor;

@Controller
@RequestMapping("apps")
public class Apps_Controller {
	
	@Autowired
	private ApplicationGestor appsGestor;
	@Autowired
	private AppDetailGestor appDetailGestor;
	@Autowired
	private ToolTypesGestor toolTypesGestor;
	@Autowired
	private CriteriaGestor criteriaGestor;
	
	@RequestMapping("tools")
	public ModelAndView showToolsList() {
		ModelAndView mav = new ModelAndView("appTools");
		mav.addObject("appTools", appsGestor.getAllApps());
		mav.addObject("appTypes", toolTypesGestor.getAllToolTypes());
		return mav;
	}
	
	@RequestMapping(path="addTool", method=RequestMethod.POST)
	public ModelAndView addNewTool(HttpServletRequest request) { 
		ModelAndView mav = new ModelAndView("redirect:/apps/tools");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String description = request.getParameter("description");
		String link = request.getParameter("link");
		Application app = new Application();
		app.setName(name);
		app.setType(Integer.valueOf(type));
		app.setDescription(description);
		app.setLink(link);
		appsGestor.insertApp(app);
		return mav;
    }
	
	@RequestMapping(path="/tool/{id}", method = RequestMethod.GET)
	public ModelAndView showToolDetail(@PathVariable("id") int itemId) {
		ModelAndView mav = new ModelAndView("toolDetail");
		List<AppDetailWrapper> lstWrapper = appDetailGestor.getAppsDetailByAppId(itemId);
		mav.addObject("appObj", appsGestor.getAppById(itemId));
		mav.addObject("appCriterias", lstWrapper);
		mav.addObject("lstCriterias", criteriaGestor.getCriteriaAvailableApp(itemId));
		mav.addObject("toolId", itemId);
		return mav;
	}
	
	@RequestMapping(path="tool/{id}/addCriteriaApp", method=RequestMethod.POST)
	public ModelAndView addNewTool(@PathVariable("id") int itemId ,HttpServletRequest request) { 
		ModelAndView mav = new ModelAndView("redirect:/apps/tool/"+itemId);
		String criteria = request.getParameter("codCriterio");
		String description = request.getParameter("description");
		AppDetail appDetail = new AppDetail();
		appDetail.setAppId(itemId);
		appDetail.setDescription(description);
		appDetail.setCriteriaId(Integer.valueOf(criteria));
		appDetailGestor.insertAppDetail(appDetail);
		return mav;
    }
	
}
