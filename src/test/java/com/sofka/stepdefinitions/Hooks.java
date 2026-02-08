package com.sofka.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.net.HttpURLConnection;
import java.net.URL;

public class Hooks {

    private static boolean dbInitialized = false;

    @Before
    public void setTheStage() {
        initializeParaBankDB();
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void drawTheCurtain() {
        OnStage.drawTheCurtain();
    }

    private void initializeParaBankDB() {
        if (!dbInitialized) {
            try {
                URL url = new URL("https://parabank.parasoft.com/parabank/services/bank/initializeDB");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.getResponseCode();
                conn.disconnect();
                dbInitialized = true;
            } catch (Exception e) {
                // Continue even if initialization fails
            }
        }
    }
}
