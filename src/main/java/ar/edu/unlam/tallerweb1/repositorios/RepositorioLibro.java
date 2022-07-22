package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Lenguaje;
import ar.edu.unlam.tallerweb1.modelo.Libro;

public interface RepositorioLibro {
	
	Libro buscarLibroXTitulo (String titulo);
	Libro buscarLibroXAutor (String autor);
	Libro buscarLibroXLenguaje (Lenguaje lenguaje);
	List <Libro> getLibros (); // no seria necesario buscar por cada campo, se deberian poder sacar todos de esta querie
	Libro getLibro(Long id);

}
