package com.sofka.questions;

import com.sofka.userinterfaces.TransferFundsPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class TheTransfer {

    public static Question<Boolean> wasSuccessful() {
        return actor -> Visibility.of(TransferFundsPage.SUCCESS_MESSAGE).answeredBy(actor);
    }
}
