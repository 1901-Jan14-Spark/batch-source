CREATE TABLE MANAGER (
    MANAGER_ID NUMBER(9) PRIMARY KEY,
    FIRSTNAME VARCHAR2(80),
    LASTNAME VARCHAR2(80),
    MANAGER_USERNAME VARCHAR2(80) NOT NULL,
    MANAGER_PASSWORD VARCHAR2(80) NOT NULL
);

CREATE TABLE EMPLOYEE (
    EMPLOYEE_ID NUMBER(9) PRIMARY KEY,
    FIRSTNAME VARCHAR2(80),
    LASTNAME VARCHAR2(80),
    EMPLOYEE_USERNAME VARCHAR2(80) NOT NULL,
    EMPLOYEE_PASSWORD VARCHAR2(80) NOT NULL
);

CREATE TABLE REQUEST (
    REQUEST_ID NUMBER(9) PRIMARY KEY,
    STATUS VARCHAR(20),
    AMOUNT NUMBER(10,2) NOT NULL,
    EMPLOYEE_ID NUMBER(9) NOT NULL,
    MANAGER_ID NUMBER(9),
    FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE (EMPLOYEE_ID),
    FOREIGN KEY (MANAGER_ID) REFERENCES MANAGER (MANAGER_ID)
);


insert into MANAGER (MANAGER_ID, FIRSTNAME, LASTNAME, MANAGER_USERNAME, MANAGER_PASSWORD) values (1, 'younes', 'wardaoui', 'w.youness@msn.com', 'morocco2010');
insert into MANAGER (MANAGER_ID, FIRSTNAME, LASTNAME, MANAGER_USERNAME, MANAGER_PASSWORD) values (2, 'Sharona', 'Cardiff', 'scardiff1@histats.com', 'DA6ILbHv');
insert into MANAGER (MANAGER_ID, FIRSTNAME, LASTNAME, MANAGER_USERNAME, MANAGER_PASSWORD) values (3, 'Hedwiga', 'Eronie', 'heronie2@jigsy.com', 'CFjIvzbQn8K');
insert into MANAGER (MANAGER_ID, FIRSTNAME, LASTNAME, MANAGER_USERNAME, MANAGER_PASSWORD) values (4, 'Nap', 'Cottrill', 'ncottrill3@reference.com', '3kLr4EArZ');
insert into MANAGER (MANAGER_ID, FIRSTNAME, LASTNAME, MANAGER_USERNAME, MANAGER_PASSWORD) values (5, 'Nettie', 'Attyeo', 'nattyeo4@cam.ac.uk', '00IRq21Jk0vb');
insert into MANAGER (MANAGER_ID, FIRSTNAME, LASTNAME, MANAGER_USERNAME, MANAGER_PASSWORD) values (6, 'Tadeas', 'Caghy', 'tcaghy5@chron.com', 'P7QvWD');
insert into MANAGER (MANAGER_ID, FIRSTNAME, LASTNAME, MANAGER_USERNAME, MANAGER_PASSWORD) values (7, 'Janifer', 'Jewson', 'jjewson6@msn.com', 'ymqWrYz');
insert into MANAGER (MANAGER_ID, FIRSTNAME, LASTNAME, MANAGER_USERNAME, MANAGER_PASSWORD) values (8, 'Kim', 'Hebbron', 'khebbron7@behance.net', 'PGQ97O');
insert into MANAGER (MANAGER_ID, FIRSTNAME, LASTNAME, MANAGER_USERNAME, MANAGER_PASSWORD) values (9, 'Anson', 'Baverstock', 'abaverstock8@ifeng.com', 'd1s13jaaTQ6r');
insert into MANAGER (MANAGER_ID, FIRSTNAME, LASTNAME, MANAGER_USERNAME, MANAGER_PASSWORD) values (10, 'Dionysus', 'Fiddler', 'dfiddler9@ifeng.com', 'cpEpsDCVs');
insert into MANAGER (MANAGER_ID, FIRSTNAME, LASTNAME, MANAGER_USERNAME, MANAGER_PASSWORD) values (11, 'Cam', 'Gerhardt', 'cgerhardta@mapquest.com', '4Cj9jd5T');
insert into MANAGER (MANAGER_ID, FIRSTNAME, LASTNAME, MANAGER_USERNAME, MANAGER_PASSWORD) values (12, 'Trip', 'Todari', 'ttodarib@i2i.jp', 'opg4Xg3f5U');
insert into MANAGER (MANAGER_ID, FIRSTNAME, LASTNAME, MANAGER_USERNAME, MANAGER_PASSWORD) values (13, 'Emelina', 'Cator', 'ecatorc@tiny.cc', 'mfGplEmgSXP');
insert into MANAGER (MANAGER_ID, FIRSTNAME, LASTNAME, MANAGER_USERNAME, MANAGER_PASSWORD) values (14, 'Kandy', 'Leyman', 'kleymand@statcounter.com', 'yr399nXkxQ');
insert into MANAGER (MANAGER_ID, FIRSTNAME, LASTNAME, MANAGER_USERNAME, MANAGER_PASSWORD) values (15, 'Chen', 'Castelyn', 'ccastelyne@mashable.com', 'N7plrHqPyYi');

