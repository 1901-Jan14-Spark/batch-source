-- Select all records from the Employee table.
SELECT *
FROM CHINOOK.EMPLOYEE;

-- Select all records from the Employee table where last name is King.
SELECT *
FROM CHINOOK.EMPLOYEE
WHERE LASTNAME = 'King';

-- Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT *
FROM CHINOOK.EMPLOYEE
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL ;

-- Select all albums in Album table and sort result set in descending order by title.
SELECT *
FROM CHINOOK.ALBUM;

-- Select first name from Customer and sort result set in ascending order by city.
SELECT FIRSTNAME
FROM CHINOOK.CUSTOMER
ORDER BY CITY ASC;

-- Select all invoices with a billing address like “T%”
SELECT *
FROM CHINOOK.INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

-- Insert two new records into Genre table
--SELECT *
--FROM CHINOOK.GENRE
INSERT INTO CHINOOK.GENRE VALUES (26, 'TESTINSERT');
INSERT INTO CHINOOK.GENRE VALUES (27, 'REWCSFRECORD');

-- Insert two new records into Employee table
INSERT INTO CHINOOK.EMPLOYEE VALUES (9, 'CURRY', 'STEPHEN', 'BOSS', NULL, DATE '1995-11-28', DATE '2019-01-14', 125795, 'RESTON', 'VA', 'USA', 54216, 3577778976, NULL, 'SCURRY@GMAIL.COM');
INSERT INTO CHINOOK.EMPLOYEE VALUES (10, 'HARDEN', 'JAMES', 'CLUTCH', NULL, DATE '1999-05-18', DATE '2018-01-14', 541234, 'DALLAS', 'TX', 'USA', 11444, 3577424976, NULL, 'JHARDEN@GMAIL.COM');

-- Insert two new records into Customer table 
INSERT INTO CHINOOK.CUSTOMER VALUES (60, 'DAT', 'TRAN', 'REVATURE', '221 BACKER STREET', 'RESTON', 'VA', 'USA', '21904', '+1 (780) 428-9482', '+1 (980) 418-9532', 'DTRAN@REV.COM', 3);
INSERT INTO CHINOOK.CUSTOMER VALUES (61, 'LEBRON', 'JAMES', 'LAKER', '190 SYCAMORE', 'RESTON', 'VA', 'USA', '71944', '+1 (480) 628-9142', '+1 (170) 618-7832', 'LEBRON@REV.COM', 2);

-- Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CHINOOK.CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE CUSTOMERID = 32;

-- Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE CHINOOK.ARTIST
SET NAME = 'CCR'
WHERE ARTISTID = 76;

-- Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT C.FIRSTNAME, I.INVOICEID
FROM CHINOOK.CUSTOMER C
INNER JOIN CHINOOK.INVOICE I
ON C.CUSTOMERID = I.CUSTOMERID;

-- Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT C.CUSTOMERID, C.FIRSTNAME, C.LASTNAME, I.INVOICEID, I.TOTAL
FROM CHINOOK.CUSTOMER C
FULL JOIN CHINOOK.INVOICE I
ON C.CUSTOMERID = I.CUSTOMERID;

-- Create a right join that joins album and artist specifying artist name and title.
SELECT ART.NAME, ALB.TITLE
FROM CHINOOK.ALBUM ALB
RIGHT JOIN CHINOOK.ARTIST ART
ON ALB.ARTISTID = ART.ARTISTID;

-- Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT *
FROM CHINOOK.ALBUM ALB
CROSS JOIN CHINOOK.ARTIST ART
ORDER BY ART.NAME ASC;

-- Perform a self-join on the employee table, joining on the reportsto column.
SELECT A.REPORTSTO AS "SUPERVISOR_ID", B.FIRSTNAME AS "SUPERVISOR_NAME"
FROM CHINOOK.EMPLOYEE A, CHINOOK.EMPLOYEE B
WHERE A.REPORTSTO = B.EMPLOYEEID;

-- Create a query that shows the customer name with the total amount of money they have spent.
SELECT C.FIRSTNAME, I.TOTAL
FROM CHINOOK.CUSTOMER C
INNER JOIN CHINOOK.INVOICE I
ON C.CUSTOMERID = I.CUSTOMERID;

-- Create a query that shows the employee that has made the highest number of sales (number of invoices).
SELECT E.FIRSTNAME, COUNT(C.SUPPORTREPID) AS SALES 
FROM CHINOOK.CUSTOMER C
INNER JOIN CHINOOK.EMPLOYEE E ON E.EMPLOYEEID = C.SUPPORTREPID
GROUP BY E.FIRSTNAME
ORDER BY SALES DESC
FETCH FIRST ROW ONLY;

-- Create a query which shows the number of purchases per each genre. Display the name of each genre and number of purchases. Show the most popular genre first.
SELECT G.NAME, COUNT(INV.TRACKID) AS PURCHASES
FROM CHINOOK.GENRE G
INNER JOIN CHINOOK.TRACK T ON T.GENREID = G.GENREID
INNER JOIN CHINOOK.INVOICELINE INV ON INV.TRACKID = T.TRACKID
GROUP BY G.NAME
ORDER BY PURCHASES DESC;