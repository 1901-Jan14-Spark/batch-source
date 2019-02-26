--SELECT * 
--FROM INVOICE
--WHERE  DATE_ = to_date('02-FEB-19', 'dd-mon-yy')

--SELECT CUSTOMER_ID, count(CUSTOMER_ID) 
--  FROM INVOICE 
-- GROUP by CUSTOMER_ID;


--SELECT CUSTOMER_ID, SUM(AMOUNT) 
--  FROM INVOICE 
-- GROUP by CUSTOMER_ID;


SELECT CUSTOMER_ID 
  FROM INVOICE 
 WHERE DATE_ = to_date('01-JAN-19', 'dd-mon-yy')
 AND DATE_ = to_date('31-JAN-19', 'dd-mon-yy');
 
 
 