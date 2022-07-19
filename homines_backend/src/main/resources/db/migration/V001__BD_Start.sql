-- MySQL Script generated by MySQL Workbench
-- Mon Jul 18 16:48:59 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema homines
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema homines
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `homines` DEFAULT CHARACTER SET utf8 ;
USE `homines` ;

-- -----------------------------------------------------
-- Table `homines`.`Servers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `homines`.`Servers` (
  `idServers` BIGINT(60) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `rg` VARCHAR(45) NULL,
  `cpf` VARCHAR(45) NULL,
  `birthday` DATETIME NULL,
  `email` VARCHAR(45) NULL,
  `personal_email` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `class` VARCHAR(45) NULL,
  `siape` INT NULL,
  `function` VARCHAR(45) NULL,
  `degree` VARCHAR(45) NULL,
  `vacation` VARCHAR(45) NULL,
  `stand` VARCHAR(45) NULL,
  `sector` VARCHAR(45) NULL,
  `entry_date` DATETIME NULL,
  `departure_date` DATETIME NULL,
  `substiture_of` VARCHAR(45) NULL,
  `post` VARCHAR(45) NULL,
  `ordinance` VARCHAR(45) NULL,
  `frequency` VARCHAR(45) NULL,
  `actual_level` VARCHAR(45) NULL,
  `next_level` VARCHAR(45) NULL,
  `last_progression_date` DATETIME NULL,
  `next_progression_date` DATETIME NULL,
  `progression_month` VARCHAR(45) NULL,
  `first_avaliation_date_begin` DATETIME NULL,
  `first_avaliation_date_end` DATETIME NULL,
  `second_avaliation_date_begin` DATETIME NULL,
  `second_avaliation_date_end` DATETIME NULL,
  `third_avaliation_date_begin` DATETIME NULL,
  `third_avaliation_date_end` DATETIME NULL,
  PRIMARY KEY (`idServers`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `homines`.`Vacations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `homines`.`Vacations` (
  `idVacations` BIGINT(60) NOT NULL AUTO_INCREMENT,
  `period1_date_begin` DATETIME NULL,
  `period1_date_end` DATETIME NULL,
  `period2_date_begin` DATETIME NULL,
  `period2_date_end` DATETIME NULL,
  `period3_date_begin` DATETIME NULL,
  `period3_date_end` DATETIME NULL,
  `Servers_idServers` BIGINT(60) NOT NULL,
  PRIMARY KEY (`idVacations`, `Servers_idServers`),
  INDEX `fk_Vacations_Servers1_idx` (`Servers_idServers` ASC) VISIBLE,
  CONSTRAINT `fk_Vacations_Servers1`
    FOREIGN KEY (`Servers_idServers`)
    REFERENCES `homines`.`Servers` (`idServers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `homines`.`Ordinances`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `homines`.`Ordinances` (
  `idOrdinances` BIGINT(60) NOT NULL AUTO_INCREMENT,
  `date` DATETIME NULL,
  `ordinance` VARCHAR(45) NULL,
  `subject` VARCHAR(45) NULL,
  `post` VARCHAR(45) NULL,
  `Servers_idServers` BIGINT(60) NOT NULL,
  PRIMARY KEY (`idOrdinances`, `Servers_idServers`),
  INDEX `fk_Ordinances_Servers1_idx` (`Servers_idServers` ASC) VISIBLE,
  CONSTRAINT `fk_Ordinances_Servers1`
    FOREIGN KEY (`Servers_idServers`)
    REFERENCES `homines`.`Servers` (`idServers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;