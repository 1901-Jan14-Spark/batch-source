package driver;

import java.math.BigDecimal;
import java.util.List;

import dao.AccountDao;
import dao.AccountDaoImpl;
import dao.AccountHolderDao;
import dao.AccountHolderDaoImpl;
import dao.AccountManagerDaoImpl;
import dao.TransactionDao;
import dao.TransactionDaoImpl;
import models.Account;
import models.AccountHolder;
import models.Transaction;

public class DriverTester {

	public static void main(String[] args) {
//		Interface.start();

//		AccountHolderDao ahd = new AccountHolderDaoImpl();
//		AccountHolder ah = ahd.getAccountHolderByUsername("Agil1");
//
////		System.out.println(ahd.getAccountHolderByUsername("Agil1"));
//		AccountDao ad = new AccountDaoImpl();
//		Account a = ad.getAccountByID(1);
//		AccountManagerDaoImpl amd = new AccountManagerDaoImpl();
//
//		
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
