
-- MOTOR BASES DE DATOS MySQL

-- DATABASE: inmoapp_development

CREATE DATABASE /*!32312 IF NOT EXISTS*/ inmoapp_development;

DROP TABLE IF EXISTS users;
CREATE TABLE users(
  id_users  INT(11) NOT NULL AUTO_INCREMENT,
    email VARCHAR(60),
    first_name VARCHAR(56),
    last_name VARCHAR(56),
  CONSTRAINT pk_users PRIMARY KEY (id_users)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS inmob;
CREATE TABLE inmob(
	id_inmob INT(11) NOT NULL AUTO_INCREMENT,
	nam VARCHAR(30),
	adress ENUM('ciudad','barrio','calle'),
	tel INT(15),
	email VARCHAR(60),
	site_web VARCHAR(25),
	-- owners 
  CONSTRAINT pk_inmob PRIMARY KEY (id_inmob)
);

DROP TABLE IF EXISTS owners;
CREATE TABLE owners(
    id_owners INT(11) NOT NULL AUTO_INCREMENT,
    nam VARCHAR(20),
    adress ENUM('ciudad','barrio','calle'),
    email VARCHAR(60),
    id_inmob INT(11),  --
  CONSTRAINT pk_owners PRIMARY KEY (id_owners),
  CONSTRAINT fk_owners_inmobb FOREIGN KEY (id_inmob) REFERENCES inmob (id_inmob)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS buildings;
CREATE TABLE buildings(
    id_buildings  INT(11) NOT NULL AUTO_INCREMENT,
    typ ENUM('land','farm','house','garage'),
    id_owners INT(11),
    adress ENUM('ciudad','barrio','calle'),
    txt VARCHAR(200),
    price INT(10),
    v_a ENUM('venta','alquiler'),
  CONSTRAINT pk_buildings PRIMARY KEY (id_buildings),
  CONSTRAINT fk_buildings_owners FOREIGN KEY (id_owners) REFERENCES owners (id_owners)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;
