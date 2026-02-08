package com.sofka.stepdefinitions;

import com.sofka.questions.TheTransfer;
import com.sofka.tasks.NavigateTo;
import com.sofka.tasks.OpenNewAccount;
import com.sofka.tasks.TransferFunds;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class TransferSteps {

    @And("the user has at least two accounts")
    public void theUserHasAtLeastTwoAccounts() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(
                OpenNewAccount.checking(),
                NavigateTo.theParaBankHomePage()
        );
    }

    @When("the user transfers {string} dollars between accounts")
    public void theUserTransfersDollarsBetweenAccounts(String amount) {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(TransferFunds.of(amount, "0", "1"));
    }

    @Then("the transfer should be successful")
    public void theTransferShouldBeSuccessful() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.should(seeThat(TheTransfer.wasSuccessful(), is(true)));
    }
}
