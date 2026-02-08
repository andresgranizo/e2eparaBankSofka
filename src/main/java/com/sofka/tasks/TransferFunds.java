package com.sofka.tasks;

import com.sofka.userinterfaces.AccountsOverviewPage;
import com.sofka.userinterfaces.TransferFundsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TransferFunds implements Task {

    private final String amount;
    private final String fromAccountIndex;
    private final String toAccountIndex;

    public TransferFunds(String amount, String fromAccountIndex, String toAccountIndex) {
        this.amount = amount;
        this.fromAccountIndex = fromAccountIndex;
        this.toAccountIndex = toAccountIndex;
    }

    public static TransferFunds withAmount(String amount) {
        return new TransferFunds(amount, "0", "1");
    }

    public TransferFunds fromAccount(String index) {
        return new TransferFunds(this.amount, index, this.toAccountIndex);
    }

    public TransferFunds toAccount(String index) {
        return new TransferFunds(this.amount, this.fromAccountIndex, index);
    }

    public static TransferFunds of(String amount, String fromIndex, String toIndex) {
        return instrumented(TransferFunds.class, amount, fromIndex, toIndex);
    }

    @Override
    @Step("{0} transfers #amount from account #fromAccountIndex to account #toAccountIndex")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(AccountsOverviewPage.TRANSFER_FUNDS_LINK),
                WaitUntil.the(TransferFundsPage.AMOUNT_INPUT, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(amount).into(TransferFundsPage.AMOUNT_INPUT),
                SelectFromOptions.byIndex(Integer.parseInt(fromAccountIndex)).from(TransferFundsPage.FROM_ACCOUNT_SELECT),
                SelectFromOptions.byIndex(Integer.parseInt(toAccountIndex)).from(TransferFundsPage.TO_ACCOUNT_SELECT),
                Click.on(TransferFundsPage.TRANSFER_BUTTON)
        );
    }
}
