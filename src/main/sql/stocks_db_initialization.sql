/** create the stocks database */

DROP DATABASE IF EXISTS stocks;

CREATE DATABASE stocks;

USE stocks;

DROP TABLE IF EXISTS quote CASCADE;
CREATE TABLE quote (
   id INT NOT NULL AUTO_INCREMENT,
   symbol VARCHAR(4) NOT NULL,
   time DATETIME NOT NULL,
   price DECIMAL NOT NULL,
   PRIMARY KEY ( id )
);

DROP TABLE IF EXISTS person CASCADE;
CREATE TABLE person (
	id INT NOT NULL AUTO_INCREMENT,
	user_name VARCHAR(256) NOT NULL,
	PRIMARY KEY ( id )
);

DROP TABLE IF EXISTS person_stocks CASCADE;
CREATE TABLE person_stocks (
  id INT NOT NULL AUTO_INCREMENT,
  person_id INT NOT NULL,
  FOREIGN KEY ( person_id ) REFERENCES person ( id ),
  PRIMARY KEY ( id )
);

DROP TABLE IF EXISTS stock_symbol CASCADE;
CREATE TABLE stock_symbol (
  id INT NOT NULL AUTO_INCREMENT,
  symbol VARCHAR(4) NOT NULL,
  PRIMARY KEY ( id )
);


INSERT INTO quote (symbol,time,price) VALUES ('GOOG','2004-08-19 00:00:01','85.00');
INSERT INTO quote (symbol,time,price) VALUES ('GOOG','2015-02-03 00:00:01','527.35');
INSERT INTO quote (symbol,time,price) VALUES ('APPL','2000-01-01 00:00:01','118.27');
INSERT INTO quote (symbol,time,price) VALUES ('AMZN','2015-02-03 00:00:01','363.21');

INSERT INTO person (user_name) VALUES ('Tom');
INSERT INTO person (user_name) VALUES ('Dick');
INSERT INTO person (user_name) VALUES ('Harry');

INSERT INTO person_stocks ( person_id ) VALUES (1);
INSERT INTO person_stocks ( person_id ) VALUES (2);
INSERT INTO person_stocks ( person_id ) VALUES (3);

INSERT INTO stock_symbol (symbol) VALUES ('GOOG');
INSERT INTO stock_symbol (symbol) VALUES ('APPL');
INSERT INTO stock_symbol (symbol) VALUES ('AMZN');
