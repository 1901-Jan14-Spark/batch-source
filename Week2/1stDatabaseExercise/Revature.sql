--SELECT * 
--FROM INVOICE
--WHERE  DATE_ = to_date('02-FEB-19', 'dd-mon-yy')

--SELECT CUSTOMER_ID, count(CUSTOMER_ID) 
--  FROM INVOICE 
-- GROUP by CUSTOMER_ID;


--SELECT CUSTOMER_ID, SUM(AMOUNT) 
--  FROM INVOICE 
-- GROUP by CUSTOMER_ID;


--SELECT CUSTOMER_ID 
--  FROM INVOICE 
-- WHERE DATE_  between  to_date('01-JAN-19', 'dd-mon-yy')
-- AND to_date('31-JAN-19', 'dd-mon-yy')
-- ORDER BY AMOUNT Desc;


 
-- select * 
--  from invoice 
-- where ROWNUM <= 3 
-- order by amount desc;
 
 
SELECT CUSTOMER.CUSTOMER_ID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.AMOUNT
FROM CUSTOMER
INNER JOIN INVOICE ON CUSTOMER.CUSTOMER_ID = INVOICE.CUSTOMER_ID
where ROWNUM <= 3;
order by amount desc;

 