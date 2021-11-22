package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCartPage {
    WebDriver driver = null;
    WebElement element = null;
    seleniumImplimentation selenium = null;

    By printedDress = new By.ByCssSelector("#center_column > ul > li:nth-child(2) > div > div.left-block > div > a.product_img_link > img");
    By addToCartForPrintedDress = new By.ByCssSelector("#center_column > ul > li:nth-child(2) > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default > span");
    By continueShoppingButtonOfPrintedDress = new By.ByCssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span > span");
    By cartText = new By.ByCssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a > span.ajax_cart_quantity");
    By fadedShortSleeveTShirt = new By.ByCssSelector("#center_column > ul > li");
    By TShirtAddToCardButton = new By.ByCssSelector("#center_column > ul > li > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default > span");
    By proceedToCheckoutButton = new By.ByCssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span");
    By productCount = new By.ByCssSelector(" a > span.ajax_cart_quantity");
    By closeWindowCross = new By.ByCssSelector("#layer_cart > div.clearfix > div.layer_cart_product.col-xs-12.col-md-6 > span");

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public boolean addToCartPrintedDress() throws InterruptedException {
        selenium = new seleniumImplimentation();
        element = driver.findElement(printedDress);
        selenium.mouseHover(element,driver);

        element = driver.findElement(addToCartForPrintedDress);
        selenium.click(element);
        selenium.refresh(driver);

        element = driver.findElement(continueShoppingButtonOfPrintedDress);
        selenium.clickOnPopUp(element,driver);

        selenium.refresh(driver);

        Thread.sleep(2000);

        element = driver.findElement(cartText);
        selenium.mouseHover(element,driver);
        Thread.sleep(2000);
        return (selenium.validateTest(driver,element,"1"));
    }

    public  boolean addToCartTShirt() throws InterruptedException {
        selenium = new seleniumImplimentation();
        element = driver.findElement(fadedShortSleeveTShirt);
        selenium.mouseHover(element,driver);

        element = driver.findElement(TShirtAddToCardButton);
        selenium.click(element);
        selenium.refresh(driver);

        element = driver.findElement(closeWindowCross);
        selenium.clickOnPopUp(element,driver);
        selenium.refresh(driver);

        element = driver.findElement(cartText);
        selenium.mouseHover(element,driver);
        Thread.sleep(2000);
        return selenium.validateTest(driver,element,"2");
    }
}
