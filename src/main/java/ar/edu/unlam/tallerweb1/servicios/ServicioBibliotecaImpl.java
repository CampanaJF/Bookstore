package ar.edu.unlam.tallerweb1.servicios;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Biblioteca;
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
	public Boolean agregarABiblioteca(Long Lid, Long Uid) {
		
		Usuario usuario = repositorioUsuario.getUsuario(Uid);
		Libro libro = repositorioLibro.getLibro(Lid);
		
		Biblioteca agregado = new Biblioteca();
		agregado.setEstado(Estado.Nuevo);
		agregado.setUsuario(usuario);
		agregado.setLibro(libro);
		
		return guardarBiblioteca(agregado);
		
	}
	
	@Override
	public Boolean guardarBiblioteca(Biblioteca nueva) {
		return repositorioBiblioteca.guardar(nueva);
	}

}
