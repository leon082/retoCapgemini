ALTER TABLE `mybank`.`transaction_type` ADD COLUMN `factor` TINYINT NOT NULL DEFAULT 1 AFTER `description`;
