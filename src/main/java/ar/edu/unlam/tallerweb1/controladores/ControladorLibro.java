package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Biblioteca;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.servicios.ServicioBiblioteca;
import ar.edu.unlam.tallerweb1.servicios.ServicioLibro;
import ar.edu.unlam.tallerweb1.servicios.ServicioSession;

@Controller
public class ControladorLibro {
	
	
	private final ServicioLibro servicioLibro;
	private final ServicioBiblioteca servicioBiblioteca;
	private final ServicioSession servicioSession;
	
	 @Autowired
	 public ControladorLibro(ServicioLibro servicioLibro,ServicioBiblioteca servicioBiblioteca,ServicioSession servicioSession) {
		   this.servicioBiblioteca = servicioBiblioteca;
	       this.servicioLibro = servicioLibro;
	       this.servicioSession = servicioSession;

	  }

	@RequestMapping(path = "/libro", method = RequestMethod.GET)
	public ModelAndView verLibro(@RequestParam("libroId") Long libroId,HttpServletRequest request) {
		
		Libro libro = this.servicioLibro.getLibro(libroId);

		Long userId = this.servicioSession.getUserId(request);
		
		ModelMap model = new ModelMap();
		
		
		if (userId==null) {
			model.put("libro", libro);
			return new ModelAndView("libro",model);
        }
		
		Biblioteca biblioteca = this.servicioBiblioteca.getBiblioteca(libroId, userId);
		
//		SimpleDateFormat formatofecha = new SimpleDateFormat ("dd-MM-yyyy");
//		
//		String fecha = formatofecha.format(libro.getPublicado());		
		
		model.put("biblioteca", biblioteca);
		model.put("usuario", userId);
		model.put("libro", libro);
		return new ModelAndView("libro",model);
	}
	
	
}
