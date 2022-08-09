package ar.edu.unlam.tallerweb1.servicios;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Autor;
import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAutor;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioLibro;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

@Service("servicioBusqueda")
@Transactional
public class ServicioBusquedaImpl implements ServicioBusqueda{
	

	private RepositorioAutor repositorioAutor;
	private RepositorioLibro repositorioLibro;
	private RepositorioUsuario repositorioUsuario;

	@Autowired
	public ServicioBusquedaImpl(RepositorioAutor repositorioAutor,
			RepositorioLibro repositorioLibro,RepositorioUsuario repositorioUsuario) {
		this.repositorioAutor = repositorioAutor;
		this.repositorioLibro = repositorioLibro;
		this.repositorioUsuario = repositorioUsuario;

	}
	
	@Override
	public List<Usuario> getUsuariosBuscados(String campo) {
		
		return this.repositorioUsuario.getUsuariosNombre(campo);
	
	}
	
	@Override
	public List<Libro> getLibrosBuscados(String campo) {
		
		return this.repositorioLibro.getLibrosTitulo(campo);
	
	}

	@Override
	public Set<Autor> getAutoresBuscados(String campo) {
		List<Autor> a = this.repositorioAutor.getAutoresNombre(campo);
		List<Autor> b = this.repositorioAutor.getAutoresApellido(campo);


		Set<Autor> todos = new HashSet<>();

		todos.addAll(a);
		todos.addAll(b);
		
		return todos;
	}

}
