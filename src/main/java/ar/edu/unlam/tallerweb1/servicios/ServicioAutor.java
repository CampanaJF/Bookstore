package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Autor;

public interface ServicioAutor {
	
	Autor getAutor(Long id);
	
	List<Autor> getAutores();

}
