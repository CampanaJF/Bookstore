package ar.edu.unlam.tallerweb1.servicios;


import java.util.Set;

import ar.edu.unlam.tallerweb1.modelo.Autor;

public interface ServicioBusqueda {
	
	Set<Autor> getAutoresBuscados(String campo);

}
