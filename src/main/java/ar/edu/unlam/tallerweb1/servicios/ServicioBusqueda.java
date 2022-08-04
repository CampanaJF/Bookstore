package ar.edu.unlam.tallerweb1.servicios;


import java.util.List;
import java.util.Set;

import ar.edu.unlam.tallerweb1.modelo.Autor;
import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioBusqueda {
	
	Set<Autor> getAutoresBuscados(String campo);

	List<Libro> getLibrosBuscados(String campo);

	List<Usuario> getUsuariosBuscados(String campo);


}
