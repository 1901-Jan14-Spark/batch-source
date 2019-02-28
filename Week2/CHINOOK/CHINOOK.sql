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
--select emp.chinook.employee.EMPLOYEEID,chinook.emp.employee.FIRSTNAME, emp.chinook.employee.LASTNAME ,
--mng.chinook.employee.EMPLOYEEID, mng.chinook.employee.FIRSTNAME, mng.chinook.employee.LASTNAME
--from chinook.employee emp
--left join chinook.employee mng on chinook.emp.EMPLOYEEID = chinook.mng.EMPLOYEEID;

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
select CHINOOK.genre.GENREID, SUM(CHINOOK.INVOICELINE.quantity)
from CHINOOK.genre
 join chinook.track
on CHINOOK.track.GENREID = CHINOOK.genre.GENREID
 join CHINOOK.INVOICELINE
 on CHINOOK.track.GENREID = CHINOOK.invoiceline.TRACKID
group by CHINOOK.genre.GENREID
order by CHINOOK.genre.GENREID  ASC;
--4.0 SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database

--4.1 System Defined Functions
 --Create a function that returns the current time.
 
-- BEGIN 
--    DBMS_OUTPUT.PUT_LINE(CURRENT_TIMESTAMP);
--END;
--/


--b create a function that returns the length of name in MEDIATYPE table
--create or replace function mediaType
--return NUMBER

