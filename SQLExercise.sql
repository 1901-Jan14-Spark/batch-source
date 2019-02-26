CREATE TABLE INVOICE(
    S_ID NUMBER(5) PRIMARY KEY,
    S_DT DATE,
    S_CUST_ID NUMBER(5) REFERENCES CUSTOMER,
    S_AMT NUMBER(5,2)  
);

CREATE TABLE CUSTOMER(
    C_ID NUMBER(5) PRIMARY KEY,
    C_NAME VARCHAR2(50),
    C_PHONE NUMBER(10),
    C_EMAIL VARCHAR2(50)
);

ALTER TABLE INVOICE
DROP COLUMN S_CUST_ID;

ALTER TABLE INVOICE
ADD S_CUST_ID CONSTRAINT FK_CUST_ID REFERENCES CUSTOMER;

ALTER TABLE CUSTOMER
DROP COLUMN C_ID;

ALTER TABLE CUSTOMER
ADD C_ID NUMBER(5) CONSTRAINT PK_CUST PRIMARY KEY;

ALTER TABLE CUSTOMER
DROP COLUMN C_NAME;

ALTER TABLE CUSTOMER
ADD C_NAME VARCHAR(50);

ALTER TABLE CUSTOMER
DROP COLUMN C_PHONE;

ALTER TABLE CUSTOMER
ADD C_PHONE NUMBER(12);

ALTER TABLE INVOICE
DROP COLUMN S_ID;

ALTER TABLE INVOICE
ADD S_ID NUMBER(5);


--inserting 10 invoices and 5 customer records
INSERT INTO INVOICE VALUES (DATE '1988-02-26', 800.12, 1, 1);
INSERT INTO INVOICE VALUES (DATE '2017-07-28', 716.10, 2, 3);
INSERT INTO INVOICE VALUES (DATE '2008-06-14', 101.09, 3, 4);
INSERT INTO INVOICE VALUES (DATE '1993-11-25', 209.11, 4, 2);
INSERT INTO INVOICE VALUES (DATE '2006-03-24', 981.87, 5, 5);
INSERT INTO INVOICE VALUES (DATE '2019-02-26', 397.25, 6, 2);
INSERT INTO INVOICE VALUES (DATE '2019-01-28', 17.10, 7, 1);
INSERT INTO INVOICE VALUES (DATE '2018-05-20', 200.01, 8, 3);
INSERT INTO INVOICE VALUES (DATE '2017-04-14', 89.19, 9, 2);
INSERT INTO INVOICE VALUES (DATE '2019-02-26', 481.18, 10, 4);
INSERT INTO CUSTOMER VALUES ('adamfarul@gmail.com', 1, 7048161273, 'Adam Farul');
INSERT INTO CUSTOMER VALUES ('korldo@gmail.com', 2, 7048161273, 'Karen Orldo');
INSERT INTO CUSTOMER VALUES ('jrolyne@gmail.com', 3, 8190763451, 'Jeff Roylne');
INSERT INTO CUSTOMER VALUES ('timbertg@gmail.com', 4, 6152378540, 'Greg Timbert');
INSERT INTO CUSTOMER VALUES ('jquartie@gmail.com', 5, 9192123135, 'Jessica Quart');

--updating and deleting some records
DELETE INVOICE
WHERE S_ID = 5;

DELETE INVOICE
WHERE S_ID = 1;

DELETE INVOICE
WHERE S_ID = 7;

SELECT *
FROM INVOICE
WHERE S_DT = TRUNC (CURRENT_TIMESTAMP);

SELECT SUM(S_AMT) INVOICE_SUM_BY_ID
FROM INVOICE
GROUP BY S_CUST_ID;

SELECT *
FROM INVOICE
WHERE S_DT > to_date('2019-01-26', 'YYYY-MM-DD')
ORDER BY S_AMT DESC

SELECT *
FROM INVOICE
ORDER BY S_AMT DESC

SELECT *
FROM INVOICE
ORDER BY S_AMT DESC
FETCH FIRST 3 ROWS ONLY;

SELECT * FROM (
    SELECT *
    FROM INVOICE
    ORDER BY S_AMT DESC
)
WHERE ROWNUM < 4;



