-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `finanzas` DEFAULT CHARACTER SET utf8 ;
USE `finanzas` ;


-- -----------------------------------------------------

-- Table `finanzas`.`ClasificacionCuenta`

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `finanzas`.`ClasificacionCuenta` (

  `Codigo_clasificacion` VARCHAR(100),

  `Clasificacion_CuentaNombre` VARCHAR(100),

  `Descripcion_Clasificacion` VARCHAR(100),

  PRIMARY KEY (`Codigo_clasificacion`))

  ENGINE = InnoDB 

  CHARACTER SET = utf8;



-- -----------------------------------------------------

-- Table `finanzas`.`CuentaContable`

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `finanzas`.`CuentaContable` (

  `Codigo_CuentaContable` VARCHAR(100),

  `Nombre_CuentaContable` VARCHAR(100),

  `Clasificacion_CuentaContable` VARCHAR(100),

  `Estado_CentaContable` VARCHAR(100),

   `Monto_CuentaContable` VARCHAR(100),

  PRIMARY KEY (`Codigo_CuentaContable`),

  	CONSTRAINT `fkCuentaContableClasificacionCuenta1`

      FOREIGN KEY (`Clasificacion_CuentaContable`)

    REFERENCES `finanzas`.`ClasificacionCuenta` (`Codigo_clasificacion`))

ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8;





-- -----------------------------------------------------

-- Table `finanzas`.`Moneda`

-- -----------------------------------------------------



CREATE TABLE IF NOT EXISTS `finanzas`.`Moneda` (

`Codigo_Moneda` VARCHAR(100)NOT NULL,

  `Nombre_Moneda` VARCHAR(100)NOT NULL,

  `Simbolo_Moneda` VARCHAR(100)NOT NULL,

  PRIMARY KEY (`Codigo_Moneda` ))

ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8;





-- -----------------------------------------------------

-- Table `finanzas`.`EncabezadoAsientoContable`

-- -----------------------------------------------------



CREATE TABLE IF NOT EXISTS `finanzas`.`EncabezadoAsientoContable` (

`Codigo_EncabezadoAsiento` VARCHAR(100)NOT NULL,

  `Fecha_AsientoContable` VARCHAR(100)NOT NULL,

  `Moneda_Asiento` VARCHAR(100)NOT NULL,

  `Descripcion_Asiento` VARCHAR(100)NOT NULL,

  PRIMARY KEY (`Codigo_EncabezadoAsiento` ),

  CONSTRAINT `fkEncabezadoAsientoContableMoneda1`

   FOREIGN KEY (`Moneda_Asiento`)

    REFERENCES `finanzas`.`Moneda` (`Codigo_Moneda`))

ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8;



-- -----------------------------------------------------

-- Table `finanzas`.`PeriodoFiscal`

-- -----------------------------------------------------



CREATE TABLE IF NOT EXISTS `finanzas`.`PeriodoFiscal` (

`Codigo_PeriodoFiscal` VARCHAR(100)NOT NULL,

  `Fecha_inicioPF` VARCHAR(100)NOT NULL,
  
  `Fecha_finPF` VARCHAR(100)NOT NULL,

  `Estado_PeriodoFiscal` VARCHAR(100)NOT NULL,

  PRIMARY KEY (`Codigo_PeriodoFiscal` ))

ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8;



-- -----------------------------------------------------

-- Table `finanzas`.`PartidaContable`

-- -----------------------------------------------------





CREATE TABLE IF NOT EXISTS `finanzas`.`PartidaContable` (

  `Codigo_PartidaContable` VARCHAR(100)NOT NULL,

  `Fecha_PartidaContable` VARCHAR(100)NOT NULL,

  `Periodo_FiscalPartida` VARCHAR(100)NOT NULL,

  `Glosa_PartidaContable` VARCHAR(100)NOT NULL,

   `Monto_DeCuddre` VARCHAR(100)NOT NULL,

  PRIMARY KEY (`Codigo_PartidaContable`),

    CONSTRAINT `fkPartida_ContablePeriodoFiscal1`

   FOREIGN KEY (`Periodo_FiscalPartida`)

    REFERENCES `finanzas`.`PeriodoFiscal` (`Codigo_PeriodoFiscal`))

ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8;



-- -----------------------------------------------------

-- Table `finanzas`.`Tipo_Asiento`

-- -----------------------------------------------------





