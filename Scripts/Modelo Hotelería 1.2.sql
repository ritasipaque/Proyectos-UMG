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

-- -----------------------------------------------------
-- Table `hoteleria`.`tbl_mantenimiento_habitaciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteleria`.`tbl_mantenimiento_habitaciones` (
  `PK_id_habitacion` INT NOT NULL,
  `descripcion_habitacion` VARCHAR(45) NULL DEFAULT NULL,
  `precio_habitacion` int(45) NULL DEFAULT NULL,
  `piso_habitaciones` INT NULL DEFAULT NULL,
  `estado_habitacion` VARCHAR(10) NULL DEFAULT NULL,
  `tipo_de_habitacion` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`PK_id_habitacion`),
  FOREIGN KEY (`piso_habitaciones`) REFERENCES `tbl_piso_hotel`(`PK_numero_piso`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

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