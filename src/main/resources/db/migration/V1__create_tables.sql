CREATE TABLE companies (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	industry VARCHAR(100),
	location VARCHAR(100)
);

CREATE TABLE jobs (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	company_id BIGINT NOT NULL,
	title VARCHAR(255) NOT NULL,
	salary VARCHAR(100),
	description TEXT,
	FOREIGN KEY (company_id) REFERENCES companies(id)
);

CREATE TABLE users (
	username VARCHAR(50) NOT NULL PRIMARY KEY,
	password VARCHAR(100) NOT NULL,
	enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
	username VARCHAR(50) NOT NULL,
	authority VARCHAR(50) NOT NULL,
	FOREIGN KEY (username) REFERENCES users(username)
);

CREATE UNIQUE INDEX ix_auth_username ON authorities (username,authority);