CREATE TABLE IF NOT EXISTS `finanzas`.`Tipo_Asiento` (

  `Codigo_TipoAsiento` VARCHAR(100)NOT NULL,

  `Tipo_AsientoDesc` VARCHAR(100)NOT NULL,

  PRIMARY KEY (`Codigo_TipoAsiento`))

ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8;



-- -----------------------------------------------------

-- Table `finanzas`.`AsientoContableDetalle`

-- -----------------------------------------------------







CREATE TABLE IF NOT EXISTS `finanzas`.`AsientoContableDetalle` (

  `Codigo_DetalleAsiento` VARCHAR(100)NOT NULL,

  `CuentaContable_Asiento` VARCHAR(100)NOT NULL,

  `Partida_Asiento` VARCHAR(100)NOT NULL,

  `Encabezado_Asiento` VARCHAR(100)NOT NULL,

   `Tipo_Asiento` VARCHAR(100)NOT NULL,

    `Monto_Debe` VARCHAR(100)NOT NULL,

     `Monto_Haber` VARCHAR(100)NOT NULL,

  PRIMARY KEY (`Codigo_DetalleAsiento`),

    CONSTRAINT `fkAsientoContableDetalleCuentaContable1`

   FOREIGN KEY (`CuentaContable_Asiento`)

    REFERENCES `finanzas`.`CuentaContable` (`Codigo_CuentaContable`),

    CONSTRAINT `fkAsientoContableDetallePartidaContable1`

   FOREIGN KEY (`Partida_Asiento`)

    REFERENCES `finanzas`.`PartidaContable` (`Codigo_PartidaContable`),

     CONSTRAINT `fkAsientoContableDetalleEncabezadoAsientoContable1`

   FOREIGN KEY (`Encabezado_Asiento`)

    REFERENCES `finanzas`.`EncabezadoAsientoContable` (`Codigo_EncabezadoAsiento`),

CONSTRAINT `fkAsientoContableDetalleTipo_Asiento1`

   FOREIGN KEY (`Tipo_Asiento`)

    REFERENCES `finanzas`.`Tipo_Asiento` (`Codigo_TipoAsiento`))

ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8;



-- -----------------------------------------------------

-- Table `finanzas`.`TipoPersona`

-- -----------------------------------------------------





CREATE TABLE IF NOT EXISTS `finanzas`.`TipoPersona` (

  `Codigo_TipoPersona` VARCHAR(100)NOT NULL,

  `TipoPersona_Nombres` VARCHAR(100)NOT NULL,

  PRIMARY KEY (`Codigo_TipoPersona`))

ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8;



-- -----------------------------------------------------

-- Table `finanzas`.`CuentaHabiente`

-- -----------------------------------------------------





CREATE TABLE IF NOT EXISTS `finanzas`.`CuentaHabiente` (

  `Codigo_CuentaHabiente` VARCHAR(100)NOT NULL,

  `Nombre_CuentaHabiente` VARCHAR(100)NOT NULL,

    `ApellidoP_CuentaHabiente` VARCHAR(100)NOT NULL,

  `ApellidoM_CuentaHabiente` VARCHAR(100)NOT NULL,

    `TipoPersona_CuentaHabiente` VARCHAR(100)NOT NULL,

  PRIMARY KEY (`Codigo_CuentaHabiente`),

  	CONSTRAINT `fkCuentaHabienteTipoPersona1`

 FOREIGN KEY (`TipoPersona_CuentaHabiente`)

    REFERENCES `finanzas`.`TipoPersona` (`Codigo_TipoPersona`))

ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8;



-- -----------------------------------------------------

-- Table `finanzas`.`Banco`

-- -----------------------------------------------------



CREATE TABLE IF NOT EXISTS `finanzas`.`Banco` (

  `Codigo_Banco` VARCHAR(100)NOT NULL,

  `Nombre_Banco` VARCHAR(100)NOT NULL,

    `Clave_Banco` VARCHAR(100)NOT NULL,

  `Telefono_Banco` VARCHAR(100)NOT NULL,

  PRIMARY KEY (`Codigo_Banco`))

ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8;





-- -----------------------------------------------------

-- Table `finanzas`.`CuentaBancaria`

-- -----------------------------------------------------



