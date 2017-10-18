
CREATE SCHEMA IF NOT EXISTS `lego` DEFAULT CHARACTER SET latin1 ;
USE `lego` ;

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `lego`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(90) NOT NULL UNIQUE,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(20) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `lego`.`orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `length` INT NOT NULL,
  `width` INT NOT NULL,
  `height` INT NOT NULL,
  `date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `shipped` TINYINT NOT NULL,
  `shipping_date` DATETIME,
  PRIMARY KEY (`id`, `user_id`),
  INDEX `fk_order_user_idx` (`user_id` ASC),
  CONSTRAINT `fk_order_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `lego`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

LOCK TABLES `users` WRITE;
INSERT INTO `users` VALUES 
(1,'klods@hans.dk','klodset','customer'),
(2,'house@keeper.com','shipper','employee');
UNLOCK TABLES;




