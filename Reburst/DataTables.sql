alter session set nls_date_format = 'MM/DD/YYYY hh24:mi:ss'


DROP TABLE MANAGERS;

DROP TABLE EMPLOYEE;

DROP TABLE REIMBURSEMENTS;


CREATE TABLE EMPLOYEE (
	EMPLOYEE_ID NUMBER(5) PRIMARY KEY,
	FIRST_NAME VARCHAR(50),
	LAST_NAME VARCHAR(50),
    EMPLOYEE_EMAIL VARCHAR(25) UNIQUE,
    EMPLOYEE_PASSWORD VARCHAR(15),
	TITLE VARCHAR(50),
	MANAGERS_ID NUMBER (5) CONSTRAINT FK_MID REFERENCES MANAGERS,
    EMPLOYEE_LOGGED NUMBER(1) DEFAULT 0 NOT NULL,
    CONSTRAINT LOG_CHECKER CHECK (EMPLOYEE_lOGGED = 0 OR EMPLOYEE_LOGGED = 1)
);

CREATE TABLE MANAGERS (
	MANAGERS_ID NUMBER (5) PRIMARY KEY,
	EMPLOYEE_ID NUMBER (5)
);

CREATE TABLE REIMBURSEMENTS
(
    REIMBURSEMENT_ID NUMBER(10) PRIMARY KEY,
    REIMBURSEMENT_AMOUNT NUMBER(12,2) NOT NULL,
    REIMBURSEMENT_STATUS NUMBER(1) DEFAULT 0 NOT NULL,
    REIMBURSEMENT_DATE TIMESTAMP NOT NULL,
    REIMBURSEMENT_DESC VARCHAR2(750),
    REIMBURSEMENT_RECEIPT BLOB,
    EMPLOYEE_ID NUMBER(5) CONSTRAINT FK_EMPID REFERENCES EMPLOYEE
);
