-- Integrantes: Abuzaid - Astorga - Marconi

-- MOTOR BASES DE DATOS MySQL

-- DATABASE: inmoapp_development

CREATE DATABASE /*!32312 IF NOT EXISTS*/ inmoapp_development;

DROP TABLE IF EXISTS users; -- Usuarios
CREATE TABLE users(
    id INT(11) NOT NULL AUTO_INCREMENT,
    email VARCHAR(60),
    first_name VARCHAR(56),
    last_name VARCHAR(56),
  CONSTRAINT users_pk PRIMARY KEY (id)
);

DROP TABLE IF EXISTS cities; -- Ciudades
CREATE TABLE cities(
    id INT(20) NOT NULL AUTO_INCREMENT,
    name VARCHAR (35) NOT NULL UNIQUE,  
  CONSTRAINT cities_pk PRIMARY KEY (id) 
);
	
DROP TABLE IF EXISTS real_estates; -- Inmobiliarias
CREATE TABLE real_estates(
	id INT(20) NOT NULL AUTO_INCREMENT,
	name VARCHAR(30),
	city_id INT(20),
	neighborhood VARCHAR(30) DEFAULT NULL,
	street VARCHAR(30) DEFAULT NULL,
 	n_street INT (10) DEFAULT NULL,
	phone INT(15) DEFAULT NULL,
	email VARCHAR(60),
	site_web VARCHAR(25),
  CONSTRAINT real_states_pk PRIMARY KEY (id)
);

DROP TABLE IF EXISTS owners; -- Dueños
CREATE TABLE owners(
    id INT(20) NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(56),
    last_name VARCHAR(56),
    city_id INT (20),
    neighborhood VARCHAR(30) DEFAULT NULL,
    street VARCHAR(30) DEFAULT NULL,
    n_street INT (10) DEFAULT NULL,
    email VARCHAR(60),
  CONSTRAINT owners_pk PRIMARY KEY (id)
);

DROP TABLE IF EXISTS buildings; -- Inmuebles
CREATE TABLE buildings(
    id INT(11) NOT NULL AUTO_INCREMENT,
    type ENUM('land','farm','house','garage'),
    owner_id INT(20),
    city_id INT(20),
    neighborhood VARCHAR(30) DEFAULT NULL,
    street VARCHAR(30) DEFAULT NULL,
    n_street INT (10) DEFAULT NULL,
    description VARCHAR(200),
    price FLOAT(10), 
    operation ENUM('venta','alquiler'),
  CONSTRAINT buildings_pk PRIMARY KEY (id)
);

DROP TABLE IF EXISTS building_real_estates; -- Relacion entre Inmuebles e Inmobiliaria
CREATE TABLE building_real_estates(
	id INT(11) NOT NULL AUTO_INCREMENT,
	building_id INT(11),
	real_estates_id INT(11),
  CONSTRAINT have_pk PRIMARY KEY (id)
);

INSERT INTO cities (name)
	VALUES  ('Buenos Aires'), 	
 	('Cordoba'), 	
 	('Rosario'), 	
 	('La Plata'), 	
 	('Mar del Plata'), 	
 	('San Miguel de Tucuman'), 	
 	('Salta'), 	 	
 	('Santa Fe'), 	
 	('Corrientes'), 
 	('Bahia Blanca'),
 	('Resistencia'), 
 	('Vicente Lopez'), 
 	('Posadas'), 	
 	('Merlo'), 	
 	('Parana'), 
 	('San Salvador de Jujuy'), 	
 	('Quilmes'), 	
 	('Santiago del Estero'), 	
 	('Pilar'), 	
 	('Banfield'), 
 	('Guaymallen'), 
 	('Jose C. Paz'),
 	('Lanus'), 	
 	('Neuquen'),
 	('Formosa'),
 	('Godoy Cruz'),
 	('Las Heras'), 
 	('Gregorio de Laferrere'), 	
 	('Berazategui'), 	
 	('Gonzalez Catan'), 	
 	('San Miguel'), 	
 	('San Luis'), 	
 	('Moreno'), 	
 	('Concordia'), 	
 	('La Rioja'), 	
	('San Nicolas de los Arroyos'), 
 	('Río Cuarto'), 		
 	('Comodoro Rivadavia'), 
 	('Isidro Casanova'), 
 	('San Rafael'), 	
 	('Ituzaingo'), 	
 	('Florencio Varela'), 	
 	('San Juan'), 	
	('Lomas de Zamora'),
 	('Temperley'), 	
 	('Mendoza'), 	
 	('Monte Grande'), 	
	('Berna'),	
 	('San Justo'), 	
 	('San Carlos de Bariloche'), 	
 	('Castelar'), 	
 	('Rafael Castillo'), 	
 	('Trelew'), 	
 	('Santa Rosa'), 	
 	('Tandil'), 	
 	('Libertad');
