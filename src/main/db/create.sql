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
	memberId INT AUTO_INCREMENT,
	providerUserId VARCHAR(16) UNIQUE NOT NULL,
	name VARCHAR(20),
	email VARCHAR(40),
	point INT DEFAULT 0,
	documentCount INT DEFAULT 0,
	commentCount INT DEFAULT 0,
	likeCount INT DEFAULT 0,
	dislikeCount INT DEFAULT 0,
	isAdmin BOOLEAN DEFAULT false,
	regDate DATETIME NOT NULL,
	lastLogin DATETIME NOT NULL,
	PRIMARY KEY (memberId)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE document (
	documentId INT AUTO_INCREMENT,
	point INT DEFAULT 0,
	isNotice BOOLEAN DEFAULT false,
	color VARCHAR(7) DEFAULT 0,
	content TEXT NOT NULL,
	likeCount INT DEFAULT 0,
	dislikeCount INT DEFAULT 0,
	commentCount INT DEFAULT 0,
	shareCount INT DEFAULT 0,
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
	likeCount BOOLEAN DEFAULT 0,
	dislikeCount BOOLEAN DEFAULT 0,
	content TEXT NOT NULL,
	providerUserId VARCHAR(16) NOT NULL,
	name VARCHAR(20),
	regDate DATE NOT NULL,
	PRIMARY KEY (commentId),
	FOREIGN KEY (documentId) REFERENCES document(documentId)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
