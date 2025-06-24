package com.petstore.stepdefinitions.pet;

import com.petstore.models.Pets;
import com.petstore.questions.GetFindByIdQuestion;
import com.petstore.tasks.GetFindByIdTask;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class GetFindByIdSteps {

    Actor actor = OnStage.theActorCalled("Tester");

    @When("^the tester send a get request to findById endpoint by id (.+)$")
    public void theTesterSendAGetRequestToFindByIdEndpointById(Integer id) {
        actor.attemptsTo(GetFindByIdTask.with().id(id));
    }

    @And("^the tester should obtain all pets with id (.+)$")
    public void theTesterShouldObtainAllPetsWithId(Integer idNumber) {
        Pets pets = new GetFindByIdQuestion().answeredBy(actor);
        actor.should(
                seeThat("id", act -> pets.getId(), notNullValue())
        );
        actor.should(
                seeThat("id", act -> pets.getId(), equalTo(idNumber))
        );
    }
}
