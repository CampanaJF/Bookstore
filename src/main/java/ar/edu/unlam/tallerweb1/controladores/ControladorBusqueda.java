package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Biblioteca;
import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Resenia;
import ar.edu.unlam.tallerweb1.servicios.ServicioAutor;
import ar.edu.unlam.tallerweb1.servicios.ServicioBiblioteca;
import ar.edu.unlam.tallerweb1.servicios.ServicioLibro;
import ar.edu.unlam.tallerweb1.servicios.ServicioSession;

@Controller
public class ControladorBusqueda {
	
	private final ServicioLibro servicioLibro;
	private final ServicioSession servicioSession;
	private final ServicioAutor servicioAutor;
	
	@Autowired
	 public ControladorBusqueda(ServicioLibro servicioLibro,ServicioAutor servicioAutor,ServicioSession servicioSession) {
		   this.servicioAutor = servicioAutor;
	       this.servicioLibro = servicioLibro;
	       this.servicioSession = servicioSession;

	  }

}
