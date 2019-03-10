--EMPLOYEE DATA RECORDS

insert into EMPLOYEE (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, TITLE, MANAGERS_ID) values (1, 'Boigie', 'Kulic', 'CEO', NULL);
insert into EMPLOYEE (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, TITLE, MANAGERS_ID) values (2, 'Garold', 'Meeus', 'General Manager', 1);
insert into EMPLOYEE (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, TITLE, MANAGERS_ID) values (3, 'Amitie', 'Jope', 'Assistant Manager', 2);
insert into EMPLOYEE (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, TITLE, MANAGERS_ID) values (4, 'Drew', 'MacSween', 'HR Manager', 1);
insert into EMPLOYEE (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, TITLE, MANAGERS_ID) values (5, 'Lay', 'Tabb', 'HR Associate', 1);
insert into EMPLOYEE (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, TITLE, MANAGERS_ID) values (6, 'Ward', 'Haddrell', 'Generic', 3);
insert into EMPLOYEE (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, TITLE, MANAGERS_ID) values (7, 'Britt', 'Christophle', 'Generic', 3);
insert into EMPLOYEE (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, TITLE, MANAGERS_ID) values (8, 'Jermain', 'Grumble', 'Generic', 3);
insert into EMPLOYEE (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, TITLE, MANAGERS_ID) values (9, 'Nicolai', 'Bellefant', 'Generic', 3);
insert into EMPLOYEE (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, TITLE, MANAGERS_ID) values (10, 'Chrissy', 'Sendley', 'Generic', 3);
insert into EMPLOYEE (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, TITLE, MANAGERS_ID) values (11, 'Eilis', 'Snoday', 'Generic', 3);


insert into MANAGERS (MANAGERS_ID, EMPLOYEE_ID) values (1, 1);
insert into MANAGERS (MANAGERS_ID, EMPLOYEE_ID) values (2, 2);
insert into MANAGERS (MANAGERS_ID, EMPLOYEE_ID) values (3, 3);
insert into MANAGERS (MANAGERS_ID, EMPLOYEE_ID) values (4, 4);
