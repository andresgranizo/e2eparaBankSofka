package com.sofka.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegisterPage {

    public static final Target FIRST_NAME = Target.the("first name input")
            .located(By.id("customer.firstName"));

    public static final Target LAST_NAME = Target.the("last name input")
            .located(By.id("customer.lastName"));

    public static final Target ADDRESS = Target.the("address input")
            .located(By.id("customer.address.street"));

    public static final Target CITY = Target.the("city input")
            .located(By.id("customer.address.city"));

    public static final Target STATE = Target.the("state input")
            .located(By.id("customer.address.state"));

    public static final Target ZIP_CODE = Target.the("zip code input")
            .located(By.id("customer.address.zipCode"));

    public static final Target PHONE = Target.the("phone input")
            .located(By.id("customer.phoneNumber"));

    public static final Target SSN = Target.the("SSN input")
            .located(By.id("customer.ssn"));

    public static final Target USERNAME = Target.the("username input")
            .located(By.id("customer.username"));

    public static final Target PASSWORD = Target.the("password input")
            .located(By.id("customer.password"));

    public static final Target CONFIRM_PASSWORD = Target.the("confirm password input")
            .located(By.id("repeatedPassword"));

    public static final Target REGISTER_BUTTON = Target.the("register button")
            .located(By.xpath("//input[@value='Register']"));

    public static final Target SUCCESS_MESSAGE = Target.the("success message")
            .located(By.xpath("//p[contains(text(),'Your account was created successfully')]"));

    public static final Target ERROR_MESSAGE = Target.the("error message")
            .located(By.className("error"));

    public static final Target WELCOME_TEXT = Target.the("welcome text")
            .located(By.xpath("//h1[contains(@class,'title')]"));
}
