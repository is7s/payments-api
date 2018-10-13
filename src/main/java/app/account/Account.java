package app.account;

import com.google.common.util.concurrent.AtomicDouble;
import lombok.Value;

@Value
public class Account {
    int accountId;
    AtomicDouble balance;
}
