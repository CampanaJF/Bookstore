package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorHome {
	
	
		@RequestMapping(path = "/libreria", method = RequestMethod.GET)
		public ModelAndView goLibreria() {
			return new ModelAndView("libreria");
		}
		
		@RequestMapping(path = "/biblioteca", method = RequestMethod.GET)
		public ModelAndView verMiBiblioteca() {
			return new ModelAndView("biblioteca");
		}
		
		@RequestMapping(path = "/libro", method = RequestMethod.GET)
		public ModelAndView verLibro() {
			return new ModelAndView("libro");
		}
		
		
		@RequestMapping(path = "/perfil", method = RequestMethod.GET)
		public ModelAndView verPerfil() {
			return new ModelAndView("perfil");
		}
		
		@RequestMapping(path = "/home", method = RequestMethod.GET)
		public ModelAndView goHome() {
			return new ModelAndView("home");
		}

		
		@RequestMapping(path = "/", method = RequestMethod.GET)
		public ModelAndView home() {
			return new ModelAndView("redirect:/home");
		}

}
