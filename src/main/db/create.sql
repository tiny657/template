CREATE DATABASE IF NOT EXISTS template;
USE template;
DROP TABLE IF EXISTS member;
DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS document;
CREATE TABLE IF NOT EXISTS UserConnection (
	userId VARCHAR(255) NOT NULL,
    providerId VARCHAR(255) NOT NULL,
    providerUserId VARCHAR(255),
    rank INT NOT NULL,
    displayName VARCHAR(255),
    profileUrl VARCHAR(512),
    imageUrl VARCHAR(512),
    accessToken VARCHAR(255) NOT NULL,					
    secret VARCHAR(255),
    refreshToken VARCHAR(255),
    expireTime BIGINT,
    PRIMARY KEY (userId, providerId, providerUserId)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE member (
	providerUserId VARCHAR(16),
	name VARCHAR(20),
	gender BOOLEAN,
	email VARCHAR(40),
	point INT DEFAULT 0,
	countDocument INT DEFAULT 0,
	countToComment INT DEFAULT 0,
	countToBeCommented INT DEFAULT 0,
	countToLike INT DEFAULT 0,
	countToBeLiked INT DEFAULT 0,
	countToDislike INT DEFAULT 0,
	countToBeDisliked INT DEFAULT 0,
	countToShare INT DEFAULT 0,
	countToBeShared INT DEFAULT 0,
	locale VARCHAR(4),
	isAdmin BOOLEAN DEFAULT false,
	regDate DATETIME NOT NULL,
	lastLogin DATETIME NOT NULL,
	PRIMARY KEY (providerUserId)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE document (
	documentId INT AUTO_INCREMENT,
	point INT DEFAULT 0,
	isNotice BOOLEAN DEFAULT false,
	color VARCHAR(7) DEFAULT 0,
	content TEXT NOT NULL,
	countToLike INT DEFAULT 0,
	countToDislike INT DEFAULT 0,
	countToComment INT DEFAULT 0,
	countToShare INT DEFAULT 0,
	providerUserId VARCHAR(16) NOT NULL,
	name VARCHAR(20),
	ipAddress CHAR(8) NOT NULL,
	tags TEXT,
	regDate DATE NOT NULL,
	PRIMARY KEY (documentId)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE comment (
	commentId INT AUTO_INCREMENT,
	documentId INT,
	countToLike BOOLEAN DEFAULT 0,
	countToDislike BOOLEAN DEFAULT 0,
	content TEXT NOT NULL,
	providerUserId VARCHAR(16) NOT NULL,
	name VARCHAR(20),
	regDate DATE NOT NULL,
	PRIMARY KEY (commentId),
	FOREIGN KEY (documentId) REFERENCES document(documentId)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
