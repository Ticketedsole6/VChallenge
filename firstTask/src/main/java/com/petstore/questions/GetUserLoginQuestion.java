package com.petstore.questions;

import io.restassured.http.Headers;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.HashMap;
import java.util.Map;

public class GetUserLoginQuestion implements Question<Map<String, String>> {
    @Override
    public Map<String, String> answeredBy(Actor actor) {
        Headers headers = SerenityRest.lastResponse().getHeaders();
        Map<String, String> selectedHeaders = new HashMap<>();
        selectedHeaders.put("X-Expires-After", headers.getValue("X-Expires-After"));
        selectedHeaders.put("X-Rate-Limit", headers.getValue("X-Rate-Limit"));
        return selectedHeaders;
    }
}
