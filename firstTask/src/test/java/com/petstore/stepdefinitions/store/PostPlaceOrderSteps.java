package com.petstore.stepdefinitions.store;

import com.petstore.models.Order;
import com.petstore.questions.PostPlaceOrcerQuestion;
import com.petstore.tasks.PostPlaceOrderTask;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class PostPlaceOrderSteps {

    Actor actor = OnStage.theActorCalled("Tester");

    @When("the tester send a post request to order endpoint with valid pet info")
    public void theTesterSendAPostRequestToOrderEndpointWithValidPetInfo() {
        Order orderInfo = new Order();
        orderInfo.setId(10);
        orderInfo.setPetId(198772);
        orderInfo.setQuantity(7);
        orderInfo.setShipDate("2025-05-29T14:42:31.904Z");
        orderInfo.setStatus("approved");
        orderInfo.setComplete(true);

        actor.attemptsTo(
                PostPlaceOrderTask.withInfo(orderInfo)
        );
    }

    @And("the tester in the response body should get the same request body but in the shipDate field it may not be the same")
    public void theTesterInTheResponseBodyShouldGetTheSameRequestBodyButInTheShipDateFieldItMayNotBeTheSame() {
        Order orderInfo = new Order();
        orderInfo.setId(10);
        orderInfo.setPetId(198772);
        orderInfo.setQuantity(7);
        orderInfo.setShipDate("2024-05-29T14:42:31.904Z");
        orderInfo.setStatus("approved");
        orderInfo.setComplete(true);

        Order order = new PostPlaceOrcerQuestion().answeredBy(actor);
        actor.should(seeThat("id", act -> order.getId(), notNullValue()));
        actor.should(seeThat("id", act -> order.getId(), equalTo(orderInfo.getId())));
        actor.should(seeThat("petId", act -> order.getPetId(), equalTo(orderInfo.getPetId())));
        actor.should(seeThat("quantity", act -> order.getQuantity(), equalTo(orderInfo.getQuantity())));
        actor.should(seeThat("status", act -> order.getStatus(), equalTo(orderInfo.getStatus())));
        actor.should(seeThat("complete", act -> order.getComplete(), equalTo(orderInfo.getComplete())));
    }
}
