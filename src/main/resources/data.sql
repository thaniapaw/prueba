-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema r1-powell
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema r1-powell
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `r1-powell` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE `r1-powell` ;

-- -----------------------------------------------------
-- Table `r1-powell`.`accounts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `r1-powell`.`accounts` ;

CREATE TABLE IF NOT EXISTS `r1-powell`.`accounts` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `balance` FLOAT NULL DEFAULT NULL,
  `name` VARCHAR(50) NULL DEFAULT NULL,
  `status` BIT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;

INSERT INTO `accounts` (id, name, balance, status ) VALUES (1, 'Mateo Vargas', 500, true);
INSERT INTO `accounts` (id, name, balance, status ) VALUES (2, 'Maximiliano Villa', 1355.90, true);
INSERT INTO `accounts` (id, name, balance, status ) VALUES (3, 'Juan Torres', 750, true);
INSERT INTO `accounts` (id, name, balance, status ) VALUES (4, 'Pedro Lopez', 945, true);
INSERT INTO `accounts` (id, name, balance, status ) VALUES (5, 'Marta Valencia', 213, true);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
