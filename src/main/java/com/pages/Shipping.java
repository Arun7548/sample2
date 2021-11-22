package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Shipping {
    WebDriver driver = null;
    WebElement element = null;
    seleniumImplimentation selenium = new seleniumImplimentation();

    By termsOfServices = By.id("uniform-cgv");
    By proccedToCheckout = By.cssSelector("#form > p > button");

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public boolean selectTermsOfService(){
        element = driver.findElement(termsOfServices);

        Boolean isSelected = element.isSelected();

        if(isSelected == false) {
            selenium.click(element);
        }
        return true;
    }

    public void clickOnProceedTOCheckout(){
        element = driver.findElement(proccedToCheckout);
        selenium.click(element);
    }
}
