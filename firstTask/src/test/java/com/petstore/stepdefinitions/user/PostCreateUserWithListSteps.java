package com.petstore.stepdefinitions.user;

import com.petstore.models.User;
import com.petstore.questions.PostCreateUserWithListQuestion;
import com.petstore.tasks.PostCreateUserWithListTask;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class PostCreateUserWithListSteps {

    Actor actor = OnStage.theActorCalled("Tester");

    @When("the tester send a post request to create with list endpoint with valid user info")
    public void theTesterSendAPostRequestToCreateWithListEndpointWithValidUserInfo() {
        User userInfo = new User();
        userInfo.setId(10);
        userInfo.setUsername("theUser");
        userInfo.setFirstName("John");
        userInfo.setLastName("James");
        userInfo.setEmail("john@email.com");
        userInfo.setPassword("12345");
        userInfo.setPhone("12345");
        userInfo.setUserStatus(1);

        User userInfo2 = new User();
        userInfo2.setId(15);
        userInfo2.setUsername("theUser2");
        userInfo2.setFirstName("Alberto");
        userInfo2.setLastName("Gamez");
        userInfo2.setEmail("alberto@email.com");
        userInfo2.setPassword("12345");
        userInfo2.setPhone("12345");
        userInfo2.setUserStatus(1);

        actor.attemptsTo(
                PostCreateUserWithListTask.withInfo(new User[]{userInfo, userInfo2})
        );
    }

    @Then("the tester in the response body should get the same request body")
    public void theTesterInTheResponseBodyShouldGetTheSameRequestBody() {
        User[] user = new PostCreateUserWithListQuestion().answeredBy(actor);

        actor.should(seeThat("id", act -> user[0].getId(), notNullValue()));
        actor.should(seeThat("id", act -> user[0].getId(), equalTo(10)));
        actor.should(seeThat("username", act -> user[0].getUsername(), equalTo("theUser")));
        actor.should(seeThat("firstName", act -> user[0].getFirstName(), equalTo("John")));
        actor.should(seeThat("lastName", act -> user[0].getLastName(), equalTo("James")));
        actor.should(seeThat("email", act -> user[0].getEmail(), equalTo("john@email.com")));
        actor.should(seeThat("password", act -> user[0].getPassword(), equalTo("12345")));
        actor.should(seeThat("phone", act -> user[0].getPhone(), equalTo("12345")));
        actor.should(seeThat("userStatus", act -> user[0].getUserStatus(), equalTo(1)));

        actor.should(seeThat("id", act -> user[1].getId(), notNullValue()));
        actor.should(seeThat("id", act -> user[1].getId(), equalTo(15)));
        actor.should(seeThat("username", act -> user[1].getUsername(), equalTo("theUser2")));
        actor.should(seeThat("firstName", act -> user[1].getFirstName(), equalTo("Alberto")));
        actor.should(seeThat("lastName", act -> user[1].getLastName(), equalTo("Gamez")));
        actor.should(seeThat("email", act -> user[1].getEmail(), equalTo("alberto@email.com")));
        actor.should(seeThat("password", act -> user[1].getPassword(), equalTo("12345")));
        actor.should(seeThat("phone", act -> user[1].getPhone(), equalTo("12345")));
        actor.should(seeThat("userStatus", act -> user[1].getUserStatus(), equalTo(1)));
    }
}
