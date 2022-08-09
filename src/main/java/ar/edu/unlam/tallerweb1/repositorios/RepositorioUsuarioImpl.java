package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// implelemtacion del repositorio de usuarios, la anotacion @Repository indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.dao
// para encontrar esta clase.
@SuppressWarnings({ "unchecked", "deprecation" })
@Repository("repositorioUsuario")
@Transactional
public class RepositorioUsuarioImpl implements RepositorioUsuario {
	
	// Maneja acciones de persistencia, normalmente estara inyectado el session factory de hibernate
	// el mismo esta difinido en el archivo hibernateContext.xml
	private SessionFactory sessionFactory;


    @Autowired
	public RepositorioUsuarioImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
    
    private Session getSession() {
		   return sessionFactory.getCurrentSession();
	}
    
	@Override
	public Usuario auntentificarUsuario(String email, String password) {	
		Criterion rest1 = Restrictions.eq("email", email);
		Criterion rest2 = Restrictions.eq("password", password);
		
		return (Usuario) getSession() .createCriteria(Usuario.class)
				.add(rest1).add(rest2).uniqueResult();	
	}

	@Override
	public void guardar(Usuario usuario) {
		getSession() .save(usuario);
	}

	@Override
	public Usuario buscarXMail(String email) {	
		Criterion rest1 = Restrictions.eq("email", email);
		return (Usuario) getSession() .createCriteria(Usuario.class).add(rest1).uniqueResult();
	}

	@Override
	public void modificar(Usuario usuario) {
		getSession() .update(usuario);
	}

	@Override
	public Usuario getUsuario(Long id) {
		Criterion rest1 = Restrictions.eq("id",id);
		
		return (Usuario) getSession() .createCriteria(Usuario.class).add(rest1).uniqueResult();
	}
	
	@Override
	public Usuario getUsuarioNombre(String nombre) {
		
		Criterion rest1 = Restrictions.eq("nombre",nombre);

		return (Usuario) getSession() .createCriteria(Usuario.class).add(rest1).uniqueResult();
			
	}
	
	@Override
	public List<Usuario> getUsuariosNombre(String nombre) {
		Criterion rest1 = Restrictions.ilike("nombre",nombre,MatchMode.ANYWHERE);
		
		return getSession() .createCriteria(Usuario.class).add(rest1).list();
			
	}

	@Override
	public Boolean validarRegistro(Usuario usuario) {
		Criterion rest1 = Restrictions.eq("email", usuario.getEmail());

		Usuario encontrado = (Usuario) getSession().createCriteria(Usuario.class).add(rest1).uniqueResult();
		
		if(encontrado == null)
			return true;
		
		return false;
		
	}


}
