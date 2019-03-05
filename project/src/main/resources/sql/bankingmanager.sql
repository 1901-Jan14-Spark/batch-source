
/*******************************************************************************
   Banking Database - Version 1.0
   Script: bankingmanager.sql
   Description: Creates user and tables for database.
   DB Server: Oracle
   Author: Kevin Tran Huu
********************************************************************************/

/*******************************************************************************
   Create database user
********************************************************************************/
CREATE USER banking_manager
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to banking_manager;
GRANT resource to banking_manager;
GRANT create session TO banking_manager;
GRANT create table TO banking_manager;
GRANT create view TO banking_manager;



conn banking_manager/p4ssw0rd


/*******************************************************************************
   Create Tables
********************************************************************************/
DROP TABLE ACCOUNT;
DROP TABLE ACCOUNTHOLDER;
DROP TABLE TRANSACTION;
DROP TABLE ACCOUNTMANAGER;


CREATE TABLE Account(
    A_Id Number(10) not null  CONSTRAINT PK_Account PRIMARY KEY,
    A_Type number(1) not null,
    A_Balance Number DEFAULT 0 NOT NULL,
    Constraint A_VALIDINPUT check (A_BALANCE >= 0 AND (A_TYPE = 0 OR A_TYPE = 1))
);

CREATE TABLE AccountHolder
(
    H_ID NUMBER(10) NOT NULL,
    H_Username VARCHAR2(20) NOT NULL UNIQUE,
    H_Password VARCHAR2(20) NOT NULL,
    H_firstname VARCHAR2(40) NOT NULL,
    H_lastname VARCHAR2(40) NOT NULL,
    H_LoggedIn NUMBER NOT NULL,
    CONSTRAINT PK_Holder PRIMARY KEY (H_Id),
    CONSTRAINT AH_validinput CHECK (H_LoggedIn = 0 OR H_LoggedIn = 1)
);

CREATE TABLE AccountManager
(
    H_ID NUMBER Constraint FK_H_ID references accountholder,
    A_ID NUMBER constraint FK_A_ID references account
);


CREATE TABLE Transaction
(
    T_id NUMBER NOT NULL,
    A_Id NUMBER NOT NULL CONSTRAINT FK_TA_ID references Account,
    T_Amount Number not null,
    T_date timestamp not null,
    T_Description Varchar2(200),
    Constraint PK_Transaction Primary Key (T_id) 
);

/*******************************************************************************
   Create Triggers and Sequences
********************************************************************************/

CREATE SEQUENCE SQ_ACCOUNT_PK
START WITH 1
MAXVALUE 999999999
INCREMENT BY   1;

CREATE OR REPLACE TRIGGER TR_INSERT_ACCOUNT
BEFORE INSERT ON ACCOUNT
FOR EACH ROW
BEGIN
	SELECT SQ_ACCOUNT_PK.NEXTVAL INTO :NEW.A_ID FROM DUAL;
END;
/

CREATE SEQUENCE SQ_ACCOUNTHOLDER_PK
START WITH 1000000000
MAXVALUE 1999999999
INCREMENT BY   1;

CREATE OR REPLACE TRIGGER TR_INSERT_ACCOUNTHOLDER
BEFORE INSERT ON ACCOUNTHOLDER
FOR EACH ROW
BEGIN
	SELECT SQ_ACCOUNTHOLDER_PK.NEXTVAL INTO :NEW.H_ID FROM DUAL;
END;
/

CREATE SEQUENCE SQ_Transaction_PK
START WITH 2000000000
MAXVALUE 2999999999
INCREMENT BY   1;

CREATE OR REPLACE TRIGGER TR_INSERT_Transaction
BEFORE INSERT ON Transaction
FOR EACH ROW
BEGIN
	SELECT SQ_Transaction_PK.NEXTVAL INTO :NEW.T_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TR_INSERT_DATE_Transaction
BEFORE INSERT ON Transaction
FOR EACH ROW
BEGIN
	SELECT CURRENT_TIMESTAMP INTO :NEW.T_DATE FROM DUAL;
END;
/