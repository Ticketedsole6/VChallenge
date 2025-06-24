package com.petstore.stepdefinitions.pet;

import com.petstore.models.Category;
import com.petstore.models.Pets;
import com.petstore.questions.PostAddNewPetQuestion;
import com.petstore.tasks.PostAddNewPetTask;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class PostAddNewPetSteps {

    Actor actor = OnStage.theActorCalled("Tester");

    @When("the tester send a post request to pet endpoint with a new pet info")
    public void theTesterSendAPostRequestToPetEndpointWithANewPetInfo() {
        Pets petInfo = new Pets();
        List<String> array = new ArrayList<>();
        array.add("string");

        Category category = new Category();
        category.setId(1);
        category.setName("test");

        petInfo.setId(500);
        petInfo.setName("petTest");
        petInfo.setCategory(category);
        petInfo.setPhotoUrls(array);
        petInfo.setStatus("available");

        actor.attemptsTo(
                PostAddNewPetTask.withInfo(petInfo)
        );
    }

    @And("the tester in the response body should obtain the same request body")
    public void theTesterInTheResponseBodyShouldObtainTheSameRequestBody() {
        Pets petInfo = new Pets();

        petInfo.setId(500);
        petInfo.setName("petTest");
        petInfo.setStatus("available");

        Pets pets = new PostAddNewPetQuestion().answeredBy(actor);
        actor.should(seeThat("id", act -> pets.getId(), notNullValue()));
        actor.should(seeThat("id", act -> pets.getId(), equalTo(petInfo.getId())));
        actor.should(seeThat("name", act -> pets.getName(), equalTo(petInfo.getName())));
        actor.should(seeThat("status", act -> pets.getStatus(), equalTo(petInfo.getStatus())));
    }
}
