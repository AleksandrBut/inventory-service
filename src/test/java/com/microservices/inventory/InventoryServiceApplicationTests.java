package com.microservices.inventory;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class InventoryServiceApplicationTests {

    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    void contextLoads() {
        boolean inStockResponse = RestAssured.given()
                .when()
                .queryParam("skuCode", "iph_1")
                .queryParam("quantity", "1")
                .get("/api/inventory/stock")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(Boolean.class);

        boolean notInStockResponse = RestAssured.given()
                .when()
                .queryParam("skuCode", "iph_1")
                .queryParam("quantity", "500")
                .get("/api/inventory/stock")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(Boolean.class);

        assertTrue(inStockResponse);
        assertFalse(notInStockResponse);
    }
}
