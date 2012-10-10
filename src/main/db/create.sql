CREATE DATABASE IF NOT EXISTS template;
USE template;
DROP TABLE IF EXISTS UserConnection;
DROP TABLE IF EXISTS member;
DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS document;

CREATE TABLE IF NOT EXISTS UserConnection (
	userId CHAR(255) NOT NULL,
    providerId CHAR(255) NOT NULL,
    providerUserId CHAR(255),
    rank INT NOT NULL,
    displayName CHAR(255),
    profileUrl VARCHAR(512),
    imageUrl VARCHAR(512),
    accessToken CHAR(255) NOT NULL,					
    secret CHAR(255),
    refreshToken CHAR(255),
    expireTime BIGINT,
    PRIMARY KEY (userId, providerId, providerUserId)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE member (
	providerUserId CHAR(16),
	name CHAR(20),
	gender BOOLEAN,
	email CHAR(40),
	level INT DEFAULT 0,
	point INT DEFAULT 0,
	countToDocument INT DEFAULT 0,
	countToComment INT DEFAULT 0,
	countToBeCommented INT DEFAULT 0,
	countToLike INT DEFAULT 0,
	countToBeLiked INT DEFAULT 0,
	countToDislike INT DEFAULT 0,
	countToBeDisliked INT DEFAULT 0,
	countToShare INT DEFAULT 0,
	countToBeShared INT DEFAULT 0,
	locale CHAR(4),
	regDate DATETIME NOT NULL,
	lastLogin DATETIME NOT NULL,
	PRIMARY KEY (providerUserId)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE document (
	documentId INT AUTO_INCREMENT,
	point INT DEFAULT 0,
	isNotice BOOLEAN DEFAULT false,
	content TEXT NOT NULL,
	countToComment INT DEFAULT 0,
	countToLike INT DEFAULT 0,
	countToDislike INT DEFAULT 0,
	countToShare INT DEFAULT 0,
	providerUserId CHAR(16) NOT NULL,
	name CHAR(20),
	ipAddress CHAR(8) NOT NULL,
	regDate DATE NOT NULL,
	PRIMARY KEY (documentId)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE comment (
	commentId INT AUTO_INCREMENT,
	documentId INT NOT NULL,
	countToLike BOOLEAN DEFAULT 0,
	countToDislike BOOLEAN DEFAULT 0,
	content TEXT NOT NULL,
	providerUserId CHAR(16) NOT NULL,
	name CHAR(20),
	regDate DATE NOT NULL,
	PRIMARY KEY (commentId),
	FOREIGN KEY (documentId) REFERENCES document(documentId)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
