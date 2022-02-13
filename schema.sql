-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema csedconnections
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema csedconnections
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `csedconnections` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `csedconnections` ;

-- -----------------------------------------------------
-- Table `csedconnections`.`graduate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `csedconnections`.`graduate` (
  `email` VARCHAR(45) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `Bdate` VARCHAR(45) NULL DEFAULT NULL,
  `gender` VARCHAR(6) NULL DEFAULT NULL,
  `phone` VARCHAR(14) NULL DEFAULT NULL,
  `password` VARCHAR(30) NOT NULL,
  `imageURL` VARCHAR(500) NULL DEFAULT NULL,
  `about` VARCHAR(300) NULL DEFAULT NULL,
  `grad_year` YEAR(4) NULL DEFAULT NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `csedconnections`.`experience`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `csedconnections`.`experience` (
  `email` VARCHAR(45) NOT NULL,
  `company` VARCHAR(30) NULL DEFAULT NULL,
  `location` VARCHAR(45) NULL DEFAULT NULL,
  `position` VARCHAR(30) NULL DEFAULT NULL,
  `start_date` VARCHAR(45) NULL DEFAULT NULL,
  `end_date` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`email`),
  CONSTRAINT `email`
    FOREIGN KEY (`email`)
    REFERENCES `csedconnections`.`graduate` (`email`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `csedconnections`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `csedconnections`.`student` (
  `email` VARCHAR(45) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `Bdate` VARCHAR(45) NULL DEFAULT NULL,
  `gender` VARCHAR(6) NULL DEFAULT NULL,
  `phone` VARCHAR(14) NULL DEFAULT NULL,
  `password` VARCHAR(30) NOT NULL,
  `imageURL` VARCHAR(100) NULL DEFAULT NULL,
  `about` VARCHAR(300) NULL DEFAULT NULL,
  `current_level` INT(11) NULL DEFAULT NULL,
  `expected_grad_year` VARCHAR(4) NULL DEFAULT NULL,
  PRIMARY KEY (`email`),
  UNIQUE INDEX `phone_UNIQUE` (`phone` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `csedconnections`.`posts`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `csedconnections`.`posts` (
  `email` VARCHAR(200) NOT NULL,
  `name` VARCHAR(200) NOT NULL,
  `post` VARCHAR(10000) NOT NULL,

  CONSTRAINT `posts_ibfk_1`
    FOREIGN KEY (`email`)
    REFERENCES `csedconnections`.`graduate` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
CREATE TABLE IF NOT EXISTS `csedconnections`.`sociallinks` (
  `email` VARCHAR(45) NOT NULL,
  `facebook` VARCHAR(200) NULL,
  `linkedin` VARCHAR(200) NULL,
  PRIMARY KEY (`email`),
FOREIGN KEY (`email`)
    REFERENCES `csedconnections`.`graduate` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
