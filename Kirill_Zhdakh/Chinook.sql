--2.1 SELECT--

--A
SELECT * FROM CHINOOK.EMPLOYEE;

--B
SELECT * FROM CHINOOK.EMPLOYEE CE
WHERE CE.LASTNAME = 'King';

--C
SELECT * FROM CHINOOK.EMPLOYEE CE
WHERE CE.FIRSTNAME = 'Andrew'
AND CE.REPORTSTO IS NULL;

--D
SELECT * FROM CHINOOK.ALBUM CA
ORDER BY CA.TITLE DESC;

--E
SELECT CC.FIRSTNAME FROM CHINOOK.CUSTOMER CC
ORDER BY CC.CITY;

--F
SELECT * FROM CHINOOK.INVOICE CI
WHERE SUBSTR(CI.BILLINGADDRESS, 1, 1) = 'T';

--2.2 INSERT INTO--

--A
INSERT INTO CHINOOK.GENRE VALUES (1000, 'Gorecore');
INSERT INTO CHINOOK.GENRE VALUES (1001, 'Nightcore');

--B
INSERT INTO CHINOOK.EMPLOYEE values (3234, 'Lossman', 'Liam', 'VP Quality Control', NULL, '04-Oct-1993', '01-Oct-2007', '07 Oakridge Lane', 'South Bend', 'Indiana', 'United States', '46620', '+1 (574) 715-8987', '+1 (513) 489-4955', 'llossman0@auda.org.au'); 
INSERT INTO CHINOOK.EMPLOYEE values (2313, 'Fleeming', 'Hastie', 'Assistant Media Planner', NULL, '27-Jan-1995', '18-Jan-2007', '91 New Castle Terrace', 'Denver', 'Colorado', 'United States', '80249', '+1 (303) 298-5155', '+1 (253) 114-4623', 'hfleeming1@list-manage.com');

--C
INSERT INTO CHINOOK.CUSTOMER values (6743, 'Brad', 'York', 'VP Quality Control', '07 Oakridge Lane', 'South Bend', 'Indiana', 'United States', '46620', '+1 (574) 715-8987', '+1 (513) 489-4955', 'llossman0@auda.org.au', 3); 
INSERT INTO CHINOOK.CUSTOMER values (9723, 'Tripp', 'Tork', 'Assistant Media Planner','91 New Castle Terrace', 'Denver', 'Colorado', 'United States', '80249', '+1 (303) 298-5155', '+1 (253) 114-4623', 'hfleeming1@list-manage.com', 5);

--3.1 INNER JOIN--

--A
SELECT CI.INVOICEID AS INVOICEID, CC.FIRSTNAME||' '||CC.LASTNAME AS FULLNAME
FROM CHINOOK.INVOICE CI
JOIN CHINOOK.CUSTOMER CC
ON CI.CUSTOMERID = CC.CUSTOMERID;

--3.2 OUTER--

--A
SELECT CC.CUSTOMERID AS CUSTOMERID, CC.FIRSTNAME||' '||CC.LASTNAME AS FULLNAME, CI.INVOICEID AS INVOICEID, CI.TOTAL AS TOTAL
FROM CHINOOK.CUSTOMER CC
FULL JOIN CHINOOK.INVOICE CI
ON CC.CUSTOMERID = CI.CUSTOMERID;


--3.3 RIGHT--

--A
SELECT CART.NAME AS ARTISTNAME, CALB.TITLE AS ALBUMTITLE
FROM CHINOOK.ARTIST CART
RIGHT JOIN CHINOOK.ALBUM CALB
ON CART.ARTISTID = CALB.ARTISTID;

--3.4 CROSS--

--A
SELECT CALB.*, CART.*
FROM CHINOOK.ALBUM CALB
CROSS JOIN CHINOOK.ARTIST CART
ORDER BY CART.NAME;

--3.5 SELF--

--A
SELECT CE.*, CE2.REPORTSTO
FROM CHINOOK.EMPLOYEE CE, CHINOOK.EMPLOYEE CE2
WHERE CE.EMPLOYEEID = CE2.EMPLOYEEID;

--3.6 JOINED QUERIES--

--A
SELECT CC.FIRSTNAME||' '||CC.LASTNAME AS FULL_NAME, SUM(CI.TOTAL) AS TOTAL
FROM CHINOOK.CUSTOMER CC
JOIN CHINOOK.INVOICE CI
ON CC.CUSTOMERID = CI.CUSTOMERID 
GROUP BY CC.FIRSTNAME||' '||CC.LASTNAME
ORDER BY TOTAL DESC;

--B
SELECT CE.FIRSTNAME||' '||CE.LASTNAME AS FULL_NAME, COUNT(CI.INVOICEID) AS TOTAL
FROM CHINOOK.EMPLOYEE CE
JOIN CHINOOK.CUSTOMER CC
ON CE.EMPLOYEEID = CC.SUPPORTREPID
JOIN CHINOOK.INVOICE CI
ON CC.CUSTOMERID = CI.CUSTOMERID 
GROUP BY CE.FIRSTNAME||' '||CE.LASTNAME
ORDER BY TOTAL DESC
FETCH FIRST ROW ONLY;

--C
SELECT CG.NAME AS GENRE, COUNT(CI.INVOICEID) AS PURCHASE_COUNT
FROM CHINOOK.GENRE CG
JOIN CHINOOK.TRACK CT
ON CG.GENREID = CT.GENREID 
JOIN CHINOOK.INVOICELINE CIL
ON CT.TRACKID = CIL.TRACKID
JOIN CHINOOK.INVOICE CI
ON CIL.INVOICEID = CI.INVOICEID
JOIN CHINOOK.CUSTOMER CC
ON CI.CUSTOMERID = CC.CUSTOMERID
GROUP BY CG.NAME
ORDER BY PURCHASE_COUNT DESC;



