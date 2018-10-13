package app.account;


import com.google.common.util.concurrent.AtomicDouble;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountDaoTest {

    AccountDao accountDao;
    Account testAccount1;
    Account testAccount2;

    @Before
    public void init() {
        accountDao = new AccountDao();
        accountDao.addAccount(100, new AtomicDouble(100));
        accountDao.addAccount(200, new AtomicDouble(200));
        testAccount1 = accountDao.getAccountById(100);
        testAccount2 = accountDao.getAccountById(200);
    }

    @Test
    public void testAddAccount() {
        accountDao.addAccount(0, new AtomicDouble(0));
        Account account = accountDao.getAccountById(0);
        Assert.assertEquals(0, account.getAccountId());
        Assert.assertEquals(0.0, account.getBalance().get(), 0.00001);
    }

    @Test
    public void testRemoveAccount() {
        accountDao.addAccount(1, new AtomicDouble(1));
        accountDao.removeAccount(1);
        Assert.assertNull(accountDao.getAccountById(1));
    }

    @Test
    public void testAddMoneyToAccount() {
        accountDao.addMoneyToAccount(100, 10);
        Assert.assertEquals(110, testAccount1.getBalance().get(), 0.00001);
    }

    @Test
    public void removeMoneyToAccount() {
        accountDao.removeMoneyFromAccount(200, 10);
        Assert.assertEquals(190, testAccount2.getBalance().get(), 0.00001);
    }



}
