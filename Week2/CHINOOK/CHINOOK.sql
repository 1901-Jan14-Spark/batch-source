--a Select all records from the Employee table.
--select * 
--FROM CHINOOK.EMPLOYEE;

--b Select all records from the Employee table where last name is King.
--select * 
--FROM CHINOOK.EMPLOYEE
--WHERE LASTNAME = 'King';

--c Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL
--select * 
--FROM CHINOOK.EMPLOYEE
--WHERE firstname = 'Andrew' AND  REPORTSTO is NULL ;


--d Select all albums in Album table and sort result set in descending order by title.
--select * 
--FROM CHINOOK.album
--order by title desc;

--e Select first name from Customer and sort result set in ascending order by city.
--select *
--from CHINOOK.customer
--order by city asc;

--f Select all invoices with a billing address like “T%”
--select *
--from CHINOOK.invoice
--where billingaddress like 'T%';

--2.2 INSERT INTO

--a Insert two new records into Genre table

--INSERT INTO chinook.genre(genreid, name) VALUES ('26', 'international');
--INSERT INTO chinook.genre (genreid, name) VALUES ('27', 'african')

--b Insert two new records into Employee tabler
-- INSERT INTO "CHINOOK"."EMPLOYEE" (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL) VALUES ('9', 'James', 'Brown', 'Overlord', '7', TO_DATE('1980-01-09 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2002-02-08 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '3498 SOMEWHERE STREET', 'RESTON', 'VA', 'CANADA', 'T1H 1Y8', '+1 (403) 234-3351', '+1 (403) 367-8772', 'JBrown@chinookcorp.com')
--INSERT INTO "CHINOOK"."EMPLOYEE" (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL) VALUES ('10', 'Sponge', 'Bob', 'cook', '2', TO_DATE('1985-03-04 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2010-02-05 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '3008 elmer STREET', 'RESTON', 'VA', 'CANADA', 'T1H 1Y8', '+1 (403) 234-3351', '+1 (403) 367-8772', 'kk@chinookcorp.com')

--c Insert two new records into Customer table
--INSERT INTO "CHINOOK"."CUSTOMER" (CUSTOMERID, FIRSTNAME, LASTNAME, ADDRESS, CITY, POSTALCODE, PHONE, EMAIL, SUPPORTREPID) VALUES ('60', 'Krabs', 'penny', '398 kk street', 'bikini', '20302', '+28 233 32233323', 'lovemonet@aol.com', '3')
--INSERT INTO "CHINOOK"."CUSTOMER" (CUSTOMERID, FIRSTNAME, LASTNAME, ADDRESS, CITY, STATE, POSTALCODE, PHONE, EMAIL, SUPPORTREPID) VALUES ('61', 'squid', 'berg', '239 annoyed st', 'bikini', '(null', '29032', '+39 238 329293992', 'squid', '4')

--2.3 UPDATE
--a Update Aaron Mitchell in Customer table to Robert Walter
-- UPDATE CHINOOK.customer SET firstname = 'Robert', lastname = 'Walter' where firstname = 'Aaron'and lastname = 'Mitchell' ;

--b
--Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
--update chinook.artist set name = 'ccr' where name = 'Creedence Clearwater Revival';

--3.0 Joins
--In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--3.1a Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
--select chinook.customer.CUSTOMERID, chinook.customer.LASTNAME, chinook.invoice.invoiceid
--from chinook.customer
--inner join chinook.invoice
--on chinook.customer.customerid = CHINOOK.invoice.INVOICEID;

--3.2
--Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
--select chinook.customer.CUSTOMERID, chinook.customer.FIRSTNAME, chinook.customer.LASTNAME, chinook.invoice.invoiceid, chinook.invoice.total
--from chinook.customer
--left join chinook.invoice
--on chinook.customer.customerid = CHINOOK.invoice.INVOICEID;

--3.3 Create a right join that joins album and artist specifying artist name and title.
--select chinook.artist.name, chinook.album.TITLE
--from chinook.album
--right join CHINOOK.artist
--on chinook.album.albumid = chinook.artist.artistid


----3.4 Create a cross join that joins album and artist and sorts by artist name in ascending order.
--select *
--from chinook.album
--cross join CHINOOK.artist
--order by chinook.artist.name asc

--3.5 Perform a self-join on the employee table, joining on the reportsto column.

--select chinook.mng.EMPLOYEEID, chinook.mng.FIRSTNAME, chinook.mng.LASTNAME,
--chinook.emp.EMPLOYEEID,chinook.emp.LASTNAME ,chinook.emp.FIRSTNAME
--from chinook.employee emp
--right join chinook.employee mng on chinook.emp.EMPLOYEEID = chinook.mng.reportsto
--order by mng.EMPLOYEEID asc;



--3.6 Joined Queries
--Create a query that shows the customer first name and last name as FULL_NAME with the total amount of money they have spent as TOTAL.
--select concat(chinook.CUSTOMER.FIRSTNAME ,concat(' ', chinook.CUSTOMER.LASTNAME)) AS full_name, SUM(chinook.invoice.TOTAL)AS Total
--from chinook.customer
--  join chinook.invoice on chinook.customer.CUSTOMERID = chinook.invoice.CUSTOMERID
-- group by chinook.CUSTOMER.FIRSTNAME, chinook.CUSTOMER.LASTNAME;
 
 
--b Create a query that shows the employee that has made the highest total value of sales (total of all invoices).
--select CHINOOK.invoiceline.invoiceid,CHINOOK.invoice.invoiceid, SUM(CHINOOK.invoice.total)as total, CHINOOK.customer.SUPPORTREPID
--from CHINOOK.invoiceline
--inner join CHINOOK.invoice
--on  CHINOOK.invoiceline.invoiceid = CHINOOK.invoice.invoiceid
--inner join CHINOOK.customer
--on  CHINOOK.invoice.invoiceid = CHINOOK.customer.SUPPORTREPID
--group by CHINOOK.invoiceline.invoiceid,CHINOOK.invoice.invoiceid,CHINOOK.customer.SUPPORTREPID
--order by CHINOOK.invoice.invoiceid desc; -- the biggest is the top 

--Create a query which shows the number of purchases per each genre. Display the name of each genre and number of purchases. Show the most popular genre first.
--select CHINOOK.genre.GENREID, SUM(CHINOOK.INVOICELINE.quantity)
--from CHINOOK.genre
-- join chinook.track
--on CHINOOK.track.GENREID = CHINOOK.genre.GENREID
-- join CHINOOK.INVOICELINE
-- on CHINOOK.track.GENREID = CHINOOK.invoiceline.TRACKID
--group by CHINOOK.genre.GENREID
--order by CHINOOK.genre.GENREID  ASC;


--4.0 SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database

--4.1 System Defined Functions
 --Create a function that returns the current time.
 
-- BEGIN 
--    DBMS_OUTPUT.PUT_LINE(CURRENT_TIMESTAMP);
--END;
--/

SET SERVEROUTPUT ON;
--b create a function that returns the length of name in MEDIATYPE table



create or replace function tableLength(arg varchar2)
return varchar2
is
BEGIN
return length(arg);
end;
/


--4.2 System Defined Aggregate Functions
--a Create a function that returns the average total of all invoices 


CREATE OR REPLACE FUNCTION averageofTotal RETURN NUMBER
IS 
  avg_total NUMBER;
BEGIN
   SELECT AVG(chinook.INVOICE.total) 
  INTO   avg_total
  FROM   chinook.INVOICE;


    RETURN avg_total;
END;
/

SET SERVEROUTPUT ON;
BEGIN
    DBMS_OUTPUT.PUT_LINE(averageofTotal());
END;

--b Create a function that returns the most expensive track


CREATE OR REPLACE FUNCTION maxNumber RETURN NUMBER
IS 
  max_price NUMBER;
BEGIN
   select  max(chinook.track.unitprice)
  INTO   max_price
  from chinook.track;


    RETURN max_price;
END;
/

SET SERVEROUTPUT ON;
BEGIN
    DBMS_OUTPUT.PUT_LINE(maxNumber());
END;


--4.3 User Defined Scalar Functions
--a Create a function that returns the average price of invoiceline items in the invoiceline table


CREATE OR REPLACE FUNCTION averageUnitPrice RETURN NUMBER
IS 
  avg_price NUMBER;
BEGIN
   select avg(chinook.invoiceline.unitprice)
     INTO   avg_price
from chinook.invoiceline;

    RETURN avg_price;
END;
/

SET SERVEROUTPUT ON;
BEGIN
    DBMS_OUTPUT.PUT_LINE(averageUnitPrice());
END;


--4.4 User Defined Table Valued Functions
-- Create a function that returns all employees who are born after 1968.

CREATE OR REPLACE function GET_ALL_EMPLOYEES return SYS_REFCURSOR
IS
S  SYS_REFCURSOR;
BEGIN 
    OPEN S FOR
    SELECT  chinook.employee.employeeid,chinook.employee.firstname,chinook.employee.lastname
from chinook.employee
where chinook.employee.BIRTHDATE > DATE '1968-01-01';
return s;
END;
/

DECLARE
    SVAR SYS_REFCURSOR := GET_ALL_EMPLOYEES() ;
    TEMP_ID chinook.employee.EMPLOYEEID%TYPE;
    TEMP_NAME chinook.employee.firstname%TYPE;
    TEMP_LNAME chinook.employee.lastname%TYPE;
BEGIN 
   
    LOOP
        FETCH SVAR INTO TEMP_ID, TEMP_NAME,TEMP_LNAME;
        EXIT WHEN SVAR%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(TEMP_ID||' = ID, '||TEMP_NAME||' = First NAME '||TEMP_LNAME || ' = Last Name, ' );
    END LOOP;
    CLOSE SVAR;
END;
/


--5.0 Stored Procedures
 --In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--5.1 Basic Stored Procedure Create a stored procedure that selects the first and last names of all the employees.


CREATE OR REPLACE PROCEDURE first_Last_EMPLOYEES(S OUT SYS_REFCURSOR)
IS
BEGIN 
    OPEN S FOR
    SELECT chinook.employee.EMPLOYEEID, chinook.employee.FIRSTNAME , chinook.employee.LASTNAME FROM chinook.employee ORDER BY chinook.employee.EMPLOYEEID;
END;
/

DECLARE
    SVAR SYS_REFCURSOR;
    TEMP_ID chinook.employee.EMPLOYEEID%TYPE;
    TEMP_FNAME chinook.employee.FIRSTNAME%TYPE;
    TEMP_LNAME chinook.employee.LASTNAME%TYPE;
BEGIN 
    first_Last_EMPLOYEES(SVAR);
    LOOP
        FETCH SVAR INTO TEMP_ID,  TEMP_FNAME,TEMP_LNAME  ;
        EXIT WHEN SVAR%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(TEMP_ID||' IS CURRENT ID, '||TEMP_FNAME||' IS CURRENT NAME'||TEMP_LNAME||' IS CURRENT NAME');
    END LOOP;
    CLOSE SVAR;
END;
/


-- 5.2 Stored Procedure Input Parameters
--a) Create a stored procedure that updates the personal information of an employee.

--
--CREATE OR REPLACE PROCEDURE updateEmployee 
--(
--  THE_EMPLOYEEID IN NUMBER,
--  NEW_LASTNAME IN VARCHAR2,
--  NEW_FIRSTNAME IN VARCHAR2,
--  NEW_TITLE IN VARCHAR2,
--  NEW_REPORTSTO IN NUMBER,
-- -- NEW_BIRTHDATE IN DATE,
-- -- NEW_HIREDATE IN DATE,
--  NEW_ADDRESS IN VARCHAR2,
--  NEW_CITY IN VARCHAR2,
--  NEW_STATE IN VARCHAR2,
--  NEW_COUNTRY VARCHAR2,
--  NEW_POSTALCODE VARCHAR2,
--  NEW_PHONE VARCHAR2,
--  NEW_FAX VARCHAR2,
--  NEW_EMAIL VARCHAR2
--)
--AS 
--BEGIN
--  UPDATE EMPLOYEE
--  SET LASTNAME = NEW_LASTNAME,
--       
--     chinook.employee.FIRSTNAME = NEW_FIRSTNAME,
--      chinook.employee.TITLE = NEW_TITLE,
--      chinook.employee.REPORTSTO = NEW_REPORTSTO,
--    --  chinook.employee.BIRTHDATE = NEW_BIRTHDATE,
--    --  chinook.employee.HIREDATE = NEW_HIREDATE,
--      chinook.employee.ADDRESS = NEW_ADDRESS,
--      chinook.employee.CITY = NEW_CITY,
--      chinook.employee.STATE = NEW_STATE,
--      chinook.employee.COUNTRY = NEW_COUNTRY,
--      chinook.employee.POSTALCODE = NEW_POSTALCODE,
--      chinook.employee.PHONE = NEW_PHONE,
--      chinook.employee.FAX = NEW_FAX,
--      chinook.employee.EMAIL = NEW_EMAIL
--    WHERE chinook.employee.EMPLOYEEID = THE_EMPLOYEEID;
--END; 
--
--BEGIN
--    updateEmployee(8, 'George', 'Marahsal', 'HR guy', 9,'1111 6 Ave SW','RESTON','va', 'us','20707' , '+8 203 435-9476', '+7 301 234-234', 'george@gmu.com');
--END;
--
--SAVEPOINT UPDATEEMPLOYEE;
--COMMIT;



--b) Create a stored procedure that returns the managers of an employee.
SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE GET_FROM_DEPARTMENT(S OUT SYS_REFCURSOR, x number)
IS
BEGIN 
    OPEN S FOR 
select  chinook.employee.REPORTSTO 
from chinook.employee
where chinook.employee.EMPLOYEEID = x ;
  
END;
/

DECLARE
    SVAR SYS_REFCURSOR;
   
    TEMP_NAME chinook.employee.REPORTSTO%TYPE;
BEGIN 
    GET_FROM_DEPARTMENT(SVAR,6);
  --  LOOP
        FETCH SVAR INTO  TEMP_NAME;
       
        DBMS_OUTPUT.PUT_LINE(TEMP_NAME||' IS manager id');
       --   EXIT WHEN SVAR%NOTFOUND;
     --  END LOOP;

    CLOSE SVAR;
END;
/


--5.3 Stored Procedure Output Parameters
--Create a stored procedure that returns the name and company of a customer.


SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE customerNameCompanyFinder(
fName OUT varchar2,
cName OUT chinook.customer.COMPANY%TYPE ,
custId in number)
IS
BEGIN 
  

select  chinook.customer.firstname, chinook.customer.company into fName,cName
from chinook.customer
where chinook.customer.customerid = custId;

  
END;
/

DECLARE
  
   
    TEMP_fNAME chinook.customer.firstname%TYPE;
    TEMP_cNAME chinook.customer.COMPANY%TYPE;
    
BEGIN 
    customerNameCompanyFinder(TEMP_fNAME,TEMP_cNAME, 8);
    
       
        DBMS_OUTPUT.PUT_LINE(TEMP_fNAME||' has a company of, '||TEMP_cNAME||'');
   

    
END;
/

--6.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
--a) Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this,
--find out how to resolve them).
commit;

