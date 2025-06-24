package com.petstore.stepdefinitions.user;

import com.petstore.questions.GetUserLoginQuestion;
import com.petstore.tasks.GetUserLoginTask;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GetUserLoginSteps {

    Actor actor = OnStage.theActorCalled("Tester");

    @When("the tester send a get request to login as a user")
    public void theTesterSendAGetRequestToLoginAsAUser() {
        actor.attemptsTo(GetUserLoginTask.with());
    }

    @Then("the tester in the response headers obtain two specific headers")
    public void theTesterInTheResponseHeadersObtainTwoSpecificHeaders() {
        Map<String, String> headers = actor.asksFor(new GetUserLoginQuestion());

        assertThat(headers.get("X-Rate-Limit"))
                .isNotNull()
                .isInstanceOf(Integer.class);
        assertThat(headers.get("X-Expires-After"))
                .isNotNull()
                .isInstanceOf(String.class);

    }
}
