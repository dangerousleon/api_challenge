CREATE TABLE `challenge`.`register_item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `item_id` VARCHAR(60) NULL,
  `counting` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `item_id_UNIQUE` (`item_id` ASC) VISIBLE,
  INDEX `register_item_indx1` (`counting` DESC) VISIBLE);