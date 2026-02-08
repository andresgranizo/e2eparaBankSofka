package com.sofka.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    public static final Target REGISTER_LINK = Target.the("register link")
            .located(By.linkText("Register"));

    public static final Target USERNAME_INPUT = Target.the("username input")
            .located(By.name("username"));

    public static final Target PASSWORD_INPUT = Target.the("password input")
            .located(By.name("password"));

    public static final Target LOGIN_BUTTON = Target.the("login button")
            .located(By.xpath("//input[@value='Log In']"));

    public static final Target ERROR_MESSAGE = Target.the("error message")
            .located(By.className("error"));

    public static final Target WELCOME_MESSAGE = Target.the("welcome message")
            .located(By.className("smallText"));
}
