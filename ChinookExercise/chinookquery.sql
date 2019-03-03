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
-- create a function that returns all employees born after 1968

CREATE OR REPLACE FUNCTION RETURNEMPLOYEE
RETURN SYS_REFCURSOR
IS
RetCursor SYS_REFCURSOR;
BEGIN
OPEN RetCursor FOR
SELECT FIRSTNAME||LASTNAME AS FULLNAME, BIRTHDATE
FROM EMPLOYEE
WHERE BIRTHDATE > DATE '1968-12-31';
Return retcursor;
END;
/

DECLARE
SVAR SYS_REFCURSOR;
EMP_NAME VARCHAR2(20);
EMP_BIRTHDAY DATE;
BEGIN
    svar := returnemployee();
    LOOP
        FETCH SVAR INTO EMP_NAME,EMP_BIRTHDAY;
        EXIT WHEN SVAR%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(EMP_NAME||'is born on: '||EMP_BIRTHDAY);
    END LOOP;
    CLOSE SVAR;
END;
/   

-- 5.0 Stored procedure

-- 5.1 Procedure that selects the first and last names of all of the employees
Create or replace procedure getemployeename (s out sys_refcursor)
is
begin
    open s for
        SELECT FIRSTNAME, LASTNAME
        FROM EMPLOYEE;
end;
/

set serveroutput on;

declare
sout sys_refcursor;
temp_fname employee.firstname%type;
temp_lname employee.lastname%type;
begin
    getemployeename(sout);
    loop
        fetch sout into temp_fname, temp_lname;
        exit when sout%notfound;
        dbms_output.put_line(temp_fname||' '|| temp_lname);
    end loop;
    close sout;
end;
/
    
-- 5.2 Stored Procedure Input parameters

-- Stored procedure that updates the personal information of an employee

Create or replace procedure updateEmployee ( 
    eid in employee.employeeid%type, 
    fname in employee.firstname%type default null, 
    lname in employee.lastname%type default null,
    ebirthdate in employee.birthdate%type default null, 
    eaddress in employee.address%type default null, 
    ecity in employee.city%type default null,
    estate in employee.state%type default null, 
    ecountry in employee.country%type default null, 
   epostalcode in employee.postalcode%type default null, 
    ephone in employee.phone%type default null,
    efax in employee.fax%type default null, 
    empemail in employee.email%type default null)
    is
    begin
    update employee
    set 
        firstname = NVL(fname,firstname), 
        lastname =nvl(lname,lastname),
        birthdate = nvl(ebirthdate, birthdate), 
        address = nvl(eaddress, address), 
        city = nvl(ecity, city),
        state  = nvl(estate, state), 
        country  = nvl(ecountry, country), 
        postalcode = nvl(epostalcode, postalcode), 
        phone  = nvl(ephone, phone),
        fax  = nvl(efax, fax), 
        email  = nvl(empemail, email)
    where employeeid = eid;
    end;
    /
    
    begin
    updateemployee(eid => 10, lname => 'hi');
    end;
    
    -- Tester
    Select *
    from employee;
    
-- Create stored procedure that returns the manager of an employee
Create or replace procedure getManager(eid in employee.employeeid%type, mcursor out sys_refcursor)
is
begin
open mcursor for
SELECT E1.employeeid, E2.employeeid as managerid, e2.firstname || '  ' ||e2.lastname as fullname
FROM EMPLOYEE E1
JOIN EMPLOYEE E2
ON E1.REPORTSTO = E2.EMPLOYEEID
where eid = e1.employeeid;
end;
/

set serveroutput on;

declare 
vcurs sys_refcursor;
temp_empid employee.employeeid%type;
temp_manid employee.employeeid%type;
temp_manName varchar2(100);
begin
getManager(eid => 2, mcursor => vcurs);
loop
    fetch vcurs into temp_empid, temp_manid, temp_Manname;
    exit when vcurs%notfound;
    dbms_output.put_line('Employee '|| temp_empid ||' reports to: '||temp_manid|| ' '||temp_manname);
end loop;
close vcurs;
end;
/

-- 5.3 Stored output parameter

-- Stored procedure that returns the name and company of a customer

Create or replace procedure getCompany(cid in customer.customerID%type, fullname out varchar2, comp_name out customer.company%type)
is
begin
    Select firstname || ' ' || lastname, company into fullname, comp_name
    from Customer
    where cid = customerID;
    comp_name := nvl (comp_name, 'Not Provided');
end;
/

declare
fname varchar2(100);
company varchar2(100);
begin
getCompany(2,fname,company);
dbms_output.put_line('Customer name: ' || fname||' Company name: '|| company);
end;
/

-- 6.0 Transactions

-- Transaction that deletes an invoice given its id

commit;

Create or replace procedure deleteinvoice(inid in invoice.invoiceid%type)
is
begin
-- Oracle has implicit rollbacks when exception occur
delete from invoiceline
where invoiceid = inid;
delete from invoice
where invoiceid = inid;
commit;
end;
/

begin
deleteinvoice(216);
end;
/

Select *
from invoice
where invoiceid =216;

Select * 
from invoiceline 
where invoiceid = 216;

-- Transaction that inserts a new record into the Customer table
CREATE SEQUENCE customers_seq
 START WITH     63
 INCREMENT BY   1;

Create or replace procedure createCustomer(
    cfname in customer.firstname%type default null,
    clname in customer.lastname%type default null,
    ccompany in customer.company%type default null,
    caddress in customer.address%type default null,
    ccity in customer.city%type default null,
    cstate in customer.state%type default null,
    ccountry in customer.country%type default null,
    cpostalcode in customer.postalcode%type default null,
    cphone in customer.phone%type default null,
    cfax in customer.fax%type default null,
    cemail in customer.email%type default null,
    csupportrepid customer.email%type default null
    )
    is
    begin
    insert into customer (customerid, firstname, lastname, company, address,city, state, country, postalcode, phone,
    fax, email, supportrepid) values(CUSTOMERS_SEQ.nextval, cfname, clname, ccompany, caddress, ccity, cstate, ccountry, cpostalcode, cphone, cfax, cemail, csupportrepid);
    end;
    /
    
    begin
    createCustomer(cfname => 'kevin', clname => 'tran', cemail => 'hello@gmail.com');
    end;
    /

-- 7.0 Triggers

-- After insert trigger on employee table
Set serveroutput on;

CREATE OR REPLACE TRIGGER Print_New_Employee
  AFTER INSERT ON Employee
  FOR EACH ROW
BEGIN
    dbms_output.put_line('New employee added');
END;
/

INSERT INTO EMPLOYEE VALUES(11, 'Mack', 'Mick', 'Web Browser', 2, DATE '1978-05-15', DATE '2018-02-25', '123 Road St', 'SomeCity', 'AB', 'Canada', 'T3P 5M5', '+1 (123) 456 7890', '+1 (123) 456 7891', 'miik@chinookcorp.com'); 

-- After update trigger album table
CREATE OR REPLACE TRIGGER Print_Update_Album
  AFTER UPDATE ON ALBUM
  FOR EACH ROW
BEGIN
    dbms_output.put_line('Album updated');
END;
/

-- After delete trigger on Customer table

CREATE OR REPLACE TRIGGER Print_Delete_Customer
  AFTER delete ON Customer
  FOR EACH ROW
BEGIN
    dbms_output.put_line('Customer deleted');
END;
/