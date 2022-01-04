package curso.controladores;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import curso.modelo.entity.AppDetailWrapper;
import curso.modelo.entity.Application;
import curso.modelo.negocio.AppDetailGestor;
import curso.modelo.negocio.ApplicationGestor;
import curso.modelo.negocio.CriteriaGestor;

@Controller
@RequestMapping("vs")
public class Dashboard_Controller {
	

	@Autowired
	ApplicationGestor appGestor;
	@Autowired
	AppDetailGestor appDetailGestor;
	@Autowired
	CriteriaGestor criteriaGestor;

	@RequestMapping(path="/{id}", method = RequestMethod.GET)
	public ModelAndView versusAppExecute(@PathVariable("id") int itemId) {
		ModelAndView mav = new ModelAndView("versusTool");
		final List<Application> lstApplications = appGestor.searchByType(itemId);
		
		mav.addObject("lstApplications", lstApplications);
		mav.addObject("versusWrapper", appDetailGestor.getVersusWrapper(lstApplications));
		return mav;
	}

	@RequestMapping(path="/{id}/versus/{id2}", method = RequestMethod.GET)
	public ModelAndView showToolDetail(@PathVariable("id") int itemId, @PathVariable("id2") int itemId2) {
		ModelAndView mav = new ModelAndView("versusTool");
		final Application application1 = appGestor.getAppById(itemId);
		final Application application2 = appGestor.getAppById(itemId2);
		List<Application> lstApplication = new ArrayList<Application>();
		lstApplication.add(application1);
		lstApplication.add(application2);
		mav.addObject("lstApplications", lstApplication);
		mav.addObject("versusWrapper", appDetailGestor.getVersusWrapper(lstApplication));
		return mav;
	}
	
}
