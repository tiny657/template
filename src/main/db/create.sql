DROP TABLE IF EXISTS UserConnection;
DROP TABLE IF EXISTS member;
DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS document;
CREATE TABLE UserConnection (
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
	memberId INT AUTO_INCREMENT,
	userId VARCHAR(16) UNIQUE NOT NULL,
	name VARCHAR(20),
	email VARCHAR(40),
	password CHAR(41) NOT NULL,
	birthday DATE,
	description TEXT,
	point INT DEFAULT 0,
	documentCount INT DEFAULT 0,
	commentCount INT DEFAULT 0,
	likeCount INT DEFAULT 0,
	dislikeCount INT DEFAULT 0,
	isAdmin BOOLEAN DEFAULT false,
	allowMailing BOOLEAN DEFAULT false,
	regDate DATETIME NOT NULL,
	lastLogin DATETIME NOT NULL,
	PRIMARY KEY (memberId)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE document (
	documentId INT AUTO_INCREMENT,
	point INT DEFAULT 0,
	isNotice BOOLEAN DEFAULT false,
	title VARCHAR(250) NOT NULL,
	titleBold BOOLEAN DEFAULT false,
	titleColor VARCHAR(7) DEFAULT 0,
	content TEXT NOT NULL,
	likeCount INT DEFAULT 0,
	dislikeCount INT DEFAULT 0,
	commentCount INT DEFAULT 0,
	shareCount INT DEFAULT 0,
	userId VARCHAR(16) NOT NULL,
	name VARCHAR(20),
	email VARCHAR(40),
	ipAddress CHAR(8) NOT NULL,
	tags TEXT,
	regDate DATE NOT NULL,
	lastUpdate DATE NOT NULL,
	PRIMARY KEY (documentId)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE comment (
	commentId INT AUTO_INCREMENT,
	documentId INT,
	likeCount BOOLEAN DEFAULT 0,
	dislikeCount BOOLEAN DEFAULT 0,
	content TEXT NOT NULL,
	userId VARCHAR(16) NOT NULL,
	regDate DATE NOT NULL,
	PRIMARY KEY (commentId),
	FOREIGN KEY (documentId) REFERENCES document(documentId)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
