package app.transfers;

import app.account.Account;
import app.account.AccountDao;
import com.google.common.util.concurrent.AtomicDouble;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import spark.utils.IOUtils;

import java.net.HttpURLConnection;
import java.net.URL;

import static spark.Spark.awaitInitialization;
import static spark.Spark.post;

public class TransfersControllerTest {

    Injector injector = Guice.createInjector();
    TransfersController transfersController = injector.getInstance(TransfersController.class);
    Account testAccount10;
    Account testAccount20;

    public void defineRoutes() {
        post("transfer", transfersController.makeTransfer);
    }

    @Before
    public void init() {
        AccountDao accountDao = new AccountDao();
        accountDao.addAccount(10, new AtomicDouble(10));
        accountDao.addAccount(20, new AtomicDouble(20));
        testAccount10 = accountDao.getAccountById(10);
        testAccount20 = accountDao.getAccountById(20);
        defineRoutes();
        awaitInitialization();
    }

    @Test
    public void testMakeTransfer() throws Exception {
        URL url = new URL(
                "http://localhost:4567" + "/transfer?fromAccount=20&toAccount=10&transferAmount=10");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.connect();
        String responseBody = IOUtils.toString(connection.getInputStream());
        int statusCode = connection.getResponseCode();
        Assert.assertEquals(200, statusCode);
        Assert.assertEquals("Transfer successful!", responseBody);
        Assert.assertEquals(20, testAccount10.getBalance().get(), 0.00001);
        Assert.assertEquals(10, testAccount20.getBalance().get(), 0.00001);
    }
}
