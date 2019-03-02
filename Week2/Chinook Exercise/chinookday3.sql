SET SERVEROUTPUT ON;
---------------------------------------------------------
--                     4.1
----------------------------------------------------------

-- 4.1 a
-- Create a function that returns the current time.
CREATE OR REPLACE FUNCTION RETURN_TIME
RETURN VARCHAR2
IS
BEGIN 
    RETURN CURRENT_TIMESTAMP;
END;
/

BEGIN
    DBMS_OUTPUT.PUT_LINE('The Current time is: '||RETURN_TIME());
END;
/

--  4.1 b
-- create a function that returns the length of name in MEDIATYPE table
create or replace function name_length
return sys_refcursor
is S sys_refcursor;
begin
    open S for
    select m1.NAME, length(m2.NAME) as length from chinook.MEDIATYPE m1, chinook.MEDIATYPE m2;
    return S;
end;
/

declare
    svar sys_refcursor := name_length;
    temp_name chinook.MEDIATYPE.NAME%type;
    temp_length chinook.MEDIATYPE.NAME%type;
begin
    loop
        fetch svar into temp_name, temp_length;
        exit when svar%notfound;
        dbms_output.put_line(temp_name||' has a length of '||temp_length);
    end loop;
    close svar;
end;
/

---------------------------------------------------------
--                     4.2
---------------------------------------------------------
-- Create a function that returns the average total of all invoices

-- 4.2 a
create or replace function avg_invoice_total
return number as avgTotal Number;

begin
    select avg(total) into avgTotal from chinook.invoice;
    return avgTotal;
end;
/

begin
    dbms_output.put_line('The average total of invoices is: '||avg_invoice_total());
end;
/

-- 4.2 b
-- Create a function that returns the most expensive track
create or replace function most_expensive_track
return number as unitPrice Number;

begin
    select max(UNITPRICE) into unitPrice from chinook.track;
    return unitPrice;
end;
/

begin
    dbms_output.put_line('The most expensive track is: '||most_expensive_track());
end;
/

---------------------------------------------------------
--                     4.3
---------------------------------------------------------

--- 4.3 a
-- Create a function that returns the average price of invoiceline items in the invoiceline table
create or replace function avg_invoiceline_price
return number as avgPrice Number;

begin
    select avg(UNITPRICE) into avgPrice from chinook.invoiceline;
    return avgPrice;
end;
/

begin
    dbms_output.put_line('The average invoiceline price is: '||avg_invoiceline_price());
end;
/


---------------------------------------------------------
--                     4.4
---------------------------------------------------------
--- 4.4 a
-- Create a function that returns all employees who are born after 1968.
create or replace function employees_after_1968
return sys_refcursor
is S sys_refcursor;
begin
    OPEN S FOR
    select e.BIRTHDATE, e.FIRSTNAME, e.LASTNAME  from chinook.EMPLOYEE e where e.BIRTHDATE > '31-DEC-68';
    RETURN S;
END;
/

declare
    svar sys_refcursor := employees_after_1968;
    temp_dob chinook.employee.BIRTHDATE%type;
    temp_first chinook.employee.FIRSTNAME%type;
    temp_last chinook.employee.LASTNAME%type;
begin
    loop
        fetch svar into temp_dob, temp_first, temp_last;
        exit when svar%notfound;
        dbms_output.put_line('Employee: '||temp_first||' '||temp_last||'  DOB: '||temp_dob);
    end loop;
    close svar;
end;
/


----------------------------------------------------------------------------------
--                         Stored Procedures
----------------------------------------------------------------------------------

-- In this section you will be creating and executing stored procedures. You will be creating various 
-- types of stored procedures that take input and output parameters.

---------------------------------------------------------
--                     5.1
---------------------------------------------------------

-- 5.1a
-- Create a stored procedure that selects the first and last names of all the employees.
create or replace procedure 
get_full_name(s out sys_refcursor) as
begin
    open s for
    select e.firstname, e.lastname from chinook.employee e;
end;
/

declare
    s sys_refcursor;
    temp_first chinook.employee.firstname%type;
    temp_last chinook.employee.lastname%type;
begin
    get_full_name(s);
    loop
        fetch s into temp_first, temp_last;
        exit when s%notfound;
        dbms_output.put_line('Employee: '||temp_first||' '||temp_last);
    end loop;
    close s;
end;
/


---------------------------------------------------------
--                     5.2
---------------------------------------------------------

--- 5.2 a
-- Create a stored procedure that updates the personal information of an employee.
create or replace procedure 
update_info(s out sys_refcursor) as
begin
    open s for
    select e.TITLE from chinook.employee e;
end;
/

declare
    s sys_refcursor;
    temp_title chinook.employee.title%type;
