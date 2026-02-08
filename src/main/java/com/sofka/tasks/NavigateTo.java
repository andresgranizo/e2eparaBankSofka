package com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateTo implements Task {

    private final String url;

    public NavigateTo(String url) {
        this.url = url;
    }

    public static NavigateTo theParaBankHomePage() {
        return instrumented(NavigateTo.class, "https://parabank.parasoft.com/parabank/");
    }

    public static NavigateTo theRegisterPage() {
        return instrumented(NavigateTo.class, "https://parabank.parasoft.com/parabank/register.htm");
    }

    public static NavigateTo theLogoutPage() {
        return instrumented(NavigateTo.class, "https://parabank.parasoft.com/parabank/logout.htm");
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }
}
