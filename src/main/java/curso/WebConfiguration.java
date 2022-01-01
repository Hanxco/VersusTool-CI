package curso;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@RequestMapping("/")
public class WebConfiguration implements WebMvcConfigurer {
	
	@RequestMapping("init")
	public ModelAndView initIndex() {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	
	@RequestMapping("sobreVersus")
	public ModelAndView sobreVersusPag() {
		ModelAndView mav = new ModelAndView("sobreVersusTool");
		return mav;
	}
   
}