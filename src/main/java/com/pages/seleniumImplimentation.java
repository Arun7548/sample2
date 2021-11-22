package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class seleniumImplimentation {
    Actions action = null;

    public void click(WebElement element){
        element.click();
    }
    public void mouseHover(WebElement element, WebDriver driver){
        action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }
    public void clickOnPopUp(WebElement element, WebDriver driver){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click",element);
    }
    public void refresh(WebDriver driver){
        driver.navigate().refresh();
    }
    public boolean validateTest(WebDriver driver, WebElement element, String expectedText){
       String observedText = element.getText();
       if(observedText.equals(expectedText)){
           return true;
       }
        return false;
    }
}
