package com.sofka.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OpenAccountPage {

    public static final Target OPEN_ACCOUNT_TITLE = Target.the("open account title")
            .located(By.xpath("//h1[contains(text(),'Open New Account')]"));

    public static final Target ACCOUNT_TYPE_SELECT = Target.the("account type dropdown")
            .located(By.id("type"));

    public static final Target FROM_ACCOUNT_SELECT = Target.the("from account dropdown")
            .located(By.id("fromAccountId"));

    public static final Target OPEN_ACCOUNT_BUTTON = Target.the("open account button")
            .located(By.xpath("//input[@value='Open New Account']"));

    public static final Target SUCCESS_MESSAGE = Target.the("account opened success message")
            .located(By.xpath("//h1[contains(text(),'Account Opened')]"));

    public static final Target NEW_ACCOUNT_ID = Target.the("new account id")
            .located(By.id("newAccountId"));
}
