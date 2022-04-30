package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorHome {
	
	
		@RequestMapping(path = "/historias", method = RequestMethod.GET)
		public ModelAndView goHistorias() {
			return new ModelAndView("historias");
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
