CREATE DATABASE agenda;
USE agenda;
CREATE TABLE `localidad` 
(
  `idLocalidad` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idLocalidad`)
);

USE agenda;
CREATE TABLE `tipoContacto` 
(
  `idTipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idTipo`)
);

USE agenda;
CREATE TABLE `personas` 
(
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `calle` varchar(45) NOT NULL,
  `altura` int(11) NOT NULL,
  `piso` int(11) NOT NULL,
  `depto` int(11) NOT NULL,
  `localidad` int(11) NOT NULL,
  `email` varchar(45) NOT NULL,
  `cumpleaños` varchar(45) NOT NULL,
  `tipoContacto` int(11) NOT NULL,  
  PRIMARY KEY (`idPersona`),
  FOREIGN KEY (`localidad`) REFERENCES localidad (`idLocalidad`),
  FOREIGN KEY (`tipoContacto`) REFERENCES tipoContacto (`idTipo`)
);
