//package main;
//
//import dao.AccountsDao;
//import dao.AccountsDaoImpl;
//import dao.BankClientsDao;
//import dao.BankClientsDaoImpl;
//import models.Accounts;
//
//public class Driver {
//	public static void main(String[] args) {
//		AccountsDao ad = new AccountsDaoImpl();
////		List<Accounts> accounts = ad.getAccounts();
////		for(Accounts a:accounts) {
////			System.out.println(a);
////		}
////		
//		BankClientsDao bcd = new BankClientsDaoImpl();
//////		List<BankClients> clients = bcd.getClients();
//////		for(BankClients c: clients) {
//////			System.out.println(c);		
//////		}
////		
////		BankClients client = bcd.getClientById(1);
////		System.out.println(client);
//		
//		//bcd.createClient(new BankClients(2, "Rogers", "peterson", "p.rogers@gmail.com"));
//		
////		BankClients client1 = bcd.getClientById(2);
////		client1.setFirstName("Jorge");
////		client1.setLastName("Lopez");
////		client1.setEmail("G.Lopez@gmail.com");
////		int update = bcd.updateClient(client1);
////		System.out.println(update);
//		
//		Accounts a = ad.getAccountByID(1);
//		a.setBalance(45);
//		int update = ad.updateAccount(a);
//		
//		
//		
////		int delete = bcd.deleteClient(2);
//		
//	
//	}
//	
//}
