package com.sofka.questions;

import com.sofka.userinterfaces.AccountsOverviewPage;
import com.sofka.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class TheLogin {

    public static Question<Boolean> wasSuccessful() {
        return actor -> Visibility.of(AccountsOverviewPage.ACCOUNTS_OVERVIEW_TITLE).answeredBy(actor);
    }

    public static Question<Boolean> showsError() {
        return actor -> Visibility.of(HomePage.ERROR_MESSAGE).answeredBy(actor);
    }
}