insert into EMPLOYEE (EMPLOYEE_ID, FIRSTNAME, LASTNAME, EMPLOYEE_USERNAME, EMPLOYEE_PASSWORD) values (1, 'Claresta', 'Darbon', 'cdarbon0@scientificamerican.com', 'efPJAu');
insert into EMPLOYEE (EMPLOYEE_ID, FIRSTNAME, LASTNAME, EMPLOYEE_USERNAME, EMPLOYEE_PASSWORD) values (2, 'Culley', 'O''Cannan', 'cocannan1@utexas.edu', '2cUraeseuId');
insert into EMPLOYEE (EMPLOYEE_ID, FIRSTNAME, LASTNAME, EMPLOYEE_USERNAME, EMPLOYEE_PASSWORD) values (3, 'Lenette', 'Clulee', 'lclulee2@ning.com', 'UKud2zdv');
insert into EMPLOYEE (EMPLOYEE_ID, FIRSTNAME, LASTNAME, EMPLOYEE_USERNAME, EMPLOYEE_PASSWORD) values (4, 'Claybourne', 'Escolme', 'cescolme3@zdnet.com', 'f5veD2d');
insert into EMPLOYEE (EMPLOYEE_ID, FIRSTNAME, LASTNAME, EMPLOYEE_USERNAME, EMPLOYEE_PASSWORD) values (5, 'Adriaens', 'Dottridge', 'adottridge4@dion.ne.jp', '7LhlG7PuRX');
insert into EMPLOYEE (EMPLOYEE_ID, FIRSTNAME, LASTNAME, EMPLOYEE_USERNAME, EMPLOYEE_PASSWORD) values (6, 'Bone', 'Gunney', 'bgunney5@a8.net', 'BamtvC99sY');
insert into EMPLOYEE (EMPLOYEE_ID, FIRSTNAME, LASTNAME, EMPLOYEE_USERNAME, EMPLOYEE_PASSWORD) values (7, 'Alethea', 'Seabright', 'aseabright6@slideshare.net', 'k0BPOM2T9zQ');
insert into EMPLOYEE (EMPLOYEE_ID, FIRSTNAME, LASTNAME, EMPLOYEE_USERNAME, EMPLOYEE_PASSWORD) values (8, 'Sile', 'Winger', 'swinger7@eepurl.com', 'Z0lnhjLa');
insert into EMPLOYEE (EMPLOYEE_ID, FIRSTNAME, LASTNAME, EMPLOYEE_USERNAME, EMPLOYEE_PASSWORD) values (9, 'Ulrick', 'Cerman', 'ucerman8@merriam-webster.com', 'OqYFPPaHXCm');
insert into EMPLOYEE (EMPLOYEE_ID, FIRSTNAME, LASTNAME, EMPLOYEE_USERNAME, EMPLOYEE_PASSWORD) values (10, 'Murry', 'Byrne', 'mbyrne9@google.com', '8KrlyTDypyeC');
insert into EMPLOYEE (EMPLOYEE_ID, FIRSTNAME, LASTNAME, EMPLOYEE_USERNAME, EMPLOYEE_PASSWORD) values (11, 'Hurleigh', 'Kraft', 'hkrafta@edublogs.org', '1C7NrrJ76gv');
insert into EMPLOYEE (EMPLOYEE_ID, FIRSTNAME, LASTNAME, EMPLOYEE_USERNAME, EMPLOYEE_PASSWORD) values (12, 'Filide', 'Grigg', 'fgriggb@dropbox.com', 'zry2sEA');
insert into EMPLOYEE (EMPLOYEE_ID, FIRSTNAME, LASTNAME, EMPLOYEE_USERNAME, EMPLOYEE_PASSWORD) values (13, 'Amble', 'Popeley', 'apopeleyc@tamu.edu', 'ZCTS9g2l');
insert into EMPLOYEE (EMPLOYEE_ID, FIRSTNAME, LASTNAME, EMPLOYEE_USERNAME, EMPLOYEE_PASSWORD) values (14, 'Leonore', 'Hearsey', 'lhearseyd@flickr.com', 'cFIJeFFxwO6');
insert into EMPLOYEE (EMPLOYEE_ID, FIRSTNAME, LASTNAME, EMPLOYEE_USERNAME, EMPLOYEE_PASSWORD) values (15, 'Aile', 'Kasman', 'akasmane@123-reg.co.uk', 'URYV3m3oefo6');

