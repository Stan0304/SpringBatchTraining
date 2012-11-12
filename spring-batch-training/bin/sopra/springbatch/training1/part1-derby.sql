
DROP TABLE  BATCH_STAGING_SEQ ;
DROP TABLE  CUSTOMER_SEQ ;
DROP TABLE  BATCH_STAGING ;
DROP TABLE  CUSTOMER ;
DROP TABLE  ERROR_LOG ;

CREATE TABLE CUSTOMER_SEQ (ID BIGINT  PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY (start with 5), DUMMY VARCHAR(1));
CREATE TABLE BATCH_STAGING_SEQ (ID BIGINT  PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY (start with 0), DUMMY VARCHAR(1));

CREATE TABLE BATCH_STAGING  (
	ID BIGINT  NOT NULL PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,  
	JOB_ID BIGINT NOT NULL,
	VALUE BLOB NOT NULL,
	PROCESSED CHAR(1) NOT NULL
) ;

CREATE TABLE CUSTOMER (
	ID BIGINT  NOT NULL PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,  
	VERSION BIGINT ,
	FIRSTNAME VARCHAR(45) ,
	LASTNAME VARCHAR(45) ,
	AGE INTEGER , 
	GENDER CHAR(1)
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
