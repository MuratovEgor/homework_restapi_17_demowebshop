package com.tricentis.demowebshop.tests;

import com.tricentis.demowebshop.api.AddItemRequest;
import com.tricentis.demowebshop.api.LoginRequest;
import com.tricentis.demowebshop.pages.ItemPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class ShoppingCartTests extends TestBase {
    ItemPage itemPage = new ItemPage();
    LoginRequest loginRequest = new LoginRequest();
    AddItemRequest addItemRequest = new AddItemRequest();

    @BeforeEach
    void openSite() {
        open("/build-your-cheap-own-computer");
    }

    @Test
    @DisplayName("Добавление товара через UI")
    void addItemByUI() {
        itemPage.checkTitleItem("Build your own cheap computer");
        itemPage.checkCountItemsInShoppingCart(0);
        itemPage.addItemInShoppingCart();
        itemPage.checkCountItemsInShoppingCart(1);
    }

    @Test()
    @DisplayName("Добавление товара через API и проверка через UI")
    void addItemByApi() {
        loginRequest.setAuthorizationCookieToBrowser("NOPCOMMERCE.AUTH");
        addItemRequest.addItem();
        itemPage.checkCountItemsInShoppingCart(1);
    }
}
