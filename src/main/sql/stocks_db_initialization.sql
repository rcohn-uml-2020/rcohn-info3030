/** create the stocks database */

DROP DATABASE IF EXISTS stocks;

CREATE DATABASE stocks;

USE stocks;

DROP TABLE IF EXISTS quote CASCADE;
CREATE TABLE quote(
   id INT NOT NULL AUTO_INCREMENT,
   symbol VARCHAR(4) NOT NULL,
   time DATETIME NOT NULL,
   price DECIMAL NOT NULL,
   PRIMARY KEY ( id )
);

DROP TABLE IF IT EXISTS person CASCADE;
CREATE TABLE person (
	id INT NOT NULL AUTO_INCREMENT,
	last_name VARCHAR(256) NOT NULL,
	first_name VARCHAR(256) NOT NULL,
	PRIMARY KEY ( id )
);

DROP TABLE IF IT EXISTS portfolio CASCADE;
CREATE TABLE portfolio (
	id INT NOT NULL AUTO_INCREMENT,
	person_id INT NOT NULL,
	quotes_id INT NOT NULL,
	FOREIGN KEY ( person_id ) REFERENCES person ( id )
	FOREIGN KEY ( quotes_id ) REFERENCES quotes ( id )
	PRIMARY KEY ( id )
);

INSERT INTO quotes (symbol,time,price) VALUES ('GOOG','2004-08-19 00:00:01','85.00');
INSERT INTO quotes (symbol,time,price) VALUES ('GOOG','2015-02-03 00:00:01','527.35');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-01 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('AMZN','2015-02-03 00:00:01','363.21');
