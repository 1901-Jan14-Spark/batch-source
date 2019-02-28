--2.0 Queries and DML

--2.1 SELECT
--Select all records from the Employee table.
SELECT *
FROM CHINOOK.EMPLOYEE;

--Select all records from the Employee table where last name is King.
SELECT *
FROM CHINOOK.EMPLOYEE E
WHERE E.LASTNAME = 'King';

--Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT *
FROM CHINOOK.EMPLOYEE E
WHERE E.FIRSTNAME = 'Andrew'
UNION
SELECT *
FROM CHINOOK.EMPLOYEE E
WHERE E.REPORTSTO IS NULL;

--Select all albums in Album table and sort result set in descending order by title.
SELECT *
FROM CHINOOK.ALBUM A
ORDER BY A.TITLE DESC;

--Select first name from Customer and sort result set in ascending order by city.
SELECT C.FIRSTNAME
FROM CHINOOK.CUSTOMER C
ORDER BY C.CITY ASC;

--Select all invoices with a billing address like “T%”
SELECT *
FROM CHINOOK.INVOICE I
WHERE I.BILLINGADDRESS LIKE 'T%';


--2.3 INSERT INTO
--Insert two new records into Genre table
INSERT INTO CHINOOK.GENRE VALUES(99928, 'Instrumental Lo-Fi Trap');
INSERT INTO CHINOOK.GENRE VALUES(99929, 'Deep Net Blues');

--Insert two new records into Employee table
INSERT INTO CHINOOK.Employee VALUES (16, 'Alfonzo', 'Shimothy', 'Janitor', NULL, TO_DATE('1995-08-21 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2014-8-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '1600 Spring Gate Dr.', 'Glen Allen', 'VA', 'United States', '22102', '+1 (804) 800-0765', '+1 (999) 999-9999', 'alfonzoshimothy@gmail.com');
INSERT INTO CHINOOK.Employee VALUES (17, 'Bruce', 'Lee', 'Bouncer', NULL, TO_DATE('1940-11-27 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2002-5-1 00:00:00','yyyy-mm-dd hh24:mi:ss'), '1110 Dojo St.', 'Mountains', 'BD', 'China', '5318008', '+1 (403) 262-3443', '+1 (403) 262-3322', 'realbrucelee@gmail.com');


--Insert two new records into Customer table 
INSERT INTO chinook.Customer VALUES (673, 'Shannon', 'Gracer', 'FishAndSticks', '1729 Estadon Dr.', 'Wild County', 'MA', 'United States', '23723', '+49 0711 2842222', '+55 (12) 3923-5555', 'shannonannon@gmail.com', 3);
INSERT INTO chinook.Customer VALUES (673, 'Leona', 'Support', 'qwerULTIMATE', '1234 Mana Pot', 'Wings', NULL, 'Turkey', '70174', '+49 0711 2842222', '+55 (12) 3923-5555', 'ultfordays@gmail.com', 5);


--2.4 UPDATE
--Update Aaron Mitchell in Customer table to Robert Walter
update chinook.customer c
set c.firstname = 'Robert', c.lastname = 'Walkter'
WHERE c.firstname = 'Aaron' AND c.lastname = 'Mitchell';

--Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
update chinook.artist a
set a.name = 'CCR'
where a.name = 'Creedence Clearwater Revival';


--3.0 Joins
--In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--3.1 INNER
--Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select c.customerId, i.invoiceId
from chinook.customer c
inner join chinook.invoice i
on i.customerId = c.customerid;

--3.2 OUTER
--Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
select c.customerId, c.firstname, c.lastname, i.invoiceId, i.total
from chinook.customer c
right outer join chinook.invoice i
on c.customerid = i.customerid;

--3.3 RIGHT
--Create a right join that joins album and artist specifying artist name and title.
select ar.name, al.title
from chinook.album al
right join chinook.artist ar
on al.artistid = ar.artistid;

--3.4 CROSS
--Create a cross join that joins album and artist and sorts by artist name in ascending order.
select ar.name
from chinook.artist ar
cross join chinook.album al
where ar.artistid = al.artistid
order by ar.name ASC;

--3.5 SELF
--Perform a self-join on the employee table, joining on the reportsto column.
select e1.employeeid, e1.reportsto
from chinook.employee e1;

--3.6 Joined Queries
--Create a query that shows the customer first name and last name as FULL_NAME with the total amount of money they have spent as TOTAL.
select (c.firstname||c.lastname) as full_name, sum(i.total) as total
from chinook.customer c, chinook.invoice i
where i.customerid = c.customerid
group by (c.firstname||c.lastname);

--Create a query that shows the employee that has made the highest number of sales (number of invoices).
select e.employeeid, count(i.invoiceid)
from chinook.invoice i, chinook.customer c, chinook.employee e
where i.customerid = c.customerid AND c.supportrepid = e.employeeid
group by e.employeeid
order by count(i.invoiceid) desc
fetch first 1 rows only;

SELECT e.employeeid, COUNT(i.INVOICEID)
FROM chinook.INVOICE i
JOIN chinook.CUSTOMER c ON i.CUSTOMERID = c.CUSTOMERID
JOIN CHINOOK.employee e ON e.EMPLOYEEID = c.SUPPORTREPID
GROUP BY e.EMPLOYEEID;

--Create a query which shows the number of purchases per each genre. Display the name of each genre and number of purchases. Show the most popular genre first.
select g.name, sum(inv.invoiceid)
from chinook.customer c, chinook.invoice inv, chinook.invoiceline invl, chinook.track t, chinook.genre g
where c.customerid = inv.invoiceid and inv.invoiceid = invl.invoiceid and invl.trackid = t.trackid and t.genreid = g.genreid
group by g.name
order by sum(inv.invoiceid) desc;