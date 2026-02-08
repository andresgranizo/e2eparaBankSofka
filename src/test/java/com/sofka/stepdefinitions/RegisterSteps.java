package com.sofka.stepdefinitions;

import com.sofka.models.UserData;
import com.sofka.questions.TheRegistration;
import com.sofka.tasks.NavigateTo;
import com.sofka.tasks.Register;
import com.sofka.userinterfaces.RegisterPage;
import com.sofka.utils.DataGenerator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class RegisterSteps {

    @Given("the user is on the registration page")
    public void theUserIsOnTheRegistrationPage() {
        Actor actor = OnStage.theActorCalled("User");
        actor.attemptsTo(NavigateTo.theRegisterPage());
    }

    @When("the user registers with valid data")
    public void theUserRegistersWithValidData() {
        Actor actor = OnStage.theActorInTheSpotlight();
        UserData userData = DataGenerator.generateRandomUser();
        actor.remember("registeredUser", userData);
        actor.attemptsTo(Register.withData(userData));
    }

    @When("the user tries to register with empty fields")
    public void theUserTriesToRegisterWithEmptyFields() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(Click.on(RegisterPage.REGISTER_BUTTON));
    }

    @Then("the registration should be successful")
    public void theRegistrationShouldBeSuccessful() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.should(seeThat(TheRegistration.wasSuccessful(), is(true)));
    }

    @Then("the registration should show an error")
    public void theRegistrationShouldShowAnError() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.should(seeThat(TheRegistration.showsError(), is(true)));
    }
}
