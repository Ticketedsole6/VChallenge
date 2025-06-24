package com.petstore.questions;

import com.petstore.models.User;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class PostCreateUserWithListQuestion implements Question {
    @Override
    public User[] answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(User[].class);
    }
}
