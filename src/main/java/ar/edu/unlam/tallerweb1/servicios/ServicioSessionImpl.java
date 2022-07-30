package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Service("servicioSession")
@Transactional
public class ServicioSessionImpl implements ServicioSession{


    @Override
	public Long getUserId(HttpServletRequest request) {
		return (Long)request.getSession().getAttribute("ID");
	}
    
    @Override
	public void setUserId(Long id,HttpServletRequest request) {
		request.getSession().setAttribute("ID",id);
	}

	@Override
	public Long getLibroId(HttpServletRequest request) {
		return (Long)request.getSession().getAttribute("LID");
	}

	@Override
	public void setLibroId(Long id, HttpServletRequest request) {
		request.getSession().setAttribute("LID",id);
		
	}

    
}