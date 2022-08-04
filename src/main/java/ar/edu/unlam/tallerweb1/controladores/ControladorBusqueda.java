package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Autor;

import ar.edu.unlam.tallerweb1.modelo.Libro;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

import ar.edu.unlam.tallerweb1.servicios.ServicioBusqueda;

import ar.edu.unlam.tallerweb1.servicios.ServicioSession;

@Controller
public class ControladorBusqueda {
	

	private final ServicioSession servicioSession;
	private final ServicioBusqueda servicioBusqueda;
	
	@Autowired
	 public ControladorBusqueda(ServicioBusqueda servicioBusqueda,ServicioSession servicioSession) {
		   this.servicioBusqueda = servicioBusqueda;
	       this.servicioSession = servicioSession;

	  }
	
//	@RequestMapping(path = "/busqueda", method = RequestMethod.POST)
//	public ModelAndView buscar(@RequestParam String busqueda,String select,HttpServletRequest request) {
//		ModelMap model = new ModelMap();
//		Long userId = this.servicioSession.getUserId(request);
//		model.put("usuario", userId);
//		
//		if(select=="libros") {
//			model.put("libros",servicioBusqueda.getLibrosBuscados(busqueda));
//			
//		    return new ModelAndView("busqueda",model);
//		}
//		
//		if(select=="autores") {
//			model.put("autores",servicioBusqueda.getAutoresBuscados(busqueda));
//
//			return new ModelAndView("busqueda",model);
//		}
//		
//		if(select=="usuario") {
//			model.put("usuarios",servicioBusqueda.getUsuariosBuscados(busqueda));
//
//			return new ModelAndView("busqueda",model);
//		}
//		
//		model.put("error", "oh nyo");
//
//		return new ModelAndView("busqueda",model);
//	}
	
	@RequestMapping(path = "/busqueda", method = RequestMethod.POST)
	public ModelAndView buscara(@RequestParam String busqueda,HttpServletRequest request) {
		ModelMap model = new ModelMap();
		Long userId = this.servicioSession.getUserId(request);
		model.put("usuario", userId);
		
		List<Libro> l = servicioBusqueda.getLibrosBuscados(busqueda);
		Set<Autor> u = servicioBusqueda.getAutoresBuscados(busqueda);
		List<Usuario> a = servicioBusqueda.getUsuariosBuscados(busqueda);
		
		
		model.put("libros",servicioBusqueda.getLibrosBuscados(busqueda));
			
		  
		model.put("autores",servicioBusqueda.getAutoresBuscados(busqueda));


		model.put("usuarios",servicioBusqueda.getUsuariosBuscados(busqueda));

		return new ModelAndView("busqueda",model);
		
//		
//		model.put("error", "oh nyo");
//
//		return new ModelAndView("busqueda",model);
	}

}
