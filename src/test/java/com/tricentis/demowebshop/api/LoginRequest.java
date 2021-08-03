package com.tricentis.demowebshop.api;

import com.tricentis.demowebshop.config.Credentials;
import com.tricentis.demowebshop.config.Project;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.restassured.RestAssured.given;

public class LoginRequest {
    String email = Credentials.credentials.email(),
            pass = Credentials.credentials.password(),
            url = Project.config.baseUrl();

    @Step("Авторизоваться на сайте через API и получить Cookie: {cookieName}")
    public String getAuthorizationCookie(String cookieName) {
        return given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("Email", email)
                .formParam("Password", pass)
                .when()
                .post(url + "/login")
                .then()
                .statusCode(302)
                .extract()
                .cookie(cookieName);
    }

    @Step("Установаить Cookie: {cookieName}")
    public void setAuthorizationCookieToBrowser(String cookieName) {
        getWebDriver().manage().addCookie(new Cookie(cookieName, getAuthorizationCookie(cookieName)));
    }

}
