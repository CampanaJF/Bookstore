package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Autor;


@SuppressWarnings({ "unchecked", "deprecation" })
@Repository("RepositorioAutor")
@Transactional
public class RepositorioAutorImpl implements RepositorioAutor {
	
	 private SessionFactory sessionFactory;
	 
	 @Autowired
		private RepositorioAutorImpl (SessionFactory sessionFactory) {
				this.sessionFactory = sessionFactory;
		}
	 
	 private Session getSession() {
		   return sessionFactory.getCurrentSession();
	}

	@Override
	public Autor getAutor(Long autorid) {
		
		Criterion rest1 = Restrictions.eq("id",autorid);
		
		return (Autor) getSession().createCriteria(Autor.class).add(rest1).uniqueResult();
	}

	@Override
	public List<Autor> getAutores() {

		return getSession().createCriteria(Autor.class).list();
	}

}
