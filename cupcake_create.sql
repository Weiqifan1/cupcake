-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema cupcake
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cupcake
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cupcake` DEFAULT CHARACTER SET utf8 ;
USE `cupcake` ;

-- -----------------------------------------------------
-- Table `cupcake`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcake`.`users` (
  `user_id` INT NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `balance` DECIMAL UNSIGNED NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cupcake`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcake`.`orders` (
  `order_id` INT NOT NULL,
  `date` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `users_user_id` INT NOT NULL,
  PRIMARY KEY (`order_id`, `users_user_id`),
  INDEX `fk_orders_users1_idx` (`users_user_id` ASC),
  CONSTRAINT `fk_orders_users1`
    FOREIGN KEY (`users_user_id`)
    REFERENCES `cupcake`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cupcake`.`topping`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcake`.`topping` (
  `topping_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `price` INT UNSIGNED NULL,
  PRIMARY KEY (`topping_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cupcake`.`bottom`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcake`.`bottom` (
  `bottom_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `price` DECIMAL UNSIGNED NULL,
  PRIMARY KEY (`bottom_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cupcake`.`orderlines`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcake`.`orderlines` (
  `orderline_id` INT NOT NULL,
  `price` DECIMAL UNSIGNED NOT NULL,
  `topping_topping_id` INT NOT NULL,
  `bottom_bottom_id` INT NOT NULL,
  PRIMARY KEY (`orderline_id`, `topping_topping_id`, `bottom_bottom_id`),
  INDEX `fk_orderlines_topping_idx` (`topping_topping_id` ASC),
  INDEX `fk_orderlines_bottom1_idx` (`bottom_bottom_id` ASC),
  CONSTRAINT `fk_orderlines_topping`
    FOREIGN KEY (`topping_topping_id`)
    REFERENCES `cupcake`.`topping` (`topping_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orderlines_bottom1`
    FOREIGN KEY (`bottom_bottom_id`)
    REFERENCES `cupcake`.`bottom` (`bottom_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cupcake`.`orderdetails`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcake`.`orderdetails` (
  `orders_order_id` INT NOT NULL,
  `orderlines_orderline_id` INT NOT NULL,
  `quantity` INT NULL,
  PRIMARY KEY (`orders_order_id`, `orderlines_orderline_id`),
  INDEX `fk_orderdetails_orders1_idx` (`orders_order_id` ASC),
  CONSTRAINT `fk_orderdetails_orderlines1`
    FOREIGN KEY (`orderlines_orderline_id`)
    REFERENCES `cupcake`.`orderlines` (`orderline_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orderdetails_orders1`
    FOREIGN KEY (`orders_order_id`)
    REFERENCES `cupcake`.`orders` (`order_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
