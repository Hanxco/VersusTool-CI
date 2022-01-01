package controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import modelo.negocio.GestorPeliculas;
import modelo.entidades.Pelicula;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.Validator;

@Controller
@RequestMapping("peliculas")
public class ControladorPeliculas {

	@Autowired
	private GestorPeliculas gestorPeliculas;

	@RequestMapping("verListado")
	public ModelAndView verListadoPeliculas() {
		ModelAndView mav = new ModelAndView("listadoPeliculas");

		mav.addObject("listaPeliculas", gestorPeliculas.getListaPeliculas());
		return mav;
	}

	@RequestMapping("verFormulario")
	public ModelAndView verFormulario() {
		ModelAndView mav = new ModelAndView("verFormulario");

		mav.addObject("pelicula", new Pelicula());

		return mav;
	}

	@RequestMapping(path="insertar", method=RequestMethod.POST)
	public ModelAndView insertarPelicula( @Valid final Pelicula pelicula, BindingResult br,
			@ModelAttribute Pelicula peliculaItem, HttpServletRequest request ) {
		try {
			System.out.println(br);
			if(br.hasErrors()) {
				System.out.println("ENTRANDO");
				ModelAndView mav = new ModelAndView("verFormulario");
				String mensajeError = "";
				for(FieldError fe : br.getFieldErrors()) {
					mensajeError += fe.getField() + " " + fe.getDefaultMessage();
				}
				mav.addObject("errorTitulo", mensajeError);
				request.setAttribute("errorTitulo", mensajeError);
				return mav;
			}
		
			gestorPeliculas.insertar(pelicula);
			System.out.println(pelicula);
			
			return new ModelAndView("redirect:verListado");	
		}catch(Exception ex) {  // FORMA ALTERNATIVA MEJOR CON ANOTACIONES
			ModelAndView mav = new ModelAndView("verFormulario");
			/*mav.addObject("pelicula", pelicula);
			mav.addObject("errorTitulo", ex.getMessage());
			request.setAttribute("errorTitulo", "aqui");*/
			return mav;
		}
	}

	@RequestMapping(path = "eliminar", method = RequestMethod.POST)
	public ModelAndView eliminar(@ModelAttribute Pelicula pelicula) {
		System.out.println("CONTRADOR " + pelicula);
		gestorPeliculas.eliminar(pelicula);

		return new ModelAndView("redirect:verListado");
	}

	@RequestMapping(path = "modificar", method = RequestMethod.POST)
	public ModelAndView modificar(@ModelAttribute Pelicula pelicula) {
		gestorPeliculas.modificarPelicula(pelicula);

		return new ModelAndView("redirect:verListado");
	}

	@RequestMapping(path = "seleccionar", method = RequestMethod.GET)
	public ModelAndView seleccionarPelicula(@RequestParam("id") Integer id) {
		System.out.println("seleccionarPelicula");
		System.out.println(id);
		Pelicula pelicula = gestorPeliculas.buscarPelicula(id);

		ModelAndView mav = new ModelAndView("verFormulario");
		mav.addObject(pelicula);
		return mav;
	}

	public GestorPeliculas getGestorPeliculas() {
		return gestorPeliculas;
	}

	public void setGestorPeliculas(GestorPeliculas gestorPeliculas) {
		this.gestorPeliculas = gestorPeliculas;
	}

}
