package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Libro;

public interface ServicioLibro {

	Libro getLibro(Long id);
	
	List<Libro> getLibros();

}
