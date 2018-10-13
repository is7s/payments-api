package app.account;

import com.google.common.util.concurrent.AtomicDouble;

import java.util.concurrent.ConcurrentHashMap;

public class AccountDao {

    final private static ConcurrentHashMap<Integer, Account> accounts = new ConcurrentHashMap<>();


    public Account getAccountById(int accountId) {
        return accounts.get(accountId);
    }

    public void addAccount(int accountId, AtomicDouble balance) {
        accounts.put(accountId, new Account(accountId, balance));
    }

    public void removeAccount(int accountId) {
        accounts.remove(accountId);
    }

    public void addMoneyToAccount(int accountId, double addAmount) {
        getAccountById(accountId).getBalance().addAndGet(addAmount);
    }

    public void removeMoneyFromAccount(int accountId, double removeAmmount) {
        getAccountById(accountId).getBalance().addAndGet(-removeAmmount);
    }

}
