package com.petstore.stepdefinitions.common;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

public class Hooks {
    private EnvironmentVariables environmentVariables;

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());

        String baseUrl = environmentVariables.getProperty("serenity.baseurl");
        RestAssured.baseURI = baseUrl;

        OnStage.theActorCalled("Tester").can(CallAnApi.at(baseUrl));
    }
}
