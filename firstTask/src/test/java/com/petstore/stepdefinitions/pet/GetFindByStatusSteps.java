package com.petstore.stepdefinitions.pet;

import com.petstore.interactions.CheckHealth;
import com.petstore.models.Pets;
import com.petstore.questions.GetFindByStatusQuestion;
import com.petstore.questions.ResponseCodeQuestion;
import com.petstore.tasks.GetFindByStatusTask;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class GetFindByStatusSteps {

    Actor actor = OnStage.theActorCalled("Tester");

    @Given("that the services of the pet store are available")
    public void thatTheServicesOfThePetStoreAreAvailable() {
        actor.attemptsTo(CheckHealth.petStore());
    }

    @When("^the tester send a get request to findByStatus endpoint by status (.+)$")
    public void theTesterSendAGetRequestToFindByStatusEndpointByStatus(String status) {
        actor.attemptsTo(GetFindByStatusTask.with().status(status));
    }

    @And("^the tester should obtain all pets by status (.+)$")
    public void theTesterShouldObtainAllPetsByStatus(String statusWord) {
        List<Pets> pets = new GetFindByStatusQuestion().answeredBy(actor);
        for (Pets pet : pets) {
            actor.should(
                    seeThat("status", act -> pet.getStatus(), notNullValue())
            );
            actor.should(
                    seeThat("status", act -> pet.getStatus(), equalTo(statusWord))
            );
        }
    }
}
