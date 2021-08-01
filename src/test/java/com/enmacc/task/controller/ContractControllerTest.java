package com.enmacc.task.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ContractControllerTest extends EnmaccApplicationTest {

    @LocalServerPort
    private int port;

    @Autowired
    public MockMvc mockMvc;

    @BeforeAll
    static void beforeAll() {
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


    @Test
    public void addContract() {
        //language=JSON
        String json = "{\n" +
                "  \"fromCompany\": \"1\",\n" +
                "  \"toCompany\": \"2\"\n" +
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
    public void getAllContractsShouldReturn3() throws Exception {
        // Act
        mockMvc.perform(MockMvcRequestBuilders.
                get("/contracts")
                .contentType(MediaType.APPLICATION_JSON))
                // Assert
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }



    @Test
    @Order(3)
    public void getAllPossibleSleeves() {
        //@formatter:off
        given()
                .contentType(ContentType.JSON)
                .param("aCompany", "1")
                .param("bCompany", "2")
                .when()
                .get("sleeves")
                .then()
                .statusCode(HttpStatus.SC_OK);
        //@formatter:on

    }
}