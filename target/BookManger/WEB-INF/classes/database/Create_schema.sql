CREATE TABLE IF NOT EXISTS `Sombra`.`Books` (
  `id` INT NOT NULL,
  `name` VARCHAR(200) NOT NULL,
  `published` DATE NULL,
  `genre` VARCHAR(45) NULL,
  `rating` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `kniga`
    FOREIGN KEY (`id`)
    REFERENCES `Sombra`.`Book_Author` (`book-id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `Sombra2`.`Authors` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `gender` VARCHAR(45) NULL,
  `born` DATE ,
  PRIMARY KEY (`id`));



CREATE TABLE IF NOT EXISTS `Sombra2`.`Books` (
  `id` INT NOT NULL,
  `name` VARCHAR(200) NOT NULL,
  `published` DATE NULL,
  `genre` VARCHAR(45) NULL,
  `rating` INT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE IF NOT EXISTS `Sombra2`.`Books` (
  `id` INT not NULL,
  `name` VARCHAR(200) NOT NULL,
  `published` DATE NULL,
  `genre` VARCHAR(45) NULL,
  `rating` INT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE IF NOT EXISTS `Sombra`.`Books` (
  `id` INT NULL,
  `name` VARCHAR(200) NOT NULL,
  `published` DATE NULL,
  `genre` VARCHAR(45) NULL,
  `rating` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `kniga`
    FOREIGN KEY (`id`)
    REFERENCES `Sombra`.`Book_Author` (`book-id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `Sombra`.`Book_Author` (
  `id` INT NOT NULL,
  `book-id` INT NOT NULL,
  `author-id` INT NOT NULL,
  PRIMARY KEY (`id`, `book-id`, `author-id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB