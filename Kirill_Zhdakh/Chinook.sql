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
INSERT INTO CHINOOK.CUSTOMER values (3234, 'Lossman', 'Liam', 'VP Quality Control', NULL, '04-Oct-1993', '01-Oct-2007', '07 Oakridge Lane', 'South Bend', 'Indiana', 'United States', '46620', '+1 (574) 715-8987', '+1 (513) 489-4955', 'llossman0@auda.org.au'); 
INSERT INTO CHINOOK.CUSTOMER values (2313, 'Fleeming', 'Hastie', 'Assistant Media Planner', NULL, '27-Jan-1995', '18-Jan-2007', '91 New Castle Terrace', 'Denver', 'Colorado', 'United States', '80249', '+1 (303) 298-5155', '+1 (253) 114-4623', 'hfleeming1@list-manage.com');


