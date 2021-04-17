SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `hoteleria` DEFAULT CHARACTER SET utf8 ;
USE `hoteleria` ;

-- -----------------------------------------------------
-- Table `hoteleria`.`tbl_piso_hotel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteleria`.`tbl_piso_hotel` (
  `PK_numero_piso` INT NOT NULL,
  `cantidad_habitaciones` INT NULL DEFAULT NULL,
  `descripcion_piso` VARCHAR(200) NULL DEFAULT NULL,
  `estado_piso` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`PK_numero_piso`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
INSERT INTO `hoteleria`.`tbl_piso_hotel` (`PK_numero_piso`, `cantidad_habitaciones`, `descripcion_piso`, `estado_piso`) VALUES ('1', '10', 'Habitaciones pequeñas', '1');

-- -----------------------------------------------------
-- Table `hoteleria`.`tbl_ama_de_llaves`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteleria`.`tbl_ama_de_llaves` (
  `PK_id_ama_de_llaves` INT NOT NULL,
  `nombre_ama_de_llaves` VARCHAR(45) NULL DEFAULT NULL,
  `apellido_ama_de_llaves` VARCHAR(45) NULL DEFAULT NULL,
  `piso_ama_de_llaves` INT NULL DEFAULT NULL,
  `entrada_ama_de_llaves` VARCHAR(10) NULL DEFAULT NULL,
  `salida_ama_de_llaves` VARCHAR(10) NULL DEFAULT NULL,
  `inicio_labores_ama_de_llaves` VARCHAR(20) NULL DEFAULT NULL,
  `descripcion_ama_de_llaves` VARCHAR(200) NULL DEFAULT NULL,
  `estado_ama_de_llaves` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`PK_id_ama_de_llaves`),
  FOREIGN KEY (`piso_ama_de_llaves`) REFERENCES `tbl_piso_hotel`(`PK_numero_piso`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
INSERT INTO `hoteleria`.`tbl_ama_de_llaves` (`PK_id_ama_de_llaves`, `nombre_ama_de_llaves`, `apellido_ama_de_llaves`, `piso_ama_de_llaves`, `entrada_ama_de_llaves`, `salida_ama_de_llaves`, `inicio_labores_ama_de_llaves`, `descripcion_ama_de_llaves`, `estado_ama_de_llaves`) VALUES ('1', 'Carmen', 'Dominguez', '1', '8am', '8pm', '15/04/2021', 'Encargada del área', '1');

-- -----------------------------------------------------
-- Table `hoteleria`.`tbl_mantenimiento_habitaciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteleria`.`tbl_mantenimiento_habitaciones` (
  `PK_id_habitacion` INT NOT NULL,
  `descripcion_habitacion` VARCHAR(45) NULL DEFAULT NULL,
  `precio_habitacion` int(45) NULL DEFAULT NULL,
  `piso_habitaciones` INT NULL DEFAULT NULL,
  `estado_habitacion` INT NULL DEFAULT NULL,
  `tipo_de_habitacion` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`PK_id_habitacion`),
  FOREIGN KEY (`piso_habitaciones`) REFERENCES `tbl_piso_hotel`(`PK_numero_piso`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
INSERT INTO `hoteleria`.`tbl_mantenimiento_habitaciones` (`PK_id_habitacion`, `descripcion_habitacion`, `precio_habitacion`, `piso_habitaciones`, `estado_habitacion`, `tipo_de_habitacion`) VALUES ('1', 'Habitación Grande', '250', '1', '1', 'Matrimonial');

-- -----------------------------------------------------
-- Table `hoteleria`.`tbl_metodos_de_pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteleria`.`tbl_metodos_de_pago` (
  `PK_id_metodo` INT NOT NULL,
  `nombre_metodo` VARCHAR(50) NULL DEFAULT NULL,
  `descripcion_metodo` VARCHAR(100) NULL DEFAULT NULL,
  `estado_metodo` TINYINT NULL DEFAULT NULL,
   PRIMARY KEY (`PK_id_metodo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
INSERT INTO `hoteleria`.`tbl_metodos_de_pago` (`PK_id_metodo`, `nombre_metodo`, `descripcion_metodo`, `estado_metodo`) VALUES ('1', 'Tarjeta', 'Pago con tarjeta', '1');

-- -----------------------------------------------------
-- Table `hoteleria`.`tbl_huespedes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteleria`.`tbl_huespedes` (
  `PK_no_identificacion` INT NOT NULL,
  `nombre_huesped` VARCHAR(50) NULL DEFAULT NULL,
  `apellido_huesped` VARCHAR(100) NULL DEFAULT NULL,
  `nacionalidad_huesped` VARCHAR(100) NULL DEFAULT NULL,
  `direccion_huesped` VARCHAR(100) NULL DEFAULT NULL,
  `frecuencia_huesped` VARCHAR(100) NULL DEFAULT NULL,
  `telefono_huesped` VARCHAR(100) NULL DEFAULT NULL,
  `nit_huesped` VARCHAR(100) NULL DEFAULT NULL,
   PRIMARY KEY (`PK_no_identificacion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
INSERT INTO `hoteleria`.`tbl_huespedes` (`PK_no_identificacion`, `nombre_huesped`, `apellido_huesped`, `nacionalidad_huesped`, `direccion_huesped`, `frecuencia_huesped`, `telefono_huesped`, `nit_huesped`) VALUES ('1', 'Alberto', 'Suarez', 'Mexicano', '12 calle', 'Constante', '12345678', '87654321');

-- -----------------------------------------------------
-- Table `hoteleria`.`tbl_servicios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteleria`.`tbl_servicios` (
 `PK_id_servicio` INT NOT NULL,
  `nombre_servicio` VARCHAR(50) NULL DEFAULT NULL,
  `descripcion_servicio` VARCHAR(100) NULL DEFAULT NULL,
  `tipo_servicio` TINYINT NULL DEFAULT NULL,
  `estado_servicio` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`PK_id_servicio`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
INSERT INTO `hoteleria`.`tbl_servicios` (`PK_id_servicio`, `nombre_servicio`, `descripcion_servicio`, `tipo_servicio`, `estado_servicio`) VALUES ('1', 'Internet', '50mg', '1', '1');

-- -----------------------------------------------------
-- Table `hoteleria`.`tbl_reservaciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteleria`.`tbl_reservaciones` (
  `PK_id_reservacion` INT NOT NULL,
  `PK_DPI` INT DEFAULT NULL,
  `PK_id_trabajado` INT DEFAULT NULL,
  `PK_id_habitacion` INT DEFAULT NULL,
  `fecha_reserva` date NULL DEFAULT NULL,
  `desde` date NULL DEFAULT NULL,
  `hasta` date NULL DEFAULT NULL,
  PRIMARY KEY (`PK_id_reservacion`),
  FOREIGN KEY (`PK_id_habitacion`) REFERENCES `tbl_mantenimiento_habitaciones`(`PK_id_habitacion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hoteleria`.`tbl_metodo_pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteleria`.`tbl_metodo_pago` (
  `PK_id_transaccion` INT NOT NULL AUTO_INCREMENT,
  `tipo_pago` VARCHAR(20) NULL DEFAULT NULL,
  `dpi` INT(20) NULL DEFAULT NULL,
  `no_tarjeta` INT(20) NULL DEFAULT NULL,
  `precio_pagar` INT(45) NULL DEFAULT NULL,
  `precio_pagado` INT(45) NULL DEFAULT NULL,
  PRIMARY KEY (`PK_id_transaccion`),
  FOREIGN KEY (`PK_id_transaccion`) REFERENCES `tbl_reservaciones`(`PK_id_reservacion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;