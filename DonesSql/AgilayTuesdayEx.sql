-- this is a comment
/*this is a multiline comment*/
------------------------------------
--USING DDL TO CREATE OUR TABLE
------------------------------------
CREATE TABLE INVOICE(
    INVOICE_ID NUMBER(2), 
    INVOICE_DATE DATE,
    CUSTOMER_ID NUMBER(2) CONSTRAINT FK_IN_ID REFERENCES CUSTOMER,
    AMOUNT NUMBER(5,2)
);

CREATE TABLE CUSTOMER(
 CUSTOMER_NAME VARCHAR(20),
 CUSTOMER_ID NUMBER(2) CONSTRAINT PK_CUST PRIMARY KEY
 );
INSERT INTO CUSTOMER VALUES('VIRONICA', 1);
INSERT INTO CUSTOMER VALUES('JESSICA', 2);
INSERT INTO CUSTOMER VALUES('MARS', 3);
INSERT INTO CUSTOMER VALUES('JUNO', 4);
INSERT INTO CUSTOMER VALUES('LUCKY',5);

INSERT INTO INVOICE VALUES(1, DATE '2019-02-22', 1, 200.30);
INSERT INTO INVOICE VALUES(2, DATE '2019-02-26', 1, 100.25);
INSERT INTO INVOICE VALUES(3, DATE '2019-02-25', 1, 400.59);
INSERT INTO INVOICE VALUES(4, DATE '2018-01-31', 5, 800.01);
INSERT INTO INVOICE VALUES(5, DATE '2018-02-28', 2, 700.25);
INSERT INTO INVOICE VALUES(6, DATE '2017-03-14', 4, 408.45);
INSERT INTO INVOICE VALUES(7, DATE '2016-05-29', 3, 650.45);
INSERT INTO INVOICE VALUES(8, DATE '2018-06-14', 2, 700.00);
INSERT INTO INVOICE VALUES(9, DATE '2014-05-08', 3, 470.45);
INSERT INTO INVOICE VALUES(10, DATE '2016-05-29', 4, 600.32);

DELETE FROM INVOICE 
WHERE INVOICE_ID <3;

SELECT *
FROM INVOICE
WHERE INVOICE_DATE = DATE '2019-02-26'; 

SELECT COUNT(INVOICE_ID)
FROM INVOICE
GROUP BY CUSTOMER_ID
--WHERE CUS = CUSTOMER_ID;
--WHERE CUSTOMER 

SELECT AVG(MONTHLY_SALARY) AVG_SALARY
FROM EMPLOYEE 
GROUP BY DEPT_ID
HAVING DEPT_ID<3;


UPDATE INVOICE 
SET INVOICE_DATE = DATE '2019-02-26'
WHERE INVOICE_ID = 3;


CREATE TABLE DEPARTMENT(
    DEPT_ID NUMBER(5) CONSTRAINT PK_DEPT PRIMARY KEY,
    DEPT_NAME VARCHAR(50),
    MONTHLY_BUDGET NUMBER(5,2)
);
CREATE TABLE EMPLOYEE(
    EMP_ID  NUMBER(6) PRIMARY KEY,
    EMP_NAME  VARCHAR2(25),
    BIRTHDAY DATE,
    MONTHLY_SALARY NUMBER(5,2) NOT NULL,
    POSITION VARCHAR(20),
    MANAGER_ID NUMBER(5),
    DEPT_ID NUMBER(5) CONSTRAINT FK_EMP_DEPT REFERENCES DEPARTMENT                                               
);

Alter table departMENT
MODIFY MONTHLY_BUDGET NUMBER(7,2);

ALTER TABLE EMPLOYEE 
ADD HIRE_DATE DATE;
--THIS WOULD NOT INSERT, AS WE DO NOT HAVE A RECORD IN OUR DEPARTMENT TABLE WITH AN ID OF 2
--INSERT INTO EMPLOYEE VALUES (1, 'JOHN SMITH', DATE ' 1988-02-26', 2800,'MK_REP',NULL, 2, DATE '2018-10-12');

