package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Resenia;

public interface ServicioLibro {

	Libro getLibro(Long id);
	
	List<Libro> getLibros();
	
	List<Genero> getGenerosLibro(Long Lid);
	
	List<Resenia> getReseniasLibro(Long Lid);
	
	void crearLibro(Libro libro);
	
	Libro setPublicadoLibro(Libro libro);
	
	void validarLenguajeLibro(Libro libro);
	
	void validarTituloYSinopsis(Libro libro);
	
	Libro validarPortadaYArchivo(Libro libro);
	

}
