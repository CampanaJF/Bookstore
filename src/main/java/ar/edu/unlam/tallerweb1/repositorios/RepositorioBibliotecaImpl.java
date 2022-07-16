package ar.edu.unlam.tallerweb1.repositorios;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Biblioteca;

@SuppressWarnings({ "unchecked", "deprecation" })
@Repository("RepositorioBiblioteca")
@Transactional
public class RepositorioBibliotecaImpl implements RepositorioBiblioteca {

	 private SessionFactory sessionFactory;
	 
	@Autowired
	private RepositorioBibliotecaImpl (SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
	}
		
	private Session getSession() {
		   return sessionFactory.getCurrentSession();
	}
		
	@Override
	public Boolean guardar(Biblioteca biblioteca) {
		
		if(biblioteca.getEstado()!=(null)) {
		getSession().save(biblioteca);
		
		return true;
		}
		 	
		return false;
	}

}
