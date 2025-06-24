package com.petstore.stepdefinitions.common;

import com.petstore.questions.ResponseCodeQuestion;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CommonStatusSteps {
    Actor actor = OnStage.theActorCalled("Tester");

    @Then("the tester should obtain a {int} error")
    public void theTesterShouldObtainAError(Integer error) {
        actor.should(
                seeThat("response code", ResponseCodeQuestion.was(), equalTo(error))
        );
    }

    @Then("the tester should obtain a status ok")
    public void theTesterShouldObtainAStatusOk() {
        actor.should(
                seeThat("response code", ResponseCodeQuestion.was(), equalTo(200))
        );
    }
}
