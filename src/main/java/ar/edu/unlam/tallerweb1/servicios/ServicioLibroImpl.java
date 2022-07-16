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


@Service("servicioLibro")
@Transactional
public class ServicioLibroImpl implements ServicioLibro{
	
	private RepositorioLibro repositorioLibro;
	private RepositorioUsuario repositorioUsuario;
	private RepositorioBiblioteca repositorioBiblioteca;

	@Autowired
	public ServicioLibroImpl(RepositorioLibro repositorioLibro,
			RepositorioUsuario repositorioUsuario,RepositorioBiblioteca repositorioBiblioteca){
		this.repositorioLibro = repositorioLibro;
		this.repositorioUsuario= repositorioUsuario;
		this.repositorioBiblioteca = repositorioBiblioteca;
	}

	

}
