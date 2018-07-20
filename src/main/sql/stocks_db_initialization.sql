/** create the stocks database */

DROP DATABASE IF EXISTS stocks;

CREATE DATABASE stocks;

USE stocks;

DROP TABLE IF EXISTS stock_symbol CASCADE;
CREATE TABLE stock_symbol (
  id INT NOT NULL AUTO_INCREMENT,
  symbol VARCHAR(4) NOT NULL,
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
  person_id INT,
  stock_id INT,
  FOREIGN KEY ( person_id ) REFERENCES person ( id ),
  FOREIGN KEY ( stock_id ) REFERENCES stock_symbol ( id ),
  PRIMARY KEY ( id )
);

DROP TABLE IF EXISTS quote CASCADE;
CREATE TABLE quote (
  id INT NOT NULL AUTO_INCREMENT,
  symbol VARCHAR(4) NOT NULL,
  time DATETIME NOT NULL,
  price DECIMAL NOT NULL,
  symbol_id INT,
  FOREIGN KEY ( symbol_id ) REFERENCES stock_symbol ( id ),
  PRIMARY KEY ( id )
);

INSERT INTO stock_symbol (symbol) VALUES
  ('AGTK'), ('AKAM'), ('AMZN'), ('AOL'), ('APPL'), ('BCOM'), ('BCOR'), ('BIDU'),('BRNW'),('CARB'),
  ('CCIH'), ('CCOI'), ('CHIC'), ('CNCG') ('CNV'), ('CRWG'), ('CXDO'), ('EATR'), ('EDXC'), ('EGOV'),
  ('ELNK'), ('ENV'), ('EPAZ'), ('FB'), ('FDIT'), ('FLPC'), ('GCLT'), ('GOOG'), ('GREZ'), ('IACI'),
  ('ICOA'), ('IIJI'), ('ILIA'), ('INAP'), ('IPAS'), ('JCOM'), ('JRJC'), ('LLNW'), ('LOGL'), ('LOOK'),
  ('MEET'), ('MOMO'), ('NETE'), ('NTES'), ('NQ'), ('OTOW') ('VNET'), ('VOIS') ('WIFI');

INSERT INTO person (user_name) VALUES ('Tom'), ('Dick'), ('Harry');

INSERT INTO person_stocks (person_id, stock_id) VALUES (1, 2), (2, 5), (3, 3);

INSERT INTO quote (symbol,time,price) VALUE ('GOOG','2004-08-19 00:00:01','85.00');
INSERT INTO quote (symbol,time,price) VALUE ('GOOG','2015-02-03 00:00:01','527.35');
INSERT INTO quote (symbol,time,price) VALUE ('APPL','2000-01-01 00:00:01','118.27');
INSERT INTO quote (symbol,time,price) VALUE ('AMZN','2015-02-03 00:00:01','363.21');

UPDATE quote
SET symbol_id = (SELECT id FROM stock_symbol WHERE stock_symbol.symbol = quote.symbol);