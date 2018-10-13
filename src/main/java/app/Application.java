package app;

import app.account.AccountsController;
import com.google.inject.Guice;
import com.google.inject.Injector;
import app.transfers.TransfersController;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

public class Application {
    static Injector injector = Guice.createInjector();
    static AccountsController accountsController = injector.getInstance(AccountsController.class);
    static TransfersController transfersController = injector.getInstance(TransfersController.class);

    public static void main(String[] args) {
        post("add_account", accountsController.addAccount);
        post("remove_account", accountsController.removeAccount);
        post("add_money", accountsController.addMoneyToAccount);
        post("remove_money", accountsController.removeMoneyFromAccount);
        post("transfer", transfersController.makeTransfer);
        get("get_balance", accountsController.getBalance);

    }

}
