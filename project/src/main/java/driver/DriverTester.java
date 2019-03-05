package driver;

import frontend.Interface;

public class DriverTester {

	public static void main(String[] args) {
//		AccountHolderDao ahd = new AccountHolderDaoImpl();
//		AccountHolder ah = ahd.getAccountHolderByUsername("kth");
//		System.out.println(ah.isLoggedIn());
//		ahd.updateAccountHolderLogin(ah);
//		System.out.println(ah.isLoggedIn());
//		String username = "kth2";
//		String password = "123";
//		String firstName = "Kevin";
//		String lastName = "Tran";

//		System.out.println(ah);
//		if(ah != null) {
//			System.out.println("Account Handler - login - Invalid UserName. " + username);
//		}else {
//		AccountHolder myAccount = new AccountHolder(username, password, firstName, lastName);
//		
//		ahd.createAccountHolder(myAccount);
//		System.out.println(myAccount);
//		}
		Interface.start();

//		AccountHolder ah = ahd.getAccountHolderByUsername("Agil1");
//		System.out.println(ah==null);
//
////		System.out.println(ahd.getAccountHolderByUsername("Agil1"));
//		AccountDao ad = new AccountDaoImpl();
//		Account a = ad.getAccountByID(1);
//		AccountManagerDaoImpl amd = new AccountManagerDaoImpl();
//		TransactionDao td = new TransactionDaoImpl();
//		td.createTransaction(a, new BigDecimal(50), "Test deposit");
//		td.createTransaction(a, new BigDecimal(-50), "Test deposit");
//		
//		List<Transaction> list = td.getTransactionForAccount(a);
//		for (Transaction s : list) {
//			System.out.println(s);
//		}
//		List<Account> list = amd.getAccountsAssociated(ah);
//		for (Account as : list) {
//			System.out.println(as);
//		}
//		amd.assignAccount(a, ah);
//		ahd.createAccountHolder(new AccountHolder("Agil1", "123", "Agilay", "Dones", true ));
//		System.out.println(a);
//		
//		a.setBalance(new BigDecimal(50));
//		
//		ad.updateAccountBalance(a);
//		
//		List<Account> accounts = ad.getAccounts();
//		for(Account d : accounts) {
//			System.out.println(d);
//		}
	}
}
