DROP TABLE IF EXISTS `ast_AppMenus_M`;

CREATE TABLE `ast_AppMenus_M` ( `menuId` VARCHAR(64) NOT NULL, `menuTreeId` VARCHAR(256) NOT NULL, `menuIcon` VARCHAR(256) NOT NULL, `menuAction` VARCHAR(256) NOT NULL, `menuCommands` VARCHAR(64) NOT NULL, `menuDisplay` TINYINT(1) NOT NULL, `menuHead` TINYINT(1) NOT NULL, `menuLabel` VARCHAR(256) NOT NULL, `uiType` VARCHAR(3) NOT NULL, `RefObjectId` VARCHAR(256) NULL DEFAULT NULL, `menuAccessRights` INT(11) NOT NULL, `appType` INT(1) NULL DEFAULT NULL, `appId` VARCHAR(256) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`menuId`));

