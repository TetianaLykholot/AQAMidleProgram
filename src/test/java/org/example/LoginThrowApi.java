package org.example;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LoginThrowApi {

    public static final String BASE_ENDPOINT = "https://www.neweracap.com/";

    public static Response sendRequest (String requestEndpoint, String token, Object body, String httpMethods, boolean withAuth){
        var request = given()
                .header("Content-Type","application/json")
                .header("Accept", "application/json");

                if(withAuth){
                    request.header("Authorization", "Bearer" + token);
                }

               if(body != null && (httpMethods.equalsIgnoreCase("POST" ) || httpMethods.equalsIgnoreCase(("PUT")))){
                   request.body(body);
        }
               switch (httpMethods.toUpperCase()){
                   case "POST":
                       return request.when().post(BASE_ENDPOINT + requestEndpoint);
                   case "PUT":
                       return request.when().put(BASE_ENDPOINT + requestEndpoint);
                   case "GET":
                       return request.when().get(BASE_ENDPOINT + requestEndpoint);
                   case "DELETE":
                       return request.when().delete(BASE_ENDPOINT + requestEndpoint);
                   default:
                       throw new IllegalArgumentException("Unsupported HTTP method: " + httpMethods);
               }
    }

    public static Response logInWithAuthentication(String requestEndpoint, String token, Object body, String httpMethod) {
        return sendRequest(requestEndpoint, token, body, httpMethod, true);
    }

    public static Response logInWithoutAuthentication(String requestEndpoint, String httpMethod) {
        return sendRequest(requestEndpoint, null, null, httpMethod, false);
    }

}
