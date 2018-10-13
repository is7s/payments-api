package app.util;
import spark.Request;

public class RequestUtil {

    public static int getFromAccount(Request request) {
        return Integer.parseInt(request.queryParams("fromAccount"));
    }

    public static int getToAccount(Request request) {
        return Integer.parseInt(request.queryParams("toAccount"));
    }

    public static double getTransferAmount(Request request) {
        return Double.parseDouble(request.queryParams("transferAmount"));
    }

    public static int getAccountId(Request request) {
        return Integer.parseInt(request.queryParams("accountId"));
    }

    public static double getBalance(Request request) {
        return Double.parseDouble(request.queryParams("balance"));
    }

    public static double getAmount(Request request) {
        return Double.parseDouble(request.queryParams("amount"));
    }

}