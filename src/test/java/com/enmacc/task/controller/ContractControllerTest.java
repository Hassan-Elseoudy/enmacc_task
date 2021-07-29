package com.enmacc.task.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContractControllerTest {

    @LocalServerPort
    private int port;

    @BeforeAll
    public static void beforeAll() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @BeforeEach
    public void beforeTest() {
        RestAssured.port = port;
    }

    @Test
    public void addContract() {
        //language=JSON
        String json = "{\n" +
                "  \"aCompany\": \"A\",\n" +
                "  \"anotherCompany\": \"B\"\n" +
                "}";

        //@formatter:off
        given()
            .contentType(ContentType.JSON)
            .body(json)
        .when()
            .post("contracts")
        .then()
            .statusCode(HttpStatus.SC_CREATED);
        //@formatter:on
    }

    @Test
    public void getAllPossibleSleeves() {

        //@formatter:off
        given()
            .contentType(ContentType.JSON)
            .param("aCompany", "A")
            .param("anotherCompany", "B")
        .when()
            .get("sleeves")
        .then()
            .statusCode(HttpStatus.SC_OK);
        //@formatter:on

    }
}