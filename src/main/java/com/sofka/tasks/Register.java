package com.sofka.tasks;

import com.sofka.models.UserData;
import com.sofka.userinterfaces.RegisterPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Register implements Task {

    private final UserData userData;

    public Register(UserData userData) {
        this.userData = userData;
    }

    public static Register withData(UserData userData) {
        return instrumented(Register.class, userData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(RegisterPage.FIRST_NAME, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(userData.getFirstName()).into(RegisterPage.FIRST_NAME),
                Enter.theValue(userData.getLastName()).into(RegisterPage.LAST_NAME),
                Enter.theValue(userData.getAddress()).into(RegisterPage.ADDRESS),
                Enter.theValue(userData.getCity()).into(RegisterPage.CITY),
                Enter.theValue(userData.getState()).into(RegisterPage.STATE),
                Enter.theValue(userData.getZipCode()).into(RegisterPage.ZIP_CODE),
                Enter.theValue(userData.getPhone()).into(RegisterPage.PHONE),
                Enter.theValue(userData.getSsn()).into(RegisterPage.SSN),
                Enter.theValue(userData.getUsername()).into(RegisterPage.USERNAME),
                Enter.theValue(userData.getPassword()).into(RegisterPage.PASSWORD),
                Enter.theValue(userData.getPassword()).into(RegisterPage.CONFIRM_PASSWORD),
                Click.on(RegisterPage.REGISTER_BUTTON)
        );
    }
}