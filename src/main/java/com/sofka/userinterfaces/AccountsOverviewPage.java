package com.sofka.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AccountsOverviewPage {

    public static final Target ACCOUNTS_OVERVIEW_TITLE = Target.the("accounts overview title")
            .located(By.xpath("//h1[contains(text(),'Accounts Overview')]"));

    public static final Target FIRST_ACCOUNT_LINK = Target.the("first account link")
            .located(By.xpath("//table[@id='accountTable']//a[1]"));

    public static final Target ACCOUNT_BALANCE = Target.the("account balance")
            .located(By.xpath("//table[@id='accountTable']//td[2]"));

    public static final Target TOTAL_BALANCE = Target.the("total balance")
            .located(By.id("balance"));

    public static final Target TRANSFER_FUNDS_LINK = Target.the("transfer funds link")
            .located(By.linkText("Transfer Funds"));

    public static final Target BILL_PAY_LINK = Target.the("bill pay link")
            .located(By.linkText("Bill Pay"));

    public static final Target OPEN_NEW_ACCOUNT_LINK = Target.the("open new account link")
            .located(By.linkText("Open New Account"));

    public static final Target LOG_OUT_LINK = Target.the("log out link")
            .located(By.linkText("Log Out"));

    public static Target accountById(String accountId) {
        return Target.the("account " + accountId)
                .located(By.linkText(accountId));
    }
}
