
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
  CONSTRAINT pk_users PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS cities; -- Ciudades
CREATE TABLE cities(
    id INT(20) NOT NULL AUTO_INCREMENT,
    name VARCHAR (20) NOT NULL,  
  CONSTRAINT pk_cities PRIMARY KEY (id) 
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
  CONSTRAINT pk_real_states PRIMARY KEY (id)
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
  CONSTRAINT pk_owners PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  CONSTRAINT pk_buildings PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS building_real_estates; -- Relacion entre Inmuebles e Inmobiliaria
CREATE TABLE building_real_estates(
	id INT(11) NOT NULL AUTO_INCREMENT,
	building_id INT(11),
	real_estates_id INT(11),
  CONSTRAINT pk_have PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO cities (name)
	VALUES  ('Rio Cuarto'),
			('Achiras'),
			('Alcira Gigena'),
			('Ucacha');

