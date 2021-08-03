package com.tricentis.demowebshop.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ItemPage {
    SelenideElement itemTitleH1 = $("[itemprop='name']"),
            countItemInShoppingCart = $(".cart-qty"),
            btnAddCart = $(".add-to-cart-button");

    @Step("Проверить что название товара: {itemName}")
    public void checkTitleItem(String itemName) {
        itemTitleH1.shouldHave(text(itemName));
    }

    @Step("Получить кол-во товаров в корзине")
    public void checkCountItemsInShoppingCart(int count) {
        countItemInShoppingCart.shouldHave(text(String.format("(%s)", count)));
    }

    @Step("Нажать на кнопку добавления товара в корзину")
    public void addItemInShoppingCart() {
        btnAddCart.click();
    }

}
