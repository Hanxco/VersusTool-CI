package curso.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import curso.modelo.entity.Application;
import curso.modelo.entity.Criteria;
import curso.modelo.negocio.CriteriaGestor;
import curso.modelo.negocio.ToolTypesGestor;

@Controller
@RequestMapping("criteria")
public class Criteria_Controller {
	
	@Autowired
	private CriteriaGestor criteriaGestor;
	@Autowired
	private ToolTypesGestor toolTypesGestor;
	
	@RequestMapping("verCriterias")
	public ModelAndView showCriteriaList() {
		ModelAndView mav = new ModelAndView("criteria");
		mav.addObject("appTypes", toolTypesGestor.getAllToolTypes());
		mav.addObject("criteriaList", criteriaGestor.getAllCriteria());
		return mav;
	}
	
	@RequestMapping(path="addCriteria", method=RequestMethod.POST)
	public ModelAndView addNewTool(HttpServletRequest request) { 
		ModelAndView mav = new ModelAndView("redirect:/criteria/verCriterias");
		String name = request.getParameter("name");
		String clave = request.getParameter("clave");
		String tipoApp = request.getParameter("tipoApp");
		String categoria = request.getParameter("categoria");
		String subcategoria = request.getParameter("subcategoria");
		Criteria criteria = new Criteria();
		criteria.setName(name);
		criteria.setCategory(categoria);
		criteria.setSubcategory(subcategoria);
		criteria.setAppId(Integer.valueOf(tipoApp));
		criteria.setKey(clave);
		criteriaGestor.insert(criteria);
		return mav;
    }

}
