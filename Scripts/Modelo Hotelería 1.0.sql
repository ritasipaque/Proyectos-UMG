SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `hoteleria` DEFAULT CHARACTER SET utf8 ;
USE `hoteleria` ;

-- -----------------------------------------------------
-- Table `hoteleria`.`tbl_ama_de_llaves`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteleria`.`tbl_ama_de_llaves` (
  `PK_id_ama_de_llaves` INT NOT NULL,
  `nombre_ama_de_llaves` VARCHAR(45) NULL DEFAULT NULL,
  `apellido_ama_de_llaves` VARCHAR(45) NULL DEFAULT NULL,
  `piso_ama_de_llaves` TINYINT NULL DEFAULT NULL,
  `entrada_ama_de_llaves` VARCHAR(10) NULL DEFAULT NULL,
  `salida_ama_de_llaves` VARCHAR(10) NULL DEFAULT NULL,
  `inicio_labores_ama_de_llaves` VARCHAR(20) NULL DEFAULT NULL,
  `descripcion_ama_de_llaves` VARCHAR(200) NULL DEFAULT NULL,
  `estado_ama_de_llaves` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`PK_id_ama_de_llaves`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;