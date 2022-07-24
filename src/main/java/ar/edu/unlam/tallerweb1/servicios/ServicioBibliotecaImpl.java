package ar.edu.unlam.tallerweb1.servicios;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Biblioteca;
import ar.edu.unlam.tallerweb1.excepciones.*;
import ar.edu.unlam.tallerweb1.modelo.Estado;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBiblioteca;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioLibro;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

@Service("servicioBiblioteca")
@Transactional
public class ServicioBibliotecaImpl implements ServicioBiblioteca {
	
	private RepositorioLibro repositorioLibro;
	private RepositorioUsuario repositorioUsuario;
	private RepositorioBiblioteca repositorioBiblioteca;

	@Autowired
	public ServicioBibliotecaImpl(RepositorioLibro repositorioLibro,
			RepositorioUsuario repositorioUsuario,RepositorioBiblioteca repositorioBiblioteca){
		this.repositorioLibro = repositorioLibro;
		this.repositorioUsuario= repositorioUsuario;
		this.repositorioBiblioteca = repositorioBiblioteca;
	}
	
	@Override
	public void cambiarPuntuacion(Long id, Long id2, Double p) {
		if(!(validarBibliotecaExistente(id,id2))) {
			throw new LibroNoExisteEnBibliotecaException();
		}
		
		this.repositorioBiblioteca.cambiarPuntuacion(id, id2, p);
		
	}
	
	@Override
	public void cambiarEstado(Long id, Long id2, Estado nuevo) {
		if(!(validarBibliotecaExistente(id,id2))) {
			throw new LibroNoExisteEnBibliotecaException();
		}
		
		this.repositorioBiblioteca.cambiarEstado(id, id2,nuevo);
		
	}
	
	@Override
	public void quitarDeBiblioteca(Long id, Long id2) {
		if(!(validarBibliotecaExistente(id,id2))) {
			throw new LibroNoExisteEnBibliotecaException();
		}
		
		this.repositorioBiblioteca.borrar(id,id2);
		
	}

	@Override
	public void agregarABiblioteca(Long Lid, Long Uid) {
		
		Usuario usuario = this.repositorioUsuario.getUsuario(Uid);
		Libro libro = this.repositorioLibro.getLibro(Lid);
		
		if(!(validarBibliotecaExistente(Lid,Uid))) {
		
			throw new LibroExisteEnBibliotecaException();
		}
		
		Biblioteca agregado = new Biblioteca();
		agregado.setEstado(Estado.Nuevo);
		agregado.setUsuario(usuario);
		agregado.setLibro(libro);
		
		guardarBiblioteca(agregado);
		
		
		
	}
	
	@Override
	public void guardarBiblioteca(Biblioteca nueva) {
		this.repositorioBiblioteca.guardar(nueva);
	}

	@Override
	public Boolean validarBibliotecaExistente(Long lid,Long uid) { //falso = NO EXISTE
	if ((this.repositorioBiblioteca.getBiblioteca(lid,uid))==null)
		return false;
	
		return true;
	}
	
	

	

}
