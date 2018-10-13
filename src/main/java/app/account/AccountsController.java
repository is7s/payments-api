package app.account;

import app.Application;
import com.google.common.util.concurrent.AtomicDouble;
import com.google.inject.Inject;
import spark.Request;
import spark.Response;
import spark.Route;
import app.util.RequestUtil;

public class AccountsController {

    @Inject
    private AccountDao accountDao;

    public Route addAccount = (Request request, Response response) -> {
       accountDao.addAccount(RequestUtil.getAccountId(request), new AtomicDouble(RequestUtil.getBalance(request)));
       return "Added";
    };

    public Route removeAccount = (Request request, Response response) -> {
        accountDao.removeAccount(RequestUtil.getAccountId(request));
        return "Removed";
    };

    public Route getBalance = (Request request, Response response) ->
        accountDao.getAccountById(RequestUtil.getAccountId(request)).getBalance().toString();

    public Route addMoneyToAccount = (Request request, Response response) -> {
        accountDao.addMoneyToAccount(RequestUtil.getAccountId(request), RequestUtil.getAmount(request));
        return "Done";
    };

    public Route removeMoneyFromAccount = (Request request, Response response) -> {
        accountDao.addMoneyToAccount(RequestUtil.getAccountId(request), RequestUtil.getAmount(request));
        return "Done";
    };

}
