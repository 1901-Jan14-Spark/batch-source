/*
*   Creating Tables for Checking and Savings accounts
*   Creating an accountholder table
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
*       - Limited Withdrawals
*       - Interest rate
*       - Customer ID
*/

CREATE TABLE SAVINGS(
    S_ID VARCHAR2(11) CONSTRAINT PK_SAVINGSID PRIMARY KEY,
    S_BALANCE NUMBER(30,2) DEFAULT 0,
    S_INTERESTRATE NUMBER(2,2) DEFAULT .02,
    S_WITHDRAWALNUM NUMBER(2) DEFAULT 10,
    CONSTRAINT CHCK_SAVINGS CHECK (S_BALANCE >= 0 AND S_WITHDRAWALNUM >= 0 AND S_INTERESTRATE >0 AND S_INTERESTRATE < 1)
)

/*
*   ACCOUNTHOLDER
*       - Unique account ID starts with 0
*       - Account username
*       - Account password
*       - Account first name
*       - Account last name
*       - Savings account ID
*       - Checking account ID
*/  
