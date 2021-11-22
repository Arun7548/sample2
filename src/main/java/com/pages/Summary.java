package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Summary {
    WebDriver driver;
    WebElement element = null;

    seleniumImplimentation selenium = new seleniumImplimentation();

    By proceedToCheckOut = By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium");
    By total = By.id("total_price");
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public String  clickOnProceedToCheckOut(){

        String totalAmount;
        element = driver.findElement(total);
        totalAmount = element.getText();
        element = driver.findElement(proceedToCheckOut);
        selenium.click(element);
        return totalAmount;
    }
}
