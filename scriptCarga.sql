/*drop database db;
esPremium - fecha de inscripcion - fecha de vencimiento
create schema db; */
use shelves;

insert into usuario (email,fechaRegistro,password) values
					('admin',substring(now(),1,11),'admin'),
					('zero@nonary.com',substring(now(),1,11),'Q'),
					('nanana@nanana.com',substring(now(),1,11),'sana'),
					('pacofranco45@gmail.com',substring(now(),1,11),'admin'),
					('jucampana@alumno.unlam.edu.ar','2022-07-01','admin');
                    
insert into premium (fechaInicio,fechaFin,descripcion,precio) values
					  (substring(now(),1,11),'2024-05-16','PremiumEscritor',200.00), /*Necesario para autor */
				      (substring(now(),1,11),'2023-07-16','PremiumPlus',300.00);
                    
update usuario set premium_id=2,esPremium=true where usuario.id=2;
update usuario set premium_id=1,esPremium=true where usuario.id=3;

insert into autor (apellido,nombre,usuario_id,activo) values
				  ('Kurashki','June',2,true),
				  ('Tsu','Sana',3,true);
                  
insert into serie (titulo) values ('El Brujero'),('Witcherer');

insert into serieautor (autor_id,serie_id) values (1,2),(2,1);

insert into libro (lenguaje,publicado,sinopsis,titulo,autor_id,portada,esPremium,serie_id) values
					('Ingles',substring(now(),1,11),'Primer Libro','Uno',1,'book',0,1),
					('Espanol',substring(now(),1,11),'Segundo Libro','Dos',1,'book',0,2),
					('Italiano',substring(now(),1,11),'Tercer Libro','Tres',2,'book',1,1),
					('Ingles',substring(now(),1,11),'Cuarto Libro','Cuatro',2,'book',1,2),
                    ('Ingles',substring(now(),1,11),'A Libro','A',1,'book',0),
					('Espanol',substring(now(),1,11),'B Libro','B',1,'book',0),
					('Italiano',substring(now(),1,11),'T Libro','T',2,'book',1),
					('Ingles',substring(now(),1,11),'C Libro','C',2,'book',1),
					('Espanol','2022-06-01','Quinto Libro','Cinco',2,'book',0);
                    
insert into biblioteca (usuario_id,libro_id,estado) values 
					(1,1,'Nuevo'),(1,2,'Pausa'),(1,3,'Progreso'),(1,4,'Terminado'),(1,5,'Dejado');
                    
insert into genero (id,genero) values 
					(1,'Fantasia'),(2,'CienciaFiccion'),(3,'Suspenso'),(4,'Romance'),(5,'Infantil'),(6,'Crimen');   
                    
insert into generolibro (genero_id,libro_id) values 
					(1,1),(2,1),(3,2),(6,2),(5,3),(4,4),(5,4),(6,4),(5,5),(2,5),(1,5); 
                    

	
