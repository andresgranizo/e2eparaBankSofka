package com.sofka.questions;

import com.sofka.userinterfaces.BillPayPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class TheWithdrawal {

    public static Question<Boolean> wasSuccessful() {
        return actor -> Visibility.of(BillPayPage.SUCCESS_MESSAGE).answeredBy(actor);
    }
}
