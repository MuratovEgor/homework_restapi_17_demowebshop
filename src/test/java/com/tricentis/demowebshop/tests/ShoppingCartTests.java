package com.tricentis.demowebshop.tests;

import com.tricentis.demowebshop.pages.ItemPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class ShoppingCartTests extends TestBase {
    ItemPage itemPage = new ItemPage();

    @BeforeEach
    void openSite() {
        open("/build-your-cheap-own-computer");
    }

    @Test
    void addItemByUI() {
        itemPage.checkTitleItem("Build your own cheap computer");
        itemPage.checkCountItemsInShoppingCart(0);
        itemPage.addItemInShoppingCart();
        itemPage.checkCountItemsInShoppingCart(1);
    }
}
