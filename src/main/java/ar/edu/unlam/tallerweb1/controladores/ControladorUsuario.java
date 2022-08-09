package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioSession;
import ar.edu.unlam.tallerweb1.excepciones.*;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorUsuario {

	private ServicioUsuario servicioUsuario;
	private ServicioSession servicioSession;

	@Autowired
	public ControladorUsuario(ServicioUsuario servicioUsuario,ServicioSession servicioSession){
		this.servicioUsuario = servicioUsuario;
		this.servicioSession = servicioSession;
	}

	@RequestMapping("/login")
	public ModelAndView irALogin() {

		ModelMap model = new ModelMap();

		model.put("datosUsuario", new Usuario());

		return new ModelAndView("login", model);
	}
	
	@RequestMapping("/registrarse")
	public ModelAndView registro(HttpServletRequest request) {
		//validar si esta logueado
		ModelMap model = new ModelMap();
		
		model.put("datosUsuario", new Usuario());
		
		return new ModelAndView("registro", model);
	}


	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("datosUsuario") Usuario datosUsuario, HttpServletRequest request) {
		ModelMap model = new ModelMap();

		Usuario usuarioBuscado = servicioUsuario.validarLogin(datosUsuario.getEmail(), datosUsuario.getPassword());
		if (usuarioBuscado != null) {
			servicioSession.setUserId(usuarioBuscado.getId(), request);
			return new ModelAndView("redirect:/home");
		} else {
			model.put("error", "Usuario o clave incorrecta");
		}
		return new ModelAndView("login", model);
	}
	
	@RequestMapping(path = "/logout", method = RequestMethod.GET)
    public ModelAndView guardarUsuario(HttpServletRequest request) {
        request.getSession().invalidate();
        return new ModelAndView("redirect:/home");
    }
	
	
	
	@RequestMapping(path="/procesarRegistro",method=RequestMethod.POST)
	public ModelAndView procesarRegistro(
			@ModelAttribute("datosUsuario") Usuario datosUsuario) {
		
		ModelMap model = new ModelMap();
		String mensaje="exito";
			
		try {
            servicioUsuario.registrarUsuario(datosUsuario);
        } catch (EmailEnUsoException eeue) {
        	mensaje="El Email ya esta en uso";
        	
        } catch (PasswordsDiferentesException pde) {
        	mensaje="Las contraseñas son diferentes";
        	
        } catch (PasswordLenghtException ple) {
        	mensaje="La contraseña debe tener almenos 12 caracteres";
        	
        }

		model.put("mensaje",mensaje);
		
		return new ModelAndView("registro",model);
			
	}

	
}
