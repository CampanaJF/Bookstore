package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioUsuario {
	
	
	Usuario auntentificarUsuario(String email, String password);
	
	void guardar(Usuario usuario);
	
    Usuario buscarXMail(String email);
    
	void modificar(Usuario usuario);
	
	Usuario getUsuario(Long id);
	
	Usuario getUsuarioNombre(String nombre);
	
	List<Usuario> getUsuariosNombre(String nombre);
	
	Boolean validarRegistro(Usuario usuario);

}
