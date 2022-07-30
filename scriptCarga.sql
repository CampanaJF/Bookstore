/*drop database shelves;
esPremium - fecha de inscripcion - fecha de vencimiento
create schema shelves; */
use shelves;

delete from genero where id is not null;
delete from generolibro where id is not null;

insert into genero (id,genero) values 
					(1,'Fantasia'),
                    (2,'CienciaFiccion'),
                    (10,'Militar'),
                    (11,'Medieval'),
                    (12,'Historico'),
                    (3,'Suspenso'),
                    (4,'Drama'),
                    (5,'Psicologico'),
                    (6,'Misterio'),
                    (7,'Romance'),
                    (8,'Infantil'),
                    (9,'Crimen');
                    
insert into usuario (email,fechaRegistro,password) values
					('admin',now(),'admin'),
					('zero@nonary.com',now(),'Q'),
					('nanana@nanana.com',now(),'sana'),
					('pacofranco45@gmail.com',now(),'admin'),
					('jucampana@alumno.unlam.edu.ar','2022-07-01','admin');
                    
update usuario set nombre='Kaela' where usuario.id=1;
                    
insert into premium (fechaInicio,fechaFin,descripcion,precio) values
					  (now(),'2024-05-16','PremiumEscritor',200.00), /*Necesario para autor activo */
				      (now(),'2023-07-16','PremiumPlus',300.00);
                    
update usuario set premium_id=2,esPremium=true where usuario.id=2;
update usuario set premium_id=1,esPremium=true where usuario.id=3;

insert into autor (apellido,nombre,usuario_id,activo) values
				  ('Kurashki','June',2,true),
				  ('Tsu','Sana',3,true);

insert into autor(apellido,nombre,activo) values  ('Ichikawa','Haruko',false);

insert into serie (titulo) values ('El Brujero'),('Witcherer');

insert into serieautor (autor_id,serie_id) values (1,2),(2,1);

insert into libro (lenguaje,publicado,sinopsis,titulo,autor_id,portada,puntuacion) values
				  ('Ingles',now(),'In the distant future, a new life form called The Lustrous are born.
                  The 28 Lustrous must fight against the Lunarians who want to attack them and turn them into decorations',
                  'Houseki no Kuni',3,'hnk',9.0);
             
insert into libro (id,lenguaje,publicado,sinopsis,titulo,autor_id,portada,esPremium,serie_id) values
					(2,'Espanol',now(),'Segundo Libro','Dos',1,'book',0,2),
					(3,'Italiano',now(),'Tercer Libro','Tres',2,'book',1,1),
					(4,'Ingles',now(),'Cuarto Libro','Cuatro',2,'book',1,2),
                    (5,'Ingles',now(),'A Libro','A',1,'book',0,null),
					(6,'Espanol',now(),'B Libro','B',1,'book',0,null),
					(7,'Italiano',now(),'T Libro','T',2,'book',1,null),
					(8,'Ingles',now(),'C Libro','C',2,'book',1,null),
					(9,'Espanol','2022-06-01','Quinto Libro','Cinco',2,'book',0,null);

insert into biblioteca (usuario_id,libro_id,estado) values 
						(1,1,'Nuevo'),
						(1,2,'Pausa'),
						(1,3,'Progreso'),
						(1,4,'Terminado'),
						(1,5,'Dejado');
 
 update biblioteca set puntuacion=9.0 where usuario_id=1;
  
insert into generolibro (genero_id,libro_id) values 
					(1,1),(2,1),(3,2),(6,2),(5,3),(4,4),(5,4),(6,4),(5,5),(2,5),(1,5),
                    (12,1),(6,1),(11,2),(10,2),(7,3),(7,4),(8,4),(9,4),(11,5),(12,5),(10,5); 
                    
                    
insert into resenia (publicado,puntuacion,resenia,creador_id,libro_id) values
					(now(),9.99,'I love this series to the ends of the Earth, and thats
                    exactly where it will take you. Please consider giving it a read!',1,1);                    

select * from generolibro;	
select * from resenia;