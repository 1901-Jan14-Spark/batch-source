/*
*   Chinook Exercises
*
*/


-- 2.1 Select

-- Query to select all records from the Employee table
SELECT *
FROM EMPLOYEE;

-- Query to select all records from Employee table with last name King
SELECT *
FROM EMPLOYEE
WHERE LASTNAME = 'King';

-- Query to select all records from the Employee table where the first name is Andrew and Reportsto is null
SELECT *
FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

-- Query to select all albums in Album table and sort result set in descending order by title
SELECT *
FROM ALBUM
ORDER BY title DESC;

-- Query to select first name from Customer and sort result in ascending order by city.
SELECT FIRSTNAME
FROM CUSTOMER
ORDER BY CITY;

-- Query to select all invoices with a billing address like "T%"
SELECT *
FROM INVOICE
WHERE BILLINGADDRESS like 'T%';

-- 2.2 INSERT INTO 

-- Query to insert two new records into the genre table
INSERT INTO GENRE VALUES(26, 'Modern Classical');
INSERT INTO GENRE VALUES(27, 'New Modern Classical');
-- Tester
--SELECT *
--FROM GENRE;

-- Query to insert two new records into Employee table
INSERT INTO EMPLOYEE VALUES(9, 'Mack', 'Mick', 'Web Browser', 2, DATE '1978-05-15', DATE '2018-02-25', '123 Road St', 'SomeCity', 'AB', 'Canada', 'T3P 5M5', '+1 (123) 456 7890', '+1 (123) 456 7891', 'mick@chinookcorp.com'); 
INSERT INTO EMPLOYEE VALUES(10, 'Mock', 'Mock', 'Office Browser', 1, DATE '1985-02-28', DATE '2018-02-25', '123 Road St', 'SomeCity', 'AB', 'Canada', 'T3P 5M5', '+1 (123) 456 7800', '+1 (123) 456 7801', 'mock@chinookcorp.com');
-- Tester
--SELECT *
--FROM EMPLOYEE;

-- Query to inser two new records into the Customer table
INSERT INTO CUSTOMER VALUES(60,'Andy', 'Ha', 'Revature', '123 Some Street', 'SomeCity', 'SomeState', 'SomeCountry', '1TK 5I5', '+1 321 654 7654', '+1 321 654 7655', 'randomemail@email.com', 1);
INSERT INTO CUSTOMER VALUES(61,'Dave', 'Als', 'Revature', '123 Some Street', 'SomeCity', 'SomeState', 'SomeCountry', '1TK 5I5', '+1 321 654 7354', '+1 321 654 7354', 'randomemail1@email.com', 1);
-- Tester
--SELECT *
--FROM CUSTOMER
--WHERE CUSTOMERID > 50;

-- 2.3 UPDATE

