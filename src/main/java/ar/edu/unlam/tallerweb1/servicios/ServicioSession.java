package ar.edu.unlam.tallerweb1.servicios;

import javax.servlet.http.HttpServletRequest;

public interface ServicioSession {

	Long getUserId(HttpServletRequest request);

	void setUserId(Long id, HttpServletRequest request);
	
	Long getLibroId(HttpServletRequest request);

	void setLibroId(Long id, HttpServletRequest request);
}
