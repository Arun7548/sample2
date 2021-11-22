package com.pages;

import org.openqa.selenium.*;

public class HomePage {
    public WebDriver driver = null;
    private WebElement element = null;
    seleniumImplimentation selenium = new seleniumImplimentation();

    By DRESSESButton = new By.ByCssSelector( "#block_top_menu > ul > li:nth-child(2) > a");
    By TshirtButton = new By.ByCssSelector("#block_top_menu > ul > li:nth-child(3) > a");
    By proceedToCheckoutbtn = new By.ByCssSelector("#button_order_cart > span");

    public void setDriver(WebDriver driver){
        this.driver = driver;
    }

    public String clickOnDresses() throws InterruptedException {
        String backgroundColor;
        selenium = new seleniumImplimentation();
        element = driver.findElement(DRESSESButton);
        selenium.mouseHover(element,driver);
        backgroundColor = element.getCssValue("background-color");
        selenium.click(element);
        Thread.sleep(2000);
        return backgroundColor;
    }

    public String clickOnTshirt() throws InterruptedException {
        selenium = new seleniumImplimentation();
        String backgroundColor;
        element = driver.findElement(TshirtButton);
        selenium.mouseHover(element,driver);
        backgroundColor = element.getCssValue("background-color");
        selenium.click(element);
        Thread.sleep(1000);
        return backgroundColor;
    }

    public void proceedToCheckoutButton(){
        element = driver.findElement(proceedToCheckoutbtn);
        selenium.click(element);
    }
}