-- Update Aaron Mitchel in customer table to Robert Walter
SAVEPOINT UPDATEAARON;
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE CUSTOMERID = (
    SELECT CUSTOMERID
    FROM CUSTOMER
    WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell');
-- Tester
--SELECT CUSTOMERID, FIRSTNAME, LASTNAME
--FROM CUSTOMER
--WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

-- Update name of artist Creedence Clearwater revival to CCR
SAVEPOINT UPDATECCR;
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';
-- Tester
--SELECT *
--FROM ARTIST
--WHERE NAME = 'CCR';

-- 3.0 Joins

-- 3.1 Inner join
-- Inner join that joins customers and orders and specifies name of customer and invoice Id
SELECT concat(CUSTOMER.FIRSTNAME,concat(' ', CUSTOMER.LASTNAME)) as CUSTOMERNAME, INVOICE.INVOICEID
FROM INVOICE
INNER JOIN CUSTOMER
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

-- 3.2 Outer join
-- Join customer and invoice table specifying the CustomerId, firstname, lastname, invoiceid, and total.
SELECT C.CUSTOMERID,C.FIRSTNAME, C.LASTNAME, I.INVOICEID, I.TOTAL
FROM INVOICE I
FULL OUTER JOIN CUSTOMER C
ON C.CUSTOMERID = I.CUSTOMERID;

-- 3.3 Right outer join
-- Right outer join album and artist specifying artist name and title
SELECT R.NAME, A.TITLE
FROM ALBUM A
RIGHT OUTER JOIN ARTIST R
ON A.ARTISTID = R.ARTISTID;

-- 3.4 Cross join
-- album and artist, and sort by artist name in ascending order
SELECT *
FROM ALBUM
CROSS JOIN ARTIST
ORDER BY artist.name;

-- 3.5 Self join
-- Self-join on the employee table joining on the reportsto column
SELECT E1.FIRSTNAME||' '|| E1.LASTNAME||' reports to '||E2.FIRSTNAME||' '||E2.LASTNAME
FROM EMPLOYEE E1
JOIN EMPLOYEE E2
ON E1.REPORTSTO = E2.EMPLOYEEID;

-- 3.6 Joined queries
-- Query that show the customer first name and last name as FULL_NAME and the toal amount of money they have spent in total
SELECT C.FIRSTNAME||' '||C.LASTNAME as FULL_NAME, TOTAL
FROM(
SELECT SUM(I.TOTAL) as TOTAL
FROM INVOICE I
GROUP BY I.CUSTOMERID)
natural join CUSTOMER C;

-- Create a query that shows the employee that has made the highest total value of sales(total of all invoices)
SELECT EMPLOYEEID, SUM(TOTAL) as TOTAL
FROM INVOICE
natural join 
    (SELECT E.EMPLOYEEID, C.CUSTOMERID
    FROM CUSTOMER C
    JOIN EMPLOYEE E
    ON C.SUPPORTREPID = E.EMPLOYEEID)
GROUP BY EMPLOYEEID
ORDER BY TOTAL DESC
FETCH FIRST 1 ROWS ONLY;

-- Create a query which shows the number of purchases per genre, name of each genre and number of purchase, order by popularity
SELECT NAME, SUM(QUANTITY) AS NUM_PURCHASE
FROM GENRE
NATURAL JOIN(
SELECT QUANTITY, TRACKID, GENREID
FROM INVOICELINE
NATURAL JOIN TRACK)
GROUP BY NAME
ORDER BY NUM_PURCHASE DESC;

-- 4.0 SQL FUNCTIONS

-- 4.1 System Defined Functions
-- Create a function that return of the current time
CREATE OR REPLACE FUNCTION WHATTIMEISIT
RETURN VARCHAR2
IS
BEGIN
RETURN to_char(CURRENT_DATE, 'HH24:MI:SS');
END;
/
SET SERVEROUTPUT ON;

BEGIN
DBMS_OUTPUT.PUT_LINE(WHATTIMEISIT());
END;
/

-- Create a function that returns the length of the name in mediatype table
CREATE OR REPLACE FUNCTION LENGTHOFNAME
RETURN SYS_REFCURSOR
IS
l_RETURN SYS_REFCURSOR;
BEGIN
OPEN l_RETURN FOR
SELECT NAME, LENGTH(NAME)
FROM MEDIATYPE;
return l_RETURN;
END;
/

DECLARE
SVAR SYS_REFCURSOR;
TEMP_NAME  MEDIATYPE.NAME%TYPE;
TEMP_LENGTH NUMBER(20);
BEGIN
    SVAR := LENGTHOFNAME();
    LOOP
        FETCH SVAR INTO TEMP_NAME,TEMP_LENGTH;
    EXIT WHEN SVAR%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(TEMP_NAME||': '||TEMP_LENGTH);
END LOOP;
CLOSE SVAR;
END;
/

--  4.2 SYSTEM DEFINED AGGREGATE FUNCTIONS
-- Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION AVERAGEINVOICE
RETURN NUMBER
IS
TEMP_AVERAGE NUMBER;
BEGIN
    SELECT AVG(TOTAL) INTO TEMP_AVERAGE
    FROM INVOICE;
RETURN TEMP_AVERAGE;
END;
/

BEGIN
    DBMS_OUTPUT.PUT_LINE(AVERAGEINVOICE());
END;
/

-- Function that returns the most expensive track

CREATE OR REPLACE FUNCTION RETURNTRACK
RETURN SYS_REFCURSOR
IS
l_RETURN SYS_REFCURSOR;
BEGIN
    OPEN l_RETURN FOR
    SELECT NAME,unitprice
    FROM TRACK
    WHERE(
    SELECT MAX(UNITPRICE)
    FROM TRACK) = unitprice;
    RETURN l_RETURN;
END;
/


DECLARE
SVAR SYS_REFCURSOR;
TEMP_NAME  MEDIATYPE.NAME%TYPE;
TEMP_PRICE NUMBER(20);
BEGIN
    SVAR := RETURNTRACK();
    LOOP
        FETCH SVAR INTO TEMP_NAME,TEMP_PRICE;
        EXIT WHEN SVAR%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(TEMP_NAME||': '||TEMP_PRICE);
END LOOP;
CLOSE SVAR;
END;
/



-- 4.3 Defined scalar functions
-- Create a function that returns the average price of invoiceline items in the invoiceline
CREATE OR REPLACE FUNCTION AVERAGE
RETURN Number
IS
TEMP_SUM NUMBER := 0;
TEMP_COUNTER NUMBER := 0;
BEGIN
FOR PRICE IN (SELECT UNITPRICE FROM INVOICELINE)
  LOOP
    temp_sum := temp_sum + price.unitprice;
    temp_counter := temp_counter +1;
  END LOOP;
return temp_sum/temp_counter;
END;
/

begin
    dbms_output.put_line(average());
end;
/

-- 4.4 User defined table valued functions
-- create a function that returns all employees