package com.enmacc.task.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;

public class ContractControllerTest extends EnmaccApplicationTest {

    @LocalServerPort
    private int port;

    @BeforeAll
    public static void beforeAll() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @BeforeEach
    public void setup() {

        RestAssured.port = port;
        super.setUp();
    }

    @AfterEach
    public void tearDown() {
        super.tearDown();
    }


//    @Test
//    public void addContract() {
//        //language=JSON
//        String json = "{\n" +
//                "  \"fromCompany\": \"1\",\n" +
//                "  \"toCompany\": \"2\"\n" +
//                "}";
//
//        //@formatter:off
//        given()
//                .contentType(ContentType.JSON)
//                .body(json)
//                .when()
//                .post("contracts")
//                .then()
//                .statusCode(HttpStatus.SC_CREATED);
//        //@formatter:on
//    }
//
//    @Test
//    public void getAllPossibleSleeves() {
//
//        //@formatter:off
//        given()
//                .contentType(ContentType.JSON)
//                .param("fromCompany", "1")
//                .param("toCompany", "2")
//                .when()
//                .get("sleeves")
//                .then()
//                .statusCode(HttpStatus.SC_OK);
//        //@formatter:on
//
//    }
}