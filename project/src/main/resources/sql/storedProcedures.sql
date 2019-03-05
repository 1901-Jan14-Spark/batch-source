/*******************************************************************************
   Banking Database - Version 1.0
   Script: bankingmanager.sql
   Description: Creates user and tables for database.
   DB Server: Oracle
   Author: Kevin Tran Huu
********************************************************************************/

/*******************************************************************************
    Stored Create Procedures
********************************************************************************/
Create or replace procedure createAccount(
    i_type in account.A_TYPE%type
    )
    is
    begin
    insert into Account (A_TYPE) values(i_type);
    end;
    /

    Create or replace procedure createAccountHolder(
    i_username in accountholder.H_username%type,
    i_password in accountholder.h_password%type,
    i_firstname in accountholder.h_firstname%type,
    i_lastname in accountholder.h_lastname%type,
    i_loggedin in accountholder.h_loggedin%type
    )
    is
    begin
    insert into AccountHolder (H_username, h_password, h_firstname, h_lastname, h_loggedin) 
    values(i_username, i_password, i_firstname, i_lastname, i_loggedin);
    end;
    /
    
     Create or replace procedure createTransaction(
    i_aid in transaction.a_id%type,
    i_amount in transaction.t_amount%type,
    i_description in transaction.t_description%type
    )
    is
    begin
    insert into transaction (a_ID, T_AMOUNT, T_DESCRIPTION) 
    values(i_aid, i_amount, i_description);
    end;
    /

    Create or replace procedure AssignAccount(
        i_aid in accountmanager.a_id%type,
        i_hid in accountmanager.h_id%type
    )
    is
    begin
        insert into accountmanager (a_ID, h_ID) 
    values(i_aid, i_hid);
    end;
    /
    
    Create or replace procedure AssignAccount(
        i_aid in accountmanager.a_id%type,
        i_hid in accountmanager.h_id%type
    )
    is
    begin
        insert into accountmanager (a_ID, h_ID) 
    values(i_aid, i_hid);
    end;
    /
    
    Create or replace procedure getSeqCurr
    is
    temp number;
    begin
    SELECT SQ_ACCOUNT_PK.Last_Number into temp FROM DUAL;
        return temp;
    end;
    /
    
    SELECT curr_value from user_sequences where sequence_name = 'SQ_ACCOUNT_PK';