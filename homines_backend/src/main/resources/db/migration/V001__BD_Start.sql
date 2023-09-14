-- MySQL Script generated by MySQL Workbench
-- Wed Sep 13 17:51:07 2023
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
-- Table `homines`.`career`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `homines`.`career` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `career` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `homines`.`class`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `homines`.`class` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `classes` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `homines`.`stand`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `homines`.`stand` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `stand` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `homines`.`post`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `homines`.`post` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `post` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `homines`.`sector`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `homines`.`sector` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `sector` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `homines`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `homines`.`employee` (
  `id` BIGINT(60) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `rg` VARCHAR(45) NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `birthday` DATE NULL,
  `email` VARCHAR(45) NULL,
  `personal_email` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `siape` VARCHAR(60) NOT NULL,
  `functions` VARCHAR(45) NULL,
  `degree` VARCHAR(45) NULL,
  `entry_date` DATE NULL,
  `departure_date` DATE NULL,
  `substitute_of` VARCHAR(45) NULL,
  `frequency` VARCHAR(45) NULL,
  `active` TINYINT NOT NULL,
  `career_id` BIGINT NOT NULL,
  `classes_id` BIGINT NOT NULL,
  `stand_id` BIGINT NOT NULL,
  `post_id` BIGINT NOT NULL,
  `sector_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`, `career_id`, `classes_id`, `stand_id`, `post_id`, `sector_id`),
  INDEX `fk_employee_career1_idx` (`career_id` ASC) VISIBLE,
  INDEX `fk_employee_class1_idx` (`classes_id` ASC) VISIBLE,
  INDEX `fk_employee_stand1_idx` (`stand_id` ASC) VISIBLE,
  INDEX `fk_employee_post1_idx` (`post_id` ASC) VISIBLE,
  INDEX `fk_employee_sector1_idx` (`sector_id` ASC) VISIBLE,
  CONSTRAINT `fk_employee_career1`
    FOREIGN KEY (`career_id`)
    REFERENCES `homines`.`career` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_employee_class1`
    FOREIGN KEY (`classes_id`)
    REFERENCES `homines`.`class` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_employee_stand1`
    FOREIGN KEY (`stand_id`)
    REFERENCES `homines`.`stand` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_employee_post1`
    FOREIGN KEY (`post_id`)
    REFERENCES `homines`.`post` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_employee_sector1`
    FOREIGN KEY (`sector_id`)
    REFERENCES `homines`.`sector` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `homines`.`vacation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `homines`.`vacation` (
  `id` BIGINT(60) NOT NULL AUTO_INCREMENT,
  `year` INT NOT NULL,
  `first_period_date_begin` DATE NULL,
  `first_period_date_end` DATE NULL,
  `second_period_date_begin` DATE NULL,
  `second_period_date_end` DATE NULL,
  `third_period_date_begin` DATE NULL,
  `third_period_date_end` DATE NULL,
  `employee_id` BIGINT(60) NOT NULL,
  PRIMARY KEY (`id`, `employee_id`),
  INDEX `fk_vacation_server_idx` (`employee_id` ASC) VISIBLE,
  CONSTRAINT `fk_vacation_server`
    FOREIGN KEY (`employee_id`)
    REFERENCES `homines`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `homines`.`ordinance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `homines`.`ordinance` (
  `id` BIGINT(60) NOT NULL,
  `date` DATE NULL,
  `ordinance` VARCHAR(45) NULL,
  `subject` VARCHAR(45) NOT NULL,
  `post` VARCHAR(45) NULL,
  `employee_id` BIGINT(60) NOT NULL,
  PRIMARY KEY (`id`, `employee_id`),
  INDEX `fk_ordinance_server1_idx` (`employee_id` ASC) VISIBLE,
  CONSTRAINT `fk_ordinance_server1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `homines`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `homines`.`probationary_stage`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `homines`.`probationary_stage` (
  `id` BIGINT(60) NOT NULL AUTO_INCREMENT,
  `first_avaliation_date_begin` DATE NULL,
  `first_avaliation_date_end` DATE NULL,
  `second_avaliation_date_begin` DATE NULL,
  `second_avaliation_date_end` DATE NULL,
  `third_avaliation_date_begin` DATE NULL,
  `third_avaliation_date_end` DATE NULL,
  `employee_id` BIGINT(60) NOT NULL,
  PRIMARY KEY (`id`, `employee_id`),
  INDEX `fk_probationary_stage_employee1_idx` (`employee_id` ASC) VISIBLE,
  CONSTRAINT `fk_probationary_stage_employee1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `homines`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `homines`.`progression`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `homines`.`progression` (
  `id` BIGINT(60) NOT NULL AUTO_INCREMENT,
  `actual_level` VARCHAR(45) NULL,
  `next_level` VARCHAR(45) NULL,
  `last_progression_date` DATE NULL,
  `next_progression_date` DATE NULL,
  `progression_month` VARCHAR(45) NOT NULL,
  `employee_id` BIGINT(60) NOT NULL,
  PRIMARY KEY (`id`, `employee_id`),
  INDEX `fk_progression_employee1_idx` (`employee_id` ASC) VISIBLE,
  CONSTRAINT `fk_progression_employee1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `homines`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `homines`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `homines`.`user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `user` VARCHAR(45) NOT NULL,
  `password` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
