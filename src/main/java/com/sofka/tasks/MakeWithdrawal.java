package com.sofka.tasks;

import com.sofka.userinterfaces.AccountsOverviewPage;
import com.sofka.userinterfaces.BillPayPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class MakeWithdrawal implements Task {

    private final String amount;
    private final String payeeName;
    private final String payeeAccount;

    public MakeWithdrawal(String amount, String payeeName, String payeeAccount) {
        this.amount = amount;
        this.payeeName = payeeName;
        this.payeeAccount = payeeAccount;
    }

    public static MakeWithdrawal of(String amount) {
        return new MakeWithdrawal(amount, "Test Payee", "12345");
    }

    public MakeWithdrawal toPayee(String payeeName, String payeeAccount) {
        return new MakeWithdrawal(this.amount, payeeName, payeeAccount);
    }

    public static MakeWithdrawal withDetails(String amount, String payeeName, String payeeAccount) {
        return instrumented(MakeWithdrawal.class, amount, payeeName, payeeAccount);
    }

    @Override
    @Step("{0} makes a withdrawal/bill payment of #amount to #payeeName")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(AccountsOverviewPage.BILL_PAY_LINK),
                WaitUntil.the(BillPayPage.PAYEE_NAME, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(payeeName).into(BillPayPage.PAYEE_NAME),
                Enter.theValue("123 Test Street").into(BillPayPage.PAYEE_ADDRESS),
                Enter.theValue("Test City").into(BillPayPage.PAYEE_CITY),
                Enter.theValue("CA").into(BillPayPage.PAYEE_STATE),
                Enter.theValue("12345").into(BillPayPage.PAYEE_ZIP_CODE),
                Enter.theValue("5551234567").into(BillPayPage.PAYEE_PHONE),
                Enter.theValue(payeeAccount).into(BillPayPage.PAYEE_ACCOUNT),
                Enter.theValue(payeeAccount).into(BillPayPage.VERIFY_ACCOUNT),
                Enter.theValue(amount).into(BillPayPage.AMOUNT),
                Click.on(BillPayPage.SEND_PAYMENT_BUTTON)
        );
    }
}
