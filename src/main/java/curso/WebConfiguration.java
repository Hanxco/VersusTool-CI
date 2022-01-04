package curso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import curso.modelo.entity.Application;
import curso.modelo.negocio.ApplicationGestor;

@Controller
@RequestMapping("/")
public class WebConfiguration implements WebMvcConfigurer {
	
	@Autowired
	ApplicationGestor appGestor;
	
	@RequestMapping("")
	public ModelAndView initIndex() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("lstApplications", appGestor.getAllApps());
		return mav;
	}
	
	@RequestMapping("sobreVersus")
	public ModelAndView sobreVersusPag() {
		ModelAndView mav = new ModelAndView("sobreVersusTool");
		return mav;
	}
   
}