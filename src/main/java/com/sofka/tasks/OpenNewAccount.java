package com.sofka.tasks;

import com.sofka.userinterfaces.AccountsOverviewPage;
import com.sofka.userinterfaces.OpenAccountPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class OpenNewAccount implements Task {

    private final String accountType;

    public OpenNewAccount(String accountType) {
        this.accountType = accountType;
    }

    public static OpenNewAccount ofType(String accountType) {
        return instrumented(OpenNewAccount.class, accountType);
    }

    public static OpenNewAccount checking() {
        return instrumented(OpenNewAccount.class, "CHECKING");
    }

    public static OpenNewAccount savings() {
        return instrumented(OpenNewAccount.class, "SAVINGS");
    }

    @Override
    @Step("{0} opens a new #accountType account")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(AccountsOverviewPage.OPEN_NEW_ACCOUNT_LINK),
                WaitUntil.the(OpenAccountPage.ACCOUNT_TYPE_SELECT, isVisible()).forNoMoreThan(10).seconds(),
                SelectFromOptions.byVisibleText(accountType).from(OpenAccountPage.ACCOUNT_TYPE_SELECT),
                Click.on(OpenAccountPage.OPEN_ACCOUNT_BUTTON),
                WaitUntil.the(OpenAccountPage.SUCCESS_MESSAGE, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}
