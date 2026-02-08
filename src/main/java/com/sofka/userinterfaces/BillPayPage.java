package com.sofka.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BillPayPage {

    public static final Target BILL_PAY_TITLE = Target.the("bill pay title")
            .located(By.xpath("//h1[contains(text(),'Bill Pay')]"));

    public static final Target PAYEE_NAME = Target.the("payee name input")
            .located(By.name("payee.name"));

    public static final Target PAYEE_ADDRESS = Target.the("payee address input")
            .located(By.name("payee.address.street"));

    public static final Target PAYEE_CITY = Target.the("payee city input")
            .located(By.name("payee.address.city"));

    public static final Target PAYEE_STATE = Target.the("payee state input")
            .located(By.name("payee.address.state"));

    public static final Target PAYEE_ZIP_CODE = Target.the("payee zip code input")
            .located(By.name("payee.address.zipCode"));

    public static final Target PAYEE_PHONE = Target.the("payee phone input")
            .located(By.name("payee.phoneNumber"));

    public static final Target PAYEE_ACCOUNT = Target.the("payee account input")
            .located(By.name("payee.accountNumber"));

    public static final Target VERIFY_ACCOUNT = Target.the("verify account input")
            .located(By.name("verifyAccount"));

    public static final Target AMOUNT = Target.the("amount input")
            .located(By.name("amount"));

    public static final Target FROM_ACCOUNT_SELECT = Target.the("from account dropdown")
            .located(By.name("fromAccountId"));

    public static final Target SEND_PAYMENT_BUTTON = Target.the("send payment button")
            .located(By.xpath("//input[@value='Send Payment']"));

    public static final Target SUCCESS_MESSAGE = Target.the("bill payment success message")
            .located(By.xpath("//h1[contains(text(),'Bill Payment Complete')]"));
}
