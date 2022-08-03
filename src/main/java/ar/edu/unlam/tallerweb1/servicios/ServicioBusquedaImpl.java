package ar.edu.unlam.tallerweb1.servicios;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Autor;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAutor;

@Service("servicioBusqueda")
@Transactional
public class ServicioBusquedaImpl implements ServicioBusqueda{
	

	private RepositorioAutor repositorioAutor;


	@Autowired
	public ServicioBusquedaImpl(RepositorioAutor repositorioAutor) {
		this.repositorioAutor = repositorioAutor;


	}

	@Override
	public Set<Autor> getAutoresBuscados(String campo) {
		List<Autor> genero = repositorioAutor.getAutoresNombre(campo);
		List<Autor> artista = repositorioAutor.getAutoresApellido(campo);


		Set<Autor> todos = new HashSet<>();

		todos.addAll(genero);
		todos.addAll(artista);
		
		return todos;
	}

}