begin
    update chinook.employee e
    set e.TITLE = 'BOSS MAN'
    where e.EMPLOYEEID = 7;
    update_info(s);
    fetch s into temp_title;
    
    close s;
end;
/

--- 5.2 b
-- Create a stored procedure that returns the managers of an employee.
create or replace procedure 
get_manager(s out sys_refcursor) as
begin
    open s for
    select e1.FIRSTNAME, e2.FIRSTNAME from chinook.employee e1, chinook.employee e2
    where e2.EMPLOYEEID = e1.REPORTSTO;
end;
/

declare
    s sys_refcursor;
    temp_employee chinook.employee.FIRSTNAME%type;
    temp_manager chinook.employee.FIRSTNAME%type;
begin
     get_manager(s);
    loop
        fetch s into temp_employee, temp_manager;
        exit when s%notfound;
        dbms_output.put_line(temp_employee|| ' manager is '||temp_manager);
    end loop;
    close s;
end;
/


---------------------------------------------------------
--                     5.3
---------------------------------------------------------

-- 5.3 a
-- Create a stored procedure that returns the name and company of a customer.
create or replace procedure 
get_company_name(s out sys_refcursor) as
begin
    open s for
    select c.FIRSTNAME, c.COMPANY from chinook.CUSTOMER c
    where c.COMPANY is not null;
end;
/

declare
    s sys_refcursor;
    temp_employee chinook.CUSTOMER.FIRSTNAME%type;
    temp_company chinook.CUSTOMER.COMPANY%type;
begin
     get_company_name(s);
    loop
        fetch s into temp_employee, temp_company;
        exit when s%notfound;
        dbms_output.put_line(temp_employee|| ' worked at '||temp_company);
    end loop;
    close s;
end;
/


---------------------------------------------------------
--                     6.0
---------------------------------------------------------

-- 6.0 a
-- Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE chinook.invoiceline
drop CONSTRAINT FK_INVOICELINEINVOICEID;
/

ALTER TABLE chinook.invoice
drop CONSTRAINT FK_INVOICECUSTOMERID;
/

create or replace procedure 
delete_invoice (invoice_ID in chinook.INVOICE.INVOICEID%TYPE)
is
begin
    delete from chinook.invoice inv
    where inv.INVOICEID = invoice_ID;
end;
/
    
begin
    delete_invoice(12);
end;
/

-- 6.0 b
-- Create a transaction nested within a stored procedure that inserts a new record in the Customer table
create or replace procedure 
insert_customer(s out sys_refcursor) as
begin
    open s for
    select c.CUSTOMERID, c.firstname, c.lastname, c.email from chinook.CUSTOMER c;
end;
/

declare
    s sys_refcursor;
    temp_id chinook.customer.CUSTOMERID%type;
    temp_firstname chinook.customer.firstname%type;
    temp_lastname chinook.customer.lastname%type;
    temp_email chinook.customer.email%type;

    
begin
    insert into chinook.customer c (c.CUSTOMERID, c.firstname, c.lastname, c.email)
    values (90, 'Michael', 'Jordan', 'Jordan23@gmail.com');
    insert_customer(s);
    fetch s into temp_id, temp_firstname, temp_lastname, temp_email;
    close s;
end;
/
---------------------------------------------------------
--                     7.1
---------------------------------------------------------

-- 7.1 a
-- Create an after insert trigger on the employee table fired after a new record is inserted into the table.
create or replace trigger insert_emp_trigger
after insert on CHINOOK.EMPLOYEE
for each row
declare
begin
dbms_output.put_line('EMPLOYEE INSERTED!!!!!!!!!!!');
end;
/

INSERT INTO CHINOOK.EMPLOYEE VALUES (27, 'HARDEN', 'JAMES', 'CLUTCH', NULL, DATE '1999-05-18', DATE '2018-01-14', 541234, 'DALLAS', 'TX', 'USA', 11444, 3577424976, NULL, 'JHARDEN@GMAIL.COM');

--7.1 b
-- Create an after update trigger on the album table that fires after a row is inserted in the table
create or replace trigger update_album_trigger
after update on CHINOOK.ALBUM
for each row
declare
begin
dbms_output.put_line('ALBUM UPDATED!!!!!!!!!!!');
end;
/

update chinook.album A
set title = 'Scorpion'
where A.ALBUMID = 2;

-- 7.1 c
-- Create an after delete trigger on the customer table that fires after a row is deleted from the table.
create or replace trigger delete_cust_trigger
after delete on CHINOOK.CUSTOMER
for each row
declare
begin
dbms_output.put_line('CUSTOMER DELETED!!!!!!!!!');
end;
/

delete from chinook.customer c
where c.CUSTOMERID = 75;
