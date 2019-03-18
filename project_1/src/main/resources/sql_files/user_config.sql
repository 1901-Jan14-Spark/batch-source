/*******************************************************************************
   Reimbursement Expenditure Database - Version 1.1
   Script: user_config.sql
   Description: Creates user for database usage.
   DB Server: Oracle
   Author: Kevin Tran Huu
********************************************************************************/

/*******************************************************************************
   Create database user
********************************************************************************/
CREATE USER reimbursement_user
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to reimbursement_user;
GRANT resource to reimbursement_user;
GRANT create session TO reimbursement_user;
GRANT create table TO reimbursement_user;
GRANT create view TO reimbursement_user;



conn reimbursement_user/p4ssw0rd

Commit;