
-- MOTOR BASES DE DATOS MySQL

-- DATABASE: inmoapp_development

CREATE DATABASE inmoapp_development;

DROP TABLE IF EXISTS users;
CREATE TABLE users(
    id_users  INT(11) NOT NULL AUTO_INCREMENT,
    email VARCHAR(60),
    first_name VARCHAR(56),
    last_name VARCHAR(56),
    CONSTRAINT pk_users PRIMARY KEY (id_users)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS city; -- Inmobiliarias
CREATE TABLE city(
    id_city INT(20) NOT NULL AUTO_INCREMENT;
    name VARCHAR (20) NOT NULL  
);

DROP TABLE IF EXISTS realstates; -- Inmobiliarias
CREATE TABLE realstates(
	id_realstate INT(20) NOT NULL AUTO_INCREMENT,
	name VARCHAR(30) NOT NULL,
	city VARCHAR (30),
	neighborhood VARCHAR(30) default NULL,
	street VARCHAR(30) default NULL,
 	n_street INT (10) default NULL,
	phone INT(15) default NULL,
	email VARCHAR(60),
	site_web VARCHAR(25),
	owners INT(20) NOT NULL,   
        CONSTRAINT pk_realstate PRIMARY KEY (id_realstate),
 	CONSTRAINT fk_realstate_owners FOREIGN KEY (owners) REFERENCES owners (id_owners),
 	CONSTRAINT fk_realstate_citys FOREIGN KEY (city) REFERENCES citys (city)
);

DROP TABLE IF EXISTS owners; -- Dueños
CREATE TABLE owners(
    id_owners INT(20) NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    city VARCHAR (30),
    neighborhood VARCHAR(30) default NULL,
    street VARCHAR(30) default NULL,
    n_street INT (10) default NULL,
    email VARCHAR(60),
    realstate INT(20) NOT NULL,
    CONSTRAINT pk_owners PRIMARY KEY (id_owners),
 	CONSTRAINT fk_realstate_citys FOREIGN KEY (city) REFERENCES citys (city),
    CONSTRAINT fk_owners_inmobb FOREIGN KEY (realstate) REFERENCES realstates (id_realstate)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS buildings; -- Inmuebles
CREATE TABLE buildings(
    id_buildings  INT(11) NOT NULL AUTO_INCREMENT,
    type ENUM('land','farm','house','garage'),
    owners INT(20) NOT NULL,
    city VARCHAR (30),
    neighborhood VARCHAR(30) default NULL,
    street VARCHAR(30) default NULL,
    n_street INT (10) default NULL,
    description VARCHAR(200),
    price INT(10), --Puede ser FLOAT?
    operation ENUM('venta','alquiler'),
    CONSTRAINT pk_buildings PRIMARY KEY (id_buildings),
    CONSTRAINT fk_realstate_citys FOREIGN KEY (city) REFERENCES citys (city),
    CONSTRAINT fk_buildings_owners FOREIGN KEY (owners) REFERENCES owners (id_owners)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;
