package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Autor;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAutor;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBiblioteca;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioLibro;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

@Service("servicioAutor")
@Transactional
public class ServicioAutorImpl implements ServicioAutor {
	
	private RepositorioLibro repositorioLibro;
	private RepositorioUsuario repositorioUsuario;
	private RepositorioBiblioteca repositorioBiblioteca;
	private RepositorioAutor repositorioAutor;
	
	@Autowired
	public ServicioAutorImpl(RepositorioLibro repositorioLibro,
			RepositorioUsuario repositorioUsuario,RepositorioBiblioteca repositorioBiblioteca,
			RepositorioAutor repositorioAutor){
		
		this.repositorioLibro = repositorioLibro;
		this.repositorioUsuario= repositorioUsuario;
		this.repositorioBiblioteca = repositorioBiblioteca;
		this.repositorioAutor= repositorioAutor;
	}

	@Override
	public Autor getAutor(Long autorid) {
		Autor encontrado = this.repositorioAutor.getAutor(autorid);
		return encontrado;
	}

	@Override
	public List<Autor> getAutores() {

		return this.repositorioAutor.getAutores();
	}

	
	
	

}
