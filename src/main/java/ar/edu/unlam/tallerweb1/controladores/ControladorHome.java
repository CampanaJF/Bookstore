package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.servicios.ServicioLibro;
import ar.edu.unlam.tallerweb1.servicios.ServicioSession;

@Controller
public class ControladorHome {
	
	
	private final ServicioLibro servicioLibro;
	private final ServicioSession servicioSession;
	
	@Autowired
	 public ControladorHome(ServicioLibro servicioLibro,ServicioSession servicioSession) {

	       this.servicioLibro = servicioLibro;
	       this.servicioSession = servicioSession;

	  }
	
	
		@RequestMapping(path = "/libreria", method = RequestMethod.GET)
		public ModelAndView goLibreria() {
			return new ModelAndView("libreria");
		}
		
		@RequestMapping(path = "/perfil", method = RequestMethod.GET)
		public ModelAndView verPerfil() {
			return new ModelAndView("perfil");
		}
		
		@RequestMapping(path = "/home", method = RequestMethod.GET)
		public ModelAndView goHome(HttpServletRequest request) {
			
			ModelMap model = new ModelMap();
			Long userId = this.servicioSession.getUserId(request);
			 

			List<Libro> libros = servicioLibro.getLibros();

			model.put("usuario", userId);
			model.put("libros", libros);
			
			return new ModelAndView("index",model);
		}

		
		@RequestMapping(path = "/", method = RequestMethod.GET)
		public ModelAndView home() {
			return new ModelAndView("redirect:/home");
		}

}
