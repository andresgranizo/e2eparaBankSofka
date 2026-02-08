package com.sofka.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TransferFundsPage {

    public static final Target TRANSFER_TITLE = Target.the("transfer funds title")
            .located(By.xpath("//h1[contains(text(),'Transfer Funds')]"));

    public static final Target AMOUNT_INPUT = Target.the("amount input")
            .located(By.id("amount"));

    public static final Target FROM_ACCOUNT_SELECT = Target.the("from account dropdown")
            .located(By.id("fromAccountId"));

    public static final Target TO_ACCOUNT_SELECT = Target.the("to account dropdown")
            .located(By.id("toAccountId"));

    public static final Target TRANSFER_BUTTON = Target.the("transfer button")
            .located(By.xpath("//input[@value='Transfer']"));

    public static final Target SUCCESS_MESSAGE = Target.the("transfer success message")
            .located(By.xpath("//h1[contains(text(),'Transfer Complete')]"));

    public static final Target AMOUNT_TRANSFERRED = Target.the("amount transferred")
            .located(By.id("amount"));

    public static final Target FROM_ACCOUNT_RESULT = Target.the("from account result")
            .located(By.id("fromAccountId"));

    public static final Target TO_ACCOUNT_RESULT = Target.the("to account result")
            .located(By.id("toAccountId"));
}
