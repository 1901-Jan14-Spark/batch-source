set serveroutput on;

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

--4.0 SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database

--4.1 System Defined Functions
-- Create a function that returns the current time.
create or replace function print_date
return date
is
begin
    return sysdate;
end;
/

begin
    dbms_output.put_line(print_date);
end;
/

--create a function that returns the length of name in MEDIATYPE table
create or replace function name_length(x varchar2)
return number
is
begin
    return length(x);
end;
/

select m.name, name_length(m.name)
from chinook.mediatype m;

--4.2 System Defined Aggregate Functions
--Create a function that returns the average total of all invoices 
create or replace function total_average
return number
is
average number;
begin
    select avg(i.total)
    into average
    from chinook.invoice i;
    return average;
end;
/

begin
    dbms_output.put_line(total_average);
end;
/

--Create a function that returns the most expensive track
create or replace function most_expensive
return number
is
trackid number;
begin
    select t.unitprice
    into trackid
    from chinook.track t
    order by unitprice desc
    fetch first 1 rows only;
    return trackid;
end;
/

begin
    dbms_output.put_line(most_expensive);
end;
/

--4.3 User Defined Scalar Functions
-- Create a function that returns the average price of invoiceline items in the invoiceline table
create or replace function average_price_invocieline
return number
is
average number;
begin
    select avg(i.unitprice)
    into average
    from chinook.invoiceline i;
    return average; 
end;
/

begin
    dbms_output.put_line(average_price_invocieline);
end;
/

--4.4 User Defined Table Valued Functions
--Create a function that returns all employees who are born after 1968.

create or replace function born_after_1968
return sys_refcursor
is
motal sys_refcursor;
begin
    open motal for
    select e.employeeid, e.firstname, e.lastname
    from chinook.employee e
    where e.birthdate > '31-DEC-68';
    return motal;
end;
/

declare
    svar sys_refcursor := born_after_1968;
    temp_id chinook.employee.employeeid%type;
    temp_first chinook.employee.firstname%type;
    temp_last chinook.employee.lastname%type;
begin
    loop
        fetch svar into temp_id, temp_first, temp_last;
        exit when svar%notfound;
        dbms_output.put_line('Employee '||temp_id||': '||temp_first||' '||temp_last);
    end loop;
    close svar;
end;
/

--5.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--5.1 Basic Stored Procedure
--Create a stored procedure that selects the first and last names of all the employees
create or replace procedure first_last(s out sys_refcursor)
is
begin
    open s for
    select e.firstname, e.lastname from chinook.employee e;
end;
/

declare
    svar sys_refcursor;
    temp_first chinook.employee.firstname%type;
    temp_last chinook.employee.lastname%type;
begin
    first_last(svar);
    loop
        fetch svar into temp_first, temp_last;
        exit when svar%notfound;
        dbms_output.put_line('Employee: '||temp_first||' '||temp_last);
    end loop;
    close svar;
end;
/

--5.2 Stored Procedure Input Parameters
--Create a stored procedure that updates the personal information of an employee.
create or replace procedure update_lastname_employee(employeeid chinook.employee.employeeid%type, newname chinook.employee.lastname%type)
is
begin
    update chinook.employee e
    set e.lastname = newname
    where e.employeeid = employeeid;
    commit;
end;
/

begin
    update_lastname_employee(1, 'Adurms');
end;
/

--Create a stored procedure that returns the managers of an employee.
create or replace procedure manager_of_employee(employee in number, s out sys_refcursor)
is
begin
    open s for
        select e.reportsto
        from chinook.employee e
        where e.employeeid = employee;
end;
/

declare
    svar sys_refcursor;
    temp_reportsto chinook.employee.reportsto%type;
    employeeid number := 2;
begin
    manager_of_employee(employeeid, svar);
    loop
        fetch svar into temp_reportsto;
        exit when svar%notfound;
        dbms_output.put_line('Employee: '||employeeid||' reports to '||temp_reportsto);
    end loop;
    close svar;
end;
/

--5.3 Stored Procedure Output Parameters
--Create a stored procedure that returns the name and company of a customer.
create or replace procedure name_company(customer in number, s out sys_refcursor)
is
begin
    open s for
        select (c.firstname||' '||c.lastname), c.company
        from chinook.customer c
        where c.customerid = customer;
end;
/

declare
    svar sys_refcursor;
    temp_name chinook.customer.firstname%type;
    temp_company chinook.customer.company%type;
    customerid number := 1;
begin
    name_company(customerid, svar);
    loop
        fetch svar into temp_name, temp_company;
        exit when svar%notfound;
        dbms_output.put_line('Customer: '||customerid||' has name '||temp_name||' and Company: '||temp_company);
    end loop;
    close svar;
end;
/

--6.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
--Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).

alter table chinook.invoice
    drop constraint invoiceid;

create or replace procedure drop_invoice(invoiceid in number)
is
begin
    delete
    from chinook.invoice i
    where i.invoiceid = invoiceid;
    commit;
end;
/


--Create a transaction nested within a stored procedure that inserts a new record in the Customer table

create or replace procedure insert_customer(s out sys_refcursor)
as
begin
    open s for
    select c.customerid, c.firstname, c.lastname, c.email
    from chinook.customer c;
end;
/

--7.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--7.1 AFTER/FOR
--Create an after insert trigger on the employee table fired after a new record is inserted into the table.
create or replace trigger tr_insert_employee
after insert on chinook.employee
for each row
begin
    dbms_output.put_line('Employee Successfully Inserted');
end;
/


--Create an after update trigger on the album table that fires after a row is inserted in the table.
create or replace trigger tr_update_album
after update on chinook.album
for each row
begin
    dbms_output.put_line('Album Successfully Updated');
end;
/

--Create an after delete trigger on the customer table that fires after a row is deleted from the table.
create or replace trigger on tr_delete_customer
after delete on chinook.customer
for each row
begin
    dbms_output.put_line('Customer Successfully Deleted');
end;
/

