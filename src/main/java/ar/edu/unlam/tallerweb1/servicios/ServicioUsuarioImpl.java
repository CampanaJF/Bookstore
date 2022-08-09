package ar.edu.unlam.tallerweb1.servicios;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.excepciones.EmailEnUsoException;
import ar.edu.unlam.tallerweb1.excepciones.PasswordLenghtException;
import ar.edu.unlam.tallerweb1.excepciones.PasswordsDiferentesException;
import ar.edu.unlam.tallerweb1.modelo.Usuario;


@Service("servicioUsuario")
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario {

	private RepositorioUsuario repositorioUsuario;

	@Autowired
	public ServicioUsuarioImpl(RepositorioUsuario repositorioLoginDao){
		this.repositorioUsuario= repositorioLoginDao;
	}

	@Override
	public Usuario validarLogin (String email, String password) {
		return repositorioUsuario.auntentificarUsuario(email, password);
	}
	
	@Override
	public Boolean validarRegistro(Usuario usuario) {
		return repositorioUsuario.validarRegistro(usuario);
	}

	@Override
	public void registrarUsuario(Usuario datosUsuario) {
		
		if(!validarRegistro(datosUsuario))
			throw new EmailEnUsoException();
		
		if(!validarPass(datosUsuario))
			throw new PasswordsDiferentesException();
		
		if(!validarPassLenght(datosUsuario))
			throw new PasswordLenghtException();
		
		datosUsuario.setFechaRegistro(getFechaActual());
		
		repositorioUsuario.guardar(datosUsuario);
		
	}
	
	@Override
	public Boolean validarPassLenght(Usuario datosUsuario) {
		if(datosUsuario.getPassword()!=datosUsuario.getPasswordRe())
			return true;
		
		return false;
	}

	@Override
	public Boolean validarPass(Usuario datosUsuario) {

		return datosUsuario.getPassword().length()<12;	
	}

	@Override
	public Date getFechaActual() {
		
		Date now = new Date();
    	now.getTime();
		
		return now;
		
	}

}
