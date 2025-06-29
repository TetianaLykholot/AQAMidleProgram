package org.example;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class APITask {

    private static String token;

    @Test
    @Order(1)
    public void createAnonymusCart() {
        String endpoint = "https://www.neweracap.com/cart";
        Response response = given()
                .when()
                .post(endpoint)
                .then()
                .log().body()  // Log response body
                .extract().response();

        token = response.jsonPath().getString("token");
        System.out.println("Token Generated: " + token);
    }

    @Test
    @Order(2)
    public void testAddProductToCart() {
        String endpoint = "https://www.neweracap.com/cart/add.js";

        // Prepare request body
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("id", 46183040844003L);  // Product ID
        requestBody.put("quantity", 14);         // Quantity

        // POST request to add product to the cart
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + token)  // Token obtained in `testCreateCart`
                .body(requestBody)
                .when()
                .post(endpoint)
                .then()
                .log().status()  // Log status code
                .log().body()    // Log response body
                .extract().response();

    }

    @Test
    @Order(2)  // This test should run first
    public void testCartExists() {
        String endpoint = "https://www.neweracap.com/cart.js";

        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(endpoint)
                .then()
                .log().body().
                extract().response();
    }
}

