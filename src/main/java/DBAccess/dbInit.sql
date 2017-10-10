CREATE SCHEMA IF NOT EXISTS `lego` DEFAULT CHARACTER SET latin1 ;
USE `lego` ;

CREATE TABLE IF NOT EXISTS `lego`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(90) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(20) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `lego`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `length` INT NOT NULL,
  `width` INT NOT NULL,
  `height` INT NOT NULL,
  `date` VARCHAR(45) NOT NULL,
  `shipped` TINYINT NOT NULL,
  PRIMARY KEY (`id`, `user_id`),
  INDEX `fk_order_user_idx` (`user_id` ASC),
  CONSTRAINT `fk_order_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `lego`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES 
(1,'jens@somewhere.com','jensen','customer'),
(2,'ken@somewhere.com','kensen','customer'),
(3,'robin@somewhere.com','batman','employee');
UNLOCK TABLES;


