package com.petstore.tasks;

import com.petstore.models.User;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class PostCreateUserWithListTask implements Task {

    private final User[] userInfo;

    public PostCreateUserWithListTask(User[] userInfo) {
        this.userInfo = userInfo;
    }

    public static Performable withInfo(User[] userInfo) {
        return new PostCreateUserWithListTask(userInfo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/user/createWithList").with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(userInfo)
                )
        );
    }
}