GRANT CREATE PROCEDURE TO ASSAYEAA;
SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE deleteInvoice(invoiceId in number)
IS
BEGIN 
  
DELETE  FROM chinook.invoiceline
WHERE  chinook.invoiceline.invoiceid =invoiceId;


DELETE  FROM chinook.invoice
WHERE  chinook.invoice.invoiceid =invoiceId;

END;
/

 begin 

  deleteInvoice(4);
  
    
END;
/


--Create a transaction nested within a stored procedure that inserts a new record in the Customer table

CREATE OR REPLACE PROCEDURE createNewCustomer(
employeeId NUMBER,
employeeLast VARCHAR2,
employeeFirst VARCHAR2,
employeeTitle VARCHAR2,
employeeId NUMBER,
employeeBirth DATE,
employeeHire DATE,
employeeAddress VARCHAR2,
employeeCity VARCHAR2,
employeeState VARCHAR2,
employeeCountry VARCHAR2,
employeeZip VARCHAR2,
employeeNum VARCHAR2,
employeeFax VARCHAR2,
employeeEmail VARCHAR2)
IS
BEGIN


INSERT INTO employee
VALUES(
employeeId ,
employeeLast ,
employeeFirst ,
employeeTitle ,
employeeId ,
employeeBirth ,
employeeHire ,
employeeAddress ,
employeeCity ,
employeeState ,
employeeCountry ,
employeeZip ,
employeeNum ,
employeeFax ,
employeeEmail );


