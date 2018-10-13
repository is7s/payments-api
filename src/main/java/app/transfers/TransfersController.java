package app.transfers;

import app.account.AccountDao;
import com.google.inject.Inject;
import spark.Request;
import spark.Response;
import spark.Route;
import app.util.RequestUtil;

public class TransfersController {

    @Inject
    private AccountDao accountDao;

    public Route makeTransfer = (Request request, Response response) -> {
        int fromAccountId = RequestUtil.getFromAccount(request);
        int toAccountId = RequestUtil.getToAccount(request);
        double transferAmount = RequestUtil.getTransferAmount(request);
        accountDao.removeMoneyFromAccount(fromAccountId, transferAmount);
        accountDao.addMoneyToAccount(toAccountId, transferAmount);
        return "Transfer successful!";
    };

}
