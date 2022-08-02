package ar.edu.unlam.tallerweb1.controladores;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.servicios.ServicioLibro;
import ar.edu.unlam.tallerweb1.servicios.ServicioSession;

@Controller
public class ControladorHome {
	
	private static final String UPLOAD_DIRECTORY ="/archivos";  
	private static final String dir ="C:/Users/Graciela/Desktop/Shelves/src/main/webapp/archivos";
	private final ServicioLibro servicioLibro;
	private final ServicioSession servicioSession;
	
	@Autowired
	 public ControladorHome(ServicioLibro servicioLibro,ServicioSession servicioSession) {

	       this.servicioLibro = servicioLibro;
	       this.servicioSession = servicioSession;

	  }
	
	
		@RequestMapping(path = "/libreria", method = RequestMethod.GET)
		public ModelAndView goLibreria() {
			return new ModelAndView("libreria");
		}
		
		@RequestMapping(path = "/perfil", method = RequestMethod.GET)
		public ModelAndView verPerfil() {
			return new ModelAndView("perfil");
		}
		
		@RequestMapping(path = "/home", method = RequestMethod.GET)
		public ModelAndView goHome(HttpServletRequest request) {
			
			ModelMap model = new ModelMap();
			Long userId = this.servicioSession.getUserId(request);
			 

			List<Libro> libros = servicioLibro.getLibros();

			model.put("usuario", userId);
			model.put("libros", libros);
			
			return new ModelAndView("index",model);
		}
		
		@RequestMapping("/nuevoLibro")
		public ModelAndView goNuevoLibro() {
			return new ModelAndView("nuevoLibro");
		}
		
	   
	    @RequestMapping(value="savefile",method=RequestMethod.POST)  
	    public ModelAndView upload( @RequestParam CommonsMultipartFile file,  
	           HttpSession session) throws Exception{  
	  
	    ServletContext context = session.getServletContext();  
	    String path = context.getRealPath(UPLOAD_DIRECTORY);  
	    String filename = file.getOriginalFilename();  
	  
	    System.out.println(path+" "+filename);        
	  
	    byte[] bytes = file.getBytes();  
	    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
	         new File(path + File.separator + filename)));  
	    stream.write(bytes);  
	    stream.flush();  
	    stream.close();  
	           
	    return new ModelAndView("nuevoLibro","filesuccess","File successfully saved!");  
	    }  
	    
//	    @RequestMapping(value="/savefile",method=RequestMethod.POST)  
//	    public ModelAndView upload(@RequestParam CommonsMultipartFile file,HttpSession session){  
//	            String path=session.getServletContext().getRealPath("/");  
//	            String filename=file.getOriginalFilename();  
//	              
//	            System.out.println(path+" "+filename);  
//	            try{  
//	            byte barr[]=file.getBytes();  
//	              
//	            BufferedOutputStream bout=new BufferedOutputStream(  
//	                     new FileOutputStream(path+"/"+filename));  
//	            bout.write(barr);  
//	            bout.flush();  
//	            bout.close();  
//	              
//	            }catch(Exception e){System.out.println(e);}  
//	            return new ModelAndView("nuevoLibro","filename",path+"/"+filename);  
//	        } 
//
//		
//		@RequestMapping(path = "/", method = RequestMethod.GET)
//		public ModelAndView home() {
//			return new ModelAndView("redirect:/home");
//		}

}