END;
/

SET SERVEROUTPUT ON;
begin

 createNewCustomer(1001,'Rich', 'Forsted', 'Heart stopper',
3, DATE '2018-09-12', DATE '2018-10-20', '300 somewhere in va',
'Donuts', 'va', 'Canada', 20187, 
'44 (309) 434 2323','38 (430) 490 5903', 'donutsltd.sonuts.com');
    
END;
/


--7.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are
--executed on a table.
--7.1 AFTER/FOR
--Create an after insert trigger on the employee table fired after a new record is inserted into the table.

CREATE OR REPLACE TRIGGER employeeTableInserted
AFTER INSERT
   ON chinook.employee
   FOR EACH ROW


BEGIN
   dbms_output.put_line('action to be performed -employeeTableInserted gets called');
  

END;

/


begin

INSERT INTO chinook.EMPLOYEE VALUES(1001,'Rich', 'Forsted', 'Heart stopper',
3, DATE '2018-09-12', DATE '2018-10-20', '300 somewhere in va',
'Donuts', 'va', 'Canada', 20187, 
'44 (309) 434 2323','38 (430) 490 5903', 'donutsltd.sonuts.com');
    
END;
/
rollback;

--b Create an after update trigger on the album table that fires after a row is inserted in the table

CREATE OR REPLACE TRIGGER albumTableNewRwInserted
AFTER update
   ON chinook.album
   FOR EACH ROW


BEGIN
   dbms_output.put_line('update action performed -albumTableNewRwInserted gets called');
  

END;

/

--Create an after delete trigger on the customer table that fires after a row is deleted from the table.


CREATE OR REPLACE TRIGGER employeeTableRowDeleted
AFTER delete
   ON chinook.employee
   FOR EACH ROW


BEGIN
   dbms_output.put_line('delete action to be performed -employeeTableRowDeleted gets called');
  

END;

/


 begin 

  
DELETE  FROM chinook.employee
WHERE  chinook.employee.employeeid = 5;
  
    
END;
/

--what would happen up on employee deletion?
DELETE  FROM chinook.employee
WHERE  chinook.employee.employeeid = 5;