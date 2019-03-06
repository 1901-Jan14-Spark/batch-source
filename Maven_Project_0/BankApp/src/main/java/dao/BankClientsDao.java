package dao;

import java.util.List;

import models.BankClients;

public interface BankClientsDao {
 public List<BankClients> getClients();
 public BankClients getClientById(int accID);
 public int createClient(BankClients bc);
 public int updateClient(BankClients bc);
 public int deleteClient(int accID);
 public boolean validation(String userName, String passWord);
 public String user(String firstname, String Lastname);
}
