
-- Integrantes: Abuzaid - Astorga - Marconi

-- MOTOR BASES DE DATOS MySQL

-- DATABASE: inmoapp_development

CREATE DATABASE /*!32312 IF NOT EXISTS*/ inmoapp_development;

DROP TABLE IF EXISTS users; -- Usuarios
CREATE TABLE users(
    id_user  INT(11) NOT NULL AUTO_INCREMENT,
    email VARCHAR(60),
    first_name VARCHAR(56),
    last_name VARCHAR(56),
  CONSTRAINT pk_users PRIMARY KEY (id_user)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS citys; -- Ciudades
CREATE TABLE citys(
    id_city INT(20) NOT NULL AUTO_INCREMENT,
    name VARCHAR (20) NOT NULL,  
  CONSTRAINT pk_citys PRIMARY KEY (id_city) 
);
	
DROP TABLE IF EXISTS realstates; -- Inmobiliarias
CREATE TABLE realstates(
	id_realstate INT(20) NOT NULL AUTO_INCREMENT,
	name VARCHAR(30),
	id_city INT(20),
	neighborhood VARCHAR(30) DEFAULT NULL,
	street VARCHAR(30) DEFAULT NULL,
 	n_street INT (10) DEFAULT NULL,
	phone INT(15) DEFAULT NULL,
	email VARCHAR(60),
	site_web VARCHAR(25),
  CONSTRAINT pk_realstate PRIMARY KEY (id_realstate),
  CONSTRAINT fk_realstates_citys FOREIGN KEY (id_city) REFERENCES citys (id_city) ON DELETE CASCADE
);

DROP TABLE IF EXISTS owners; -- Dueños
CREATE TABLE owners(
    id_owner INT(20) NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(56),
    last_name VARCHAR(56),
    id_city INT (20),
    neighborhood VARCHAR(30) DEFAULT NULL,
    street VARCHAR(30) DEFAULT NULL,
    n_street INT (10) DEFAULT NULL,
    email VARCHAR(60),
  CONSTRAINT pk_owners PRIMARY KEY (id_owner),
  CONSTRAINT fk_owners_citys FOREIGN KEY (id_city) REFERENCES citys (id_city) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS buildings; -- Inmuebles
CREATE TABLE buildings(
    id_building INT(11) NOT NULL AUTO_INCREMENT,
    type ENUM('land','farm','house','garage'),
    id_owner INT(20),
    id_city INT(20),
    neighborhood VARCHAR(30) DEFAULT NULL,
    street VARCHAR(30) DEFAULT NULL,
    n_street INT (10) DEFAULT NULL,
    description VARCHAR(200),
    price FLOAT(10), 
    operation ENUM('venta','alquiler'),
  CONSTRAINT pk_buildings PRIMARY KEY (id_building),
  CONSTRAINT fk_buildings_citys FOREIGN KEY (id_city) REFERENCES citys (id_city) ON DELETE CASCADE,
  CONSTRAINT fk_buildings_owners FOREIGN KEY (id_owner) REFERENCES owners (id_owner) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO citys (name)
	VALUES  ('Rio Cuarto'),
			('Achiras'),
			('Alcira Gigena'),
			('Ucacha');

