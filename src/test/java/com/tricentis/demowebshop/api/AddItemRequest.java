package com.tricentis.demowebshop.api;

import com.tricentis.demowebshop.config.Project;
import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class AddItemRequest {
    String url = Project.config.baseUrl();

    @Step("Добавить товар и проверить что он добавился только один через API")
    public void addItem() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body("product_attribute_72_5_18=53&product_attribute_72_6_19=54&" +
                        "product_attribute_72_3_20=58&product_attribute_72_8_30=93&" +
                        "addtocart_72.EnteredQuantity=1")
                .when()
                .post(url + "/addproducttocart/details/72/1")
                .then()
                .statusCode(200)
                .body("success", is(true))
                .body("updatetopcartsectionhtml", is("(1)"));
    }
}
