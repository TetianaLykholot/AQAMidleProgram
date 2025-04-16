package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

public class ApiTask extends LoginThrowApi {
    Product product = new Product("46183040844003", 2);
    private static String token;

    @BeforeAll
    public static void createAnonymusCart() {
        token = logInWithoutAuthentication("cart.json", "POST")
                .then()
                .log()
                .body()
                .extract()
                .response()
                .jsonPath()
                .getString("token");
        SessionStorage.store("guid", token);
        System.out.println("Token Generated: " + token);

    }

    @Test
    @Order(1)
    public void testAddProductToCart() {
        System.out.println("Token used for adding cart: " + token);
        logInWithAuthentication("cart/add.json", token, product, "POST")
                .then()
                .log()
                .body()
                .statusCode(200);
    }

    @Test
    @Order(2)
    public void checkThatProductExistInTheCart() {
        System.out.println("Token used for checking cart: " + token);
        var response = logInWithAuthentication("cart.json", token, null, "GET")
                .then()
                .log()
                .body()
                .extract()
                .response()
                .jsonPath()
                .getString("product_title");
    }
}

