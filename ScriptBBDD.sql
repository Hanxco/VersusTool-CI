-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema versustools
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema versustools
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `versustools` DEFAULT CHARACTER SET utf8 ;
USE `versustools` ;

-- -----------------------------------------------------
-- Table `versustools`.`appdetail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `versustools`.`appdetail` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `appId` INT NOT NULL,
  `criteriaId` INT NOT NULL,
  `description` VARCHAR(5000) NULL DEFAULT NULL,
  `comments` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1538
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `versustools`.`application`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `versustools`.`application` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `type` INT NULL DEFAULT NULL,
  `description` VARCHAR(2500) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL,
  `link` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 30
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `versustools`.`criteria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `versustools`.`criteria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `key` VARCHAR(3) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL,
  `category` VARCHAR(45) NULL DEFAULT NULL,
  `subcategory` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL,
  `name` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL,
  `appId` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 265
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `versustools`.`peliculas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `versustools`.`peliculas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NULL DEFAULT NULL,
  `director` VARCHAR(45) NULL DEFAULT NULL,
  `genero` VARCHAR(45) NULL DEFAULT NULL,
  `year` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `versustools`.`tooltypes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `versustools`.`tooltypes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `developername` VARCHAR(45) NOT NULL,
  `label` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
