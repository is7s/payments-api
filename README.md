# payments-api
Simple payments api for creating accounts, adding and removing money and transferring money between accounts.

## Instructions for Running
Run the .jar file in out/artifacts/payments_jar/ and then make HTTP requests to the following endpoints:

* `POST http://localhost:4567/add_account?accountId={ACCOUNT_ID}&balance={BALANCE}`
* `POST http://localhost:4567/remove_account?accountId={ACCOUNT_ID}`
* `POST http://localhost:4567/add_money?accountId={ACCOUNT_ID}&amount={AMOUNT}`
* `POST http://localhost:4567/remove_money?accountId={ACCOUNT_ID}&amount={AMOUNT}`
* `POST http://localhost:4567/transfer?fromAccount={FROM_ACCOUNT_ID}&toAccount={TO_ACCOUNT_ID}&transferAmount={TRANSFER_AMOUNT}`
* `GET http://localhost:4567/get_balance?accountId={ACCOUNT_ID}`
