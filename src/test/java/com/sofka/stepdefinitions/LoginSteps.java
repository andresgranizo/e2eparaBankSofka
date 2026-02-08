package com.sofka.stepdefinitions;

import com.sofka.models.UserData;
import com.sofka.questions.TheLogin;
import com.sofka.tasks.Login;
import com.sofka.tasks.NavigateTo;
import com.sofka.tasks.Register;
import com.sofka.utils.DataGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class LoginSteps {

    @Given("the user is on the ParaBank home page")
    public void theUserIsOnTheParaBankHomePage() {
        Actor actor = OnStage.theActorCalled("User");
        actor.attemptsTo(NavigateTo.theParaBankHomePage());
    }

    @Given("a registered user exists")
    public void aRegisteredUserExists() {
        Actor actor = OnStage.theActorInTheSpotlight();
        UserData userData = DataGenerator.generateRandomUser();
        actor.remember("registeredUser", userData);
        actor.attemptsTo(
                NavigateTo.theRegisterPage(),
                Register.withData(userData),
                NavigateTo.theLogoutPage(),
                NavigateTo.theParaBankHomePage()
        );
    }

    @When("the user logs in with valid credentials")
    public void theUserLogsInWithValidCredentials() {
        Actor actor = OnStage.theActorInTheSpotlight();
        UserData userData = actor.recall("registeredUser");
        actor.attemptsTo(Login.withCredentials(userData.getUsername(), userData.getPassword()));
    }

    @When("the user logs in with invalid credentials")
    public void theUserLogsInWithInvalidCredentials() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(Login.withCredentials("invaliduser", "invalidpass"));
    }

    @Then("the login should be successful")
    public void theLoginShouldBeSuccessful() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.should(seeThat(TheLogin.wasSuccessful(), is(true)));
    }

    @And("the user should see the accounts overview")
    public void theUserShouldSeeTheAccountsOverview() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.should(seeThat(TheLogin.wasSuccessful(), is(true)));
    }

    @Then("the login should fail")
    public void theLoginShouldFail() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.should(seeThat(TheLogin.showsError(), is(true)));
    }

    @And("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.should(seeThat(TheLogin.showsError(), is(true)));
    }
}
