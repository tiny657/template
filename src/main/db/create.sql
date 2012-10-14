CREATE DATABASE IF NOT EXISTS template;
USE template;
DROP TABLE IF EXISTS member;
DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS document;

CREATE TABLE IF NOT EXISTS UserConnection (
	`userId` CHAR(255) NOT NULL,
    `providerId` CHAR(255) NOT NULL,
    `providerUserId` CHAR(255),
    `rank` INT NOT NULL,
    `displayName` CHAR(255),
    `profileUrl` VARCHAR(512),
    `imageUrl` VARCHAR(512),
    `accessToken` CHAR(255) NOT NULL,					
    `secret` CHAR(255),
    `refreshToken` CHAR(255),
    `expireTime` BIGINT,
    PRIMARY KEY (`userId`, `providerId`, `providerUserId`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE member (
	`providerUserId` CHAR(16),
	`name` CHAR(20),
	`gender` BOOLEAN,
	`email` CHAR(40),
	`level` INT DEFAULT 0,
	`point` INT DEFAULT 0,
	`doc` INT DEFAULT 0,
	`comment` INT DEFAULT 0,
	`commentOnMyDoc` INT DEFAULT 0,
	`like` INT DEFAULT 0,
	`likeOnMyDoc` INT DEFAULT 0,
	`dislike` INT DEFAULT 0,
	`dislikeOnMyDoc` INT DEFAULT 0,
	`sharing` INT DEFAULT 0,
	`sharingOfMyDoc` INT DEFAULT 0,
	`chanceToDoc` INT DEFAULT 2,
	`chanceToComment` INT DEFAULT 2,
	`chanceToLike` INT DEFAULT 2,
	`chanceToDislike` INT DEFAULT 2,
	`locale` CHAR(4),
	`regDate` DATETIME NOT NULL,
	`lastLoginDate` DATETIME NOT NULL,
	PRIMARY KEY (`providerUserId`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE document (
	`documentId` INT AUTO_INCREMENT,
	`content` TEXT NOT NULL,
	`point` INT DEFAULT 0,
	`comment` INT DEFAULT 0,
	`like` INT DEFAULT 0,
	`dislike` INT DEFAULT 0,
	`sharing` INT DEFAULT 0,
	`providerUserId` CHAR(16) NOT NULL,
	`name` CHAR(20),
	`ipAddress` CHAR(8) NOT NULL,
	`regDate` DATE NOT NULL,
	PRIMARY KEY (`documentId`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE comment (
	`commentId` INT AUTO_INCREMENT,
	`documentId` INT NOT NULL,
	`content` TEXT NOT NULL,
	`providerUserId` CHAR(16) NOT NULL,
	`name` CHAR(20),
	`regDate` DATE NOT NULL,
	PRIMARY KEY (`commentId`),
	FOREIGN KEY (`documentId`) REFERENCES document(`documentId`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
