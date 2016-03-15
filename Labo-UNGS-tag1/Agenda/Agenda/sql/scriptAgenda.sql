CREATE DATABASE `agenda`;
USE agenda;
CREATE TABLE `localidad` 
(
  `idLocalidad` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idLocalidad`)
);

USE agenda;
CREATE TABLE `tipoContacto` 
(
  `idTipo` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idTipo`)
);

USE agenda;
CREATE TABLE `personas` 
(
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Telefono` varchar(20) NOT NULL,
  `Calle` varchar(45) NOT NULL,
  `Altura` int(11) NOT NULL,
  `Piso` int(11) NOT NULL,
  `Depto` int(11) NOT NULL,
  `Localidad` int(11) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Cumpleaños` varchar(45) NOT NULL,
  `TipoDeContacto` int(11) NOT NULL,  
  PRIMARY KEY (`idPersona`),
  FOREIGN KEY (`Localidad`) REFERENCES localidad (`idLocalidad`),
  FOREIGN KEY (`TipoDeContacto`) REFERENCES tipoContacto (`idTipo`)
);
