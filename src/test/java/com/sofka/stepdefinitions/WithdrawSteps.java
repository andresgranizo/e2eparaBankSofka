package com.sofka.stepdefinitions;

import com.sofka.models.UserData;
import com.sofka.questions.TheWithdrawal;
import com.sofka.tasks.Login;
import com.sofka.tasks.MakeWithdrawal;
import com.sofka.tasks.NavigateTo;
import com.sofka.tasks.Register;
import com.sofka.utils.DataGenerator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class WithdrawSteps {

    @Given("the user is logged into ParaBank")
    public void theUserIsLoggedIntoParaBank() {
        Actor actor = OnStage.theActorCalled("User");
        UserData userData = DataGenerator.generateRandomUser();
        actor.remember("registeredUser", userData);
        actor.attemptsTo(
                NavigateTo.theRegisterPage(),
                Register.withData(userData)
        );
    }

    @When("the user makes a bill payment of {string} dollars")
    public void theUserMakesABillPaymentOfDollars(String amount) {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(MakeWithdrawal.withDetails(amount, "Test Payee", "12345"));
    }

    @Then("the bill payment should be successful")
    public void theBillPaymentShouldBeSuccessful() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.should(seeThat(TheWithdrawal.wasSuccessful(), is(true)));
    }
}
