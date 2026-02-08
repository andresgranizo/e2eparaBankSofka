package com.sofka.questions;

import com.sofka.userinterfaces.RegisterPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;

public class TheRegistration {

    public static Question<Boolean> wasSuccessful() {
        return actor -> Visibility.of(RegisterPage.SUCCESS_MESSAGE).answeredBy(actor);
    }

    public static Question<String> welcomeMessage() {
        return actor -> Text.of(RegisterPage.WELCOME_TEXT).answeredBy(actor);
    }

    public static Question<Boolean> showsError() {
        return actor -> Visibility.of(RegisterPage.ERROR_MESSAGE).answeredBy(actor);
    }
}
