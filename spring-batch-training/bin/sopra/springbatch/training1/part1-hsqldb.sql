DROP TABLE  BATCH_STAGING_SEQ IF EXISTS;
DROP TABLE  CUSTOMER_SEQ IF EXISTS;
DROP TABLE  BATCH_STAGING IF EXISTS;
DROP TABLE  CUSTOMER IF EXISTS;
DROP TABLE  ERROR_LOG IF EXISTS;

-- Autogenerated: do not edit this file

CREATE TABLE CUSTOMER_SEQ (
	ID BIGINT IDENTITY
);
INSERT INTO CUSTOMER_SEQ (ID) values (5);
CREATE TABLE BATCH_STAGING_SEQ (
	ID BIGINT IDENTITY
);
INSERT INTO BATCH_STAGING_SEQ (ID) values (0);
CREATE TABLE TRADE_SEQ (
	ID BIGINT IDENTITY
);

CREATE TABLE BATCH_STAGING  (
	ID BIGINT IDENTITY NOT NULL PRIMARY KEY ,  
	JOB_ID BIGINT NOT NULL,
	VALUE LONGVARBINARY NOT NULL,
	PROCESSED CHAR(1) NOT NULL
) ;

CREATE TABLE CUSTOMER (
	ID BIGINT IDENTITY NOT NULL PRIMARY KEY ,  
	VERSION BIGINT ,
	FIRSTNAME VARCHAR(45) ,
	LASTNAME VARCHAR(45) ,
	AGE INTEGER ,
	
) ;
 
INSERT INTO CUSTOMER (ID, VERSION, FIRSTNAME, LASTNAME, AGE, GENDER) VALUES (1, 0, 'fcustomer1', 'lcustomer1', 10, 'M');
INSERT INTO CUSTOMER (ID, VERSION, FIRSTNAME, LASTNAME, AGE, GENDER) VALUES (2, 0, 'fcustomer2', 'lcustomer2', 20, 'F');
INSERT INTO CUSTOMER (ID, VERSION, FIRSTNAME, LASTNAME, AGE, GENDER) VALUES (3, 0, 'fcustomer3', 'lcustomer3', 30, 'F');
INSERT INTO CUSTOMER (ID, VERSION, FIRSTNAME, LASTNAME, AGE, GENDER) VALUES (4, 0, 'fcustomer4', 'lcustomer4', 40, 'M');

CREATE TABLE ERROR_LOG  (
		JOB_NAME CHAR(20) ,
		STEP_NAME CHAR(20) ,
		MESSAGE VARCHAR(300) NOT NULL
) ;