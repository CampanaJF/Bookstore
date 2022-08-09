package ar.edu.unlam.tallerweb1.servicios;

import java.util.Date;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioUsuario {

	Usuario validarLogin(String email, String password);
	
	Boolean validarRegistro(Usuario usuario);

	void registrarUsuario(Usuario datosUsuario);

	Date getFechaActual();
	
	Boolean validarPassLenght(Usuario datosUsuario);
	
	Boolean validarPass(Usuario datosUsuario);
}
