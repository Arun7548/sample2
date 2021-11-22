package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Payment {
    WebDriver driver = null;
    WebElement element = null;
    seleniumImplimentation selenium = new seleniumImplimentation();

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    By payByBankWire = new By.ByCssSelector("#HOOK_PAYMENT > div:nth-child(1) > div > p > a");
    By total = new By.ByCssSelector("#total_price");
    By bankWireTotal = new By.ByCssSelector("#amount");
    By iConfirmMyOrder = new By.ByCssSelector("#cart_navigation > button > span");

    public String payment(){
        String totalAmout;
        element =  driver.findElement(total);
        totalAmout = element.getText();

        element = driver.findElement(payByBankWire);
        selenium.click(element);
        return totalAmout;
    }
    public String IConfirmMyOrder(){
        String totalAmt;
        element = driver.findElement(bankWireTotal);
        totalAmt = element.getText();

        element = driver.findElement(iConfirmMyOrder);
        selenium.click(element);
        return totalAmt;
    }
}
