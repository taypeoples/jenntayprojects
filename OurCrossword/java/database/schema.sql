BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	nickname varchar(50),
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);
CREATE TABLE quotes (
	quote_id SERIAL,
	quote_text varchar(500),
	quote_author varchar(50),
	CONSTRAINT PK_quotes PRIMARY KEY (quote_id)
);

CREATE TABLE response (
	response_id SERIAL,
	response_description varchar (500),
	response_text varchar(1500),
	keyword_1 varchar(50),
	keyword_2 varchar(50),
	CONSTRAINT PK_first_response PRIMARY KEY (response_id)
);





COMMIT TRANSACTION;
