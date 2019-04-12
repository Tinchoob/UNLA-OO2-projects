-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema bd-prestamos-cuotas-tp
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bd-prestamos-cuotas-tp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bd-prestamos-cuotas-tp` DEFAULT CHARACTER SET latin1 ;
USE `bd-prestamos-cuotas-tp` ;

-- -----------------------------------------------------
-- Table `bd-prestamos-cuotas-tp`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-prestamos-cuotas-tp`.`cliente` (
  `idCliente` INT(11) NOT NULL AUTO_INCREMENT,
  `apellido` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `dni` INT(11) NOT NULL,
  `fechaDeNacimiento` DATE NULL DEFAULT NULL,
  `baja` BIT(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd-prestamos-cuotas-tp`.`prestamo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-prestamos-cuotas-tp`.`prestamo` (
  `idPrestamo` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha` DATETIME NOT NULL,
  `monto` DOUBLE NOT NULL,
  `interes` DOUBLE NOT NULL,
  `cantCuotas` INT(11) NOT NULL,
  `idCliente` INT(11) NOT NULL,
  PRIMARY KEY (`idPrestamo`),
  INDEX `fkCliente_idx` (`idCliente` ASC),
  CONSTRAINT `fkCliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `bd-prestamos-cuotas-tp`.`cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd-prestamos-cuotas-tp`.`cuota`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-prestamos-cuotas-tp`.`cuota` (
  `idCuota` INT(11) NOT NULL AUTO_INCREMENT,
  `nroCuota` INT NOT NULL,
  `fechaVencimiento` DATE NOT NULL,
  `saldoPendiente` DOUBLE NULL,
  `amortizacion` DOUBLE NOT NULL,
  `interesCuota` DOUBLE NOT NULL,
  `cuota` DOUBLE NOT NULL,
  `deuda` DOUBLE NOT NULL,
  `cancelada` BIT(1) NOT NULL,
  `fechaDePago` DATE NOT NULL,
  `punitorios` DOUBLE NOT NULL,
  `idPrestamo` INT(11) NOT NULL,
  INDEX `fk_cuota_prestamo1_idx` (`idPrestamo` ASC),
  PRIMARY KEY (`idCuota`),
  CONSTRAINT `fk_cuota_prestamo1`
    FOREIGN KEY (`idPrestamo`)
    REFERENCES `bd-prestamos-cuotas-tp`.`prestamo` (`idPrestamo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