insert into REQUEST (REQUEST_ID, STATUS, AMOUNT, EMPLOYEE_ID, MANAGER_ID) values (1, 'Pending', 44.7, 11, 7);
insert into REQUEST (REQUEST_ID, STATUS, AMOUNT, EMPLOYEE_ID, MANAGER_ID) values (2, 'Pending', 70.3, 6, 2);
insert into REQUEST (REQUEST_ID, STATUS, AMOUNT, EMPLOYEE_ID, MANAGER_ID) values (3, 'Approved', 67.2, 7, 14);
insert into REQUEST (REQUEST_ID, STATUS, AMOUNT, EMPLOYEE_ID, MANAGER_ID) values (4, 'Approved', 90.2, 9, 9);
insert into REQUEST (REQUEST_ID, STATUS, AMOUNT, EMPLOYEE_ID, MANAGER_ID) values (5, 'Pending', 36.7, 4, 11);
insert into REQUEST (REQUEST_ID, STATUS, AMOUNT, EMPLOYEE_ID, MANAGER_ID) values (6, 'Pending', 59.0, 12, 6);
insert into REQUEST (REQUEST_ID, STATUS, AMOUNT, EMPLOYEE_ID, MANAGER_ID) values (7, 'Denied', 43.5, 1, 8);
insert into REQUEST (REQUEST_ID, STATUS, AMOUNT, EMPLOYEE_ID, MANAGER_ID) values (8, 'Pending', 5.5, 9, 13);
insert into REQUEST (REQUEST_ID, STATUS, AMOUNT, EMPLOYEE_ID, MANAGER_ID) values (9, 'Denied', 89.4, 15, 1);
insert into REQUEST (REQUEST_ID, STATUS, AMOUNT, EMPLOYEE_ID, MANAGER_ID) values (10, 'Pending', 100.0, 5, 10);
insert into REQUEST (REQUEST_ID, STATUS, AMOUNT, EMPLOYEE_ID, MANAGER_ID) values (11, 'Pending', 98.9, 6, 8);
insert into REQUEST (REQUEST_ID, STATUS, AMOUNT, EMPLOYEE_ID, MANAGER_ID) values (12, 'Pending', 74.8, 8, 9);
insert into REQUEST (REQUEST_ID, STATUS, AMOUNT, EMPLOYEE_ID, MANAGER_ID) values (13, 'Approved', 97.9, 13, 7);
insert into REQUEST (REQUEST_ID, STATUS, AMOUNT, EMPLOYEE_ID, MANAGER_ID) values (14, 'Denied', 11.8, 8, 4);
insert into REQUEST (REQUEST_ID, STATUS, AMOUNT, EMPLOYEE_ID, MANAGER_ID) values (15, 'Denied', 21.3, 1, 5);

commit