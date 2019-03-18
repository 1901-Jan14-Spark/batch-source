/*******************************************************************************
   Reimbursement Expenditure Database - Version 1.1
   Script: tables_config.sql
   Description: Creates tables for database usage.
   DB Server: Oracle
   Author: Kevin Tran Huu
********************************************************************************/

/*******************************************************************************
   Create database tables
********************************************************************************/
DROP TABLE Employees;
DROP TABLE Reimbursements;

CREATE TABLE EMPLOYEES
(
    E_ID NUMBER(10) NOT NULL,
    E_email VARCHAR2(40) NOT NULL UNIQUE,
    E_Password VARCHAR2(20) NOT NULL,
    E_firstname VARCHAR2(40) DEFAULT 'Employee_Firstname' NOT NULL,
    E_lastname VARCHAR2(40) DEFAULT 'Employee_Lastname' NOT NULL,
    E_ISManager NUMBER(1) DEFAULT 0 NOT NULL,
    CONSTRAINT PK_Employees PRIMARY KEY (E_Id),
    CONSTRAINT E_validinput CHECK (E_isManager = 0 OR E_ismanager = 1)
);

CREATE TABLE Reimbursements
(
    R_Id Number(10) not null,
    E_Id Number(10) not null CONSTRAINT FK_EMP REFERENCES EMPLOYEES,
    R_Amount Number(12,2) NOT NULL,
    R_State Number(1) DEFAULT 0 NOT NULL,
    R_DATE TIMESTAMP NOT NULL,
    R_TITLE VARCHAR2(50) NOT NULL,
    R_DESCRIPTION VARCHAR2(200),
    R_Image BLOB,
    M_ID number(10) CONSTRAINT FK_MAN REFERENCES EMPLOYEES,
    CONSTRAINT PK_Reimbursements PRIMARY KEY (R_Id),
    Constraint R_VALIDINPUT check (R_AMOUNT >= 0)
);


/*******************************************************************************
   Create Triggers and Sequences
********************************************************************************/
CREATE SEQUENCE SQ_EMPLOYEE_PK
START WITH 100000000
MAXVALUE 399999999
INCREMENT BY   1
NOCACHE;

CREATE OR REPLACE TRIGGER TR_INSERT_EMPLOYEE
BEFORE INSERT ON EMPLOYEES
FOR EACH ROW
BEGIN
	SELECT SQ_EMPLOYEE_PK.NEXTVAL INTO :NEW.E_ID FROM DUAL;
END;
/

CREATE SEQUENCE SQ_REIMBURSEMENT_PK
START WITH 400000000
MAXVALUE 499999999
INCREMENT BY   1
NOCACHE;

CREATE OR REPLACE TRIGGER TR_INSERT_REIMBURSEMENT
BEFORE INSERT ON REIMBURSEMENTS
FOR EACH ROW
BEGIN
	SELECT SQ_REIMBURSEMENT_PK.NEXTVAL INTO :NEW.R_ID FROM DUAL;
END;
/

alter session set nls_timestamp_format='YYYY-MM-DD HH24:MI:SS';

CREATE OR REPLACE TRIGGER TR_INSERT_DATE_REIMBURSEMENT
BEFORE INSERT ON REIMBURSEMENTS
FOR EACH ROW
BEGIN
    SELECT localtimestamp INTO :NEW.R_DATE FROM DUAL;
END;
/