CREATE TABLE IF NOT EXISTS `finanzas`.`CuentaBancaria` (

  `Numero_CuentaBancaria` VARCHAR(100)NOT NULL,

  `Moneda_Cuenta` VARCHAR(100)NOT NULL,

    `CuentaHabiente_Cuenta` VARCHAR(100)NOT NULL,

  `Banco_Cuenta` VARCHAR(100)NOT NULL,

  PRIMARY KEY (`Numero_CuentaBancaria`),

      CONSTRAINT `fkCuentaBancariaMoneda1`

   FOREIGN KEY (`Moneda_Cuenta`)

    REFERENCES `finanzas`.`Moneda` (`Codigo_Moneda`),

    CONSTRAINT `fkCuentaBancariaCuentaHabiente1`

   FOREIGN KEY (`CuentaHabiente_Cuenta`)

    REFERENCES `finanzas`.`CuentaHabiente` (`Codigo_CuentaHabiente`),

     CONSTRAINT `fkCuentaBancariaBanco1`

   FOREIGN KEY (`Banco_Cuenta`)

    REFERENCES `finanzas`.`Banco` (`Codigo_Banco`))

ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8;



-- -----------------------------------------------------

-- Table `finanzas`.`TipoTransaccion`

-- -----------------------------------------------------





CREATE TABLE IF NOT EXISTS `finanzas`.`TipoTransaccion` (

  `Codigo_TipoTransaccion` VARCHAR(100)NOT NULL,

  `Transaccion_Tipo` VARCHAR(100)NOT NULL,

  `Efecto_TipoTransaccion` INT NOT NULL,

  PRIMARY KEY (`Codigo_TipoTransaccion`))

ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8;



-- -----------------------------------------------------

-- Table `finanzas`.`TransaccionBancaria`

-- -----------------------------------------------------







CREATE TABLE IF NOT EXISTS `finanzas`.`TransaccionBancaria` (

  `Codigo_Transaccion` VARCHAR(100)NOT NULL,

   `Fecha_Transaccion` VARCHAR(100)NOT NULL,

   `Beneficiario` VARCHAR(100)NOT NULL,

  `Cuenta_Bancaria` VARCHAR(100)NOT NULL,

   `Tipo_Transaccion` VARCHAR(100)NOT NULL,

   `Monto_Transaccion` VARCHAR(100)NOT NULL,

   `Concepto_Transaccion` VARCHAR(100)NOT NULL,

  PRIMARY KEY (`Codigo_Transaccion`),

    CONSTRAINT `fkTransaccionBancariaCuentaBancaria1`

   FOREIGN KEY (`Cuenta_Bancaria`)

    REFERENCES `finanzas`.`CuentaBancaria` (`Numero_CuentaBancaria`),

    CONSTRAINT `fkTransaccionBancariaTipoTransaccion1`

   FOREIGN KEY (`Tipo_Transaccion`)

    REFERENCES `finanzas`.`TipoTransaccion` (`Codigo_TipoTransaccion`))

ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `finanzas`.`cheque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finanzas`. `cheque` (
  `Numero_Cheque` varchar(100) NOT NULL,
  `Fecha_Cheque` varchar(100) NOT NULL,
  `FK_Banco` varchar(100) NOT NULL,
  `FK_Cuenta` varchar(100) NOT NULL,
  `FK_Cuentahabiente` varchar(100) NOT NULL,
  `Monto_Cheque` varchar(100) NOT NULL,
  PRIMARY KEY (`Numero_Cheque`),
  CONSTRAINT `fkChequeBancoBanco1`
  FOREIGN KEY (`FK_Banco`)
  REFERENCES `finanzas`.`Banco` (`Codigo_Banco`),
  CONSTRAINT `fkChequeCuentaBancaria1`
  FOREIGN KEY (`FK_Cuenta`)
  REFERENCES `finanzas`.`CuentaBancaria` (`Numero_CuentaBancaria`),
  CONSTRAINT `fkChequeCuentaHabiente1`
   FOREIGN KEY (`FK_Cuentahabiente`)
    REFERENCES `finanzas`.`CuentaHabiente` (`Codigo_CuentaHabiente`)
  )
 ENGINE=InnoDB 
DEFAULT CHARSET=utf8;

INSERT INTO `clasificacioncuenta` (`Codigo_clasificacion`, `Clasificacion_CuentaNombre`, `Descripcion_Clasificacion`) VALUES
('A001', 'Activo Corriente', 'Activos que se movilizan en la empresa en un período menor o igual a un año.'),
('A002', 'Activo No Corriente', 'Activos que se movilizan en un período mayor a un año y menor a 3 años.'),
('C001', 'Resultados', 'Capital de la Empresa'),
('P001', 'Pasivo Corriente', 'Pasivos que se movilizan en un período menor a un año.'),
('P002', 'Pasivo No Corriente', 'Pasivos que circulan entre uno y tres años.');

