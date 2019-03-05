/*
*   Creating Tables for Checking and Savings accounts
*   Creating a Customer table
*/

/*
*   Checking accounts:
*       - Unique account ID starts with 1
*       - Balance
*       - Unlimited Withdrawals
*       - Customer ID
*/

CREATE TABLE CHECKING(
    C_ID VARCHAR2(11) CONSTRAINT PK_CHECKINGID PRIMARY KEY,
    C_BALANCE NUMBER(30,2) DEFAULT 0,
    CONSTRAINT CHCK_CHECKING CHECK (C_BALANCE >= 0)
    ) 

/*
*   Savings accounts:
*       - Unique account ID starts with 2
*       - Balance
*       - Limited Withdrawals X
*       - Interest rate X
*       - Customer ID X
*/

CREATE TABLE SAVINGS(
    S_ID VARCHAR2(11) CONSTRAINT PK_SAVINGSID PRIMARY KEY,
    S_BALANCE NUMBER(30,2) DEFAULT 0,
    CONSTRAINT CHCK_SAVINGS CHECK (S_BALANCE >= 0)
)

/*
*   Create table for Account Holder
*       - Account ID
*       - First Name
*       - Last Name
*       - Username
*       - Password
*       - Savings account ID
*       - Checking account ID
*/

CREATE TABLE ACCOUNTHOLDER(
    A_ID varchar2(11) constraint pk_accountholder primary key,
    A_fname varchar2(20),
    A_lname varchar2(20) CONSTRAINT lname_null not null,
    A_username varchar2(20)constraint username_null_unique unique not null,
    A_password varchar2(20)constraint password_null not null,
    S_ID varchar2(11) constraint fk_savings references Savings,
    C_ID varchar2(11) constraint fk_checking references checking
);