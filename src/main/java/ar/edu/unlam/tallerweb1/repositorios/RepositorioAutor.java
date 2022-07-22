package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;
import ar.edu.unlam.tallerweb1.modelo.Autor;

public interface RepositorioAutor {
	
	Autor getAutor (Long id);
	
	List<Autor> getAutores();

}
