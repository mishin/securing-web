package com.example.demo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class DemoApplicationTests {

    @Test
    public void postRequestExampleTest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "fdsssggrr");
        requestBody.put("password", "frhhgddss");

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toString());
        Response response = request.post("https://mobile.broker.vtb.ru/mob/AndroidTest/api/Auth/Login");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 400);
        String status = response.jsonPath().get("Status").toString();
        Assert.assertEquals(status, "2");
        String message = response.jsonPath().get("Message");
        Assert.assertEquals(message, "Fields [Login] should not be empty");
        System.out.println(response.getBody().asString());
    }
}
