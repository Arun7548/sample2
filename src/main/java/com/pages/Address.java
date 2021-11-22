package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Address {
    WebDriver driver = null;
    WebElement element = null;
    seleniumImplimentation selenium = new seleniumImplimentation();

    By additionalInformation = By.cssSelector("#ordermsg > textarea");
    By proceedToCheckout = new By.ByCssSelector("#center_column > form > p > button");
    By yourDeliveredAddress = By.id("address_delivery");
    By userName = new By.ByCssSelector("#address_delivery > li.address_firstname.address_lastname");
    By homePhone = new By.ByCssSelector("#address_delivery > li.address_phone");


    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public boolean validateAddress () throws IOException {
        ReadExcelData readExcelData = new ReadExcelData();
        List<Map<String,Integer>> numaricValue = readExcelData.numaricData();

       String homeNUmb = Integer.toString(numaricValue.get(0).get("MobNumb")) ;
        element = driver.findElement(homePhone);
        if(element.getText().equals(homeNUmb)){
            return true;
        }
        return false;
    }
    public void additionalInformation() {
        element = driver.findElement(additionalInformation);
        element.sendKeys("deliver as fast as possible");
    }

    public void proceedToCheckoutButton() throws InterruptedException {
        element = driver.findElement(proceedToCheckout);
        element.click();
        Thread.sleep(3000);
    }
}
