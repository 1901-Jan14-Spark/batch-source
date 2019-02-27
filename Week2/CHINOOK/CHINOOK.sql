--a
--select * 
--FROM CHINOOK.EMPLOYEE;

--b
--select * 
--FROM CHINOOK.EMPLOYEE
--WHERE LASTNAME = 'King';

--c
select * 
FROM CHINOOK.EMPLOYEE
WHERE firstname = 'Andrew' AND REPORTSTO = NULL;
