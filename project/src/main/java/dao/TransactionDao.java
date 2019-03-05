package dao;

import java.math.BigDecimal;
import java.util.List;

import models.Account;
import models.Transaction;

public interface TransactionDao {

	public void createTransaction(Account a, BigDecimal amount, String description);
	public int deleteTransaction(Transaction t);
	public List<Transaction> getTransactionForAccount(Account a);
}