--INSERTING INTO OUR DEPARTMENT TABLE
INSERT INTO DEPARTMENT VALUES (1,'HUMAN RESOURCES', 8000);
INSERT INTO DEPARTMENT VALUES (2, 'MARKETUING', 9000);
INSERT INTO DEPARTMENT VALUES (3,'ACCOUNTING', 5800);
INSERT INTO DEPARTMENT VALUES (4, 'INFORMATION TECHNOLOGY', 3500);
INSERT INTO DEPARTMENT VALUES (5, 'LEGAL', 1);
INSERT INTO DEPARTMENT VALUES (6, 'CUSTOMER SERVICE', 5800);
INSERT INTO DEPARTMENT (DEPT_ID, DEPT_NAME) VALUES (7, 'SALES');

SELECT * 
FROM DEPARTMENT;

SELECT DEPT_NAME
FROM DEPARTMENT; 

DROP TABLE DEPARTMENT; 

ALTER TABLE EMPLOYEE
DROP CONSTRAINT FK_EMP_DEPT;

--RECREATE FORIEGN KET RELATIONSHIP BETWEEN EMPLOYEE AND DEPARTMENT TABLE 
ALTER TABLE EMPLOYEE
ADD CONSTRAINT FK_EMP_DEPT
FOREIGN KEY (DEPT_ID) REFERENCES DEPARTMENT(DEPT_ID) ON DELETE CASCADE;

--INSERTING EMPLOYYESS RECORDS
INSERT INTO EMPLOYEE VALUES (1, 'JOHN SMITH', DATE '1988-02-26', 2800,'MK_REP',NULL, 2, DATE '2018-10-12');
INSERT INTO EMPLOYEE VALUES (2, 'JAMES BOND', DATE '1982-03-25', 2900, 'ACCOUNTING', NULL, 3, DATE '2019-01-04');
INSERT INTO EMPLOYEE VALUES (3, 'MIK SITH', DATE ' 1888-12-16', 2700,'ACCOUNTING',2, 2, DATE '2018-10-12');

INSERT INTO EMPLOYEE VALUES (3, 'MIK SITH', DATE ' 1888-12-16', 2700,'ACCOUNTING',2, 2, DATE '2018-10-12');



SELECT * 
FROM EMPLOYEE; 

SELECT EMP_NAME 
FROM EMPLOYEE 
WHERE EMP_ID <3;

SELECT EMP_NAME
FROM EMPLOYEE 
WHERE MANAGER_ID = NULL;

DELETE FROM EMPLOYEE
WHERE MONTHLY_SALARY >2700;

UPDATE EMPLOYEE 
SET MONTHLY_SALARY = 3300
WHERE EMP_ID = 2;

-- USING DQL TO MAKE MORE QUERIES 

SELECT EMP_NAME, MONTHLY_SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_ID = 2;


--ALAIASING             YOU CAN NOW USE THIS AS A VARIABLE 
SELECT COUNT(EMP_ID) AS TOTAL_EMPLOYEES
FROM EMPLOYEE;

SELECT * 
FROM EMPLOYEE 
WHERE EMP_NAME LIKE 'J%'
ORDER BY MONTHLY_SALARY DESC;

-- SELCET AVERGAE SALARY FROM EACH DEPARTMENT 
SELECT AVG(MONTHLY_SALARY) AVG_SALARY
FROM EMPLOYEE 
GROUP BY DEPT_ID
HAVING DEPT_ID<3;

SELECT *
FROM EMPLOYEE 
WHERE DEPT_ID = 1 OR DEPT_ID = 3 OR DEPT_ID = 5;


SELECT * 
FROM EMPLOYEE
WHERE DEPT_ID IN (1,2);

SELECT * 
FROM EMPLOYEE 
WHERE MONTHLY_SALARY =
    (SELECT MAX(MONTHLY_SALARY)
    FROM EMPLOYEE); 





--USING A SUBQUERY 



