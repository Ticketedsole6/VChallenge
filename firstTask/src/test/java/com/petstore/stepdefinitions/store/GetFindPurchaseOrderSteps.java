package com.petstore.stepdefinitions.store;

import com.petstore.models.Order;
import com.petstore.questions.GetFindPurchaseOrderQuestion;
import com.petstore.tasks.GetFindPurchaseOrderTask;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class GetFindPurchaseOrderSteps {

    Actor actor = OnStage.theActorCalled("Tester");

    @When("the tester send a get request to order endpoint with {int} orderId")
    public void theTesterSendAGetRequestToOrderEndpointWithOrderId(Integer id) {
        actor.attemptsTo(GetFindPurchaseOrderTask.with().id(id));
    }

    @And("the tester in the response body should get the purchase information for {int} orderId")
    public void theTesterInTheResponseBodyShouldGetThePurchaseInformationForOrderId(Integer idNumber) {

        Order orderInfo = new Order();
        orderInfo.setId(10);
        orderInfo.setPetId(198772);
        orderInfo.setQuantity(7);
        orderInfo.setStatus("approved");
        orderInfo.setComplete(true);

        Order purchase = new GetFindPurchaseOrderQuestion().answeredBy(actor);
        actor.should(seeThat("id", act -> purchase.getId(), notNullValue()));
        actor.should(seeThat("id", act -> purchase.getId(), equalTo(idNumber)));
        actor.should(seeThat("petId", act -> purchase.getPetId(), equalTo(orderInfo.getPetId())));
        actor.should(seeThat("quantity", act -> purchase.getQuantity(), equalTo(orderInfo.getQuantity())));
        actor.should(seeThat("status", act -> purchase.getStatus(), equalTo(orderInfo.getStatus())));
        actor.should(seeThat("complete", act -> purchase.getComplete(), equalTo(orderInfo.getComplete())));
    }
}
