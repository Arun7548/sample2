package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;
import java.util.Map;



public class SignInPage {

    WebDriver driver = null;
    WebElement element = null;
    seleniumImplimentation selenium = new seleniumImplimentation();
//    ReadExcelData excelData = new ReadExcelData();

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }



    By enterEmailInCreatAccount = By.id("email_create");
    By submitCreatBtn = By.id("SubmitCreate");


    By titleMr = By.id("id_gender1");
    By titleMrs = By.id("id_gender2");
    By customerFirstName = By.id("customer_firstname");
    By customerLastname = By.id("customer_lastname");
    By newPassword = By.id("passwd");
    By newsletter = By.id("newsletter");
    By optin = By.id("optin");
    By company = By.id("company");
    By address1 = By.id("address1");
    By address2 = By.id("address2");
    By city = By.id("city");
    By id_state = By.id("id_state");
    By postcode = By.id("postcode");
    By id_country = By.id("id_country");
    By additionalInfo = By.id("other");
    By homePhone = By.id("phone");
    By phoneMobile = By.id("phone_mobile");
    By alias = By.id("alias");
    By submitAccount = By.id("submitAccount");
    By invalidEmail = new By.ByCssSelector("#create_account_error > ol > li");
    By emalAlreadyPresent = new By.ByCssSelector("#create_account_error > ol > li");

    By emailPresent = new By.ByCssSelector("#create_account_error");

    public void enterEmailInCreatAccount(Object[] data) throws IOException, InterruptedException {

//        List<Map<String,String>> userData = excelData.readTestData();

        element = driver.findElement(enterEmailInCreatAccount);
        element.sendKeys(data[4].toString());

        element = driver.findElement(submitCreatBtn);
        selenium.click(element);

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0]",element);
//        if(driver.findElement(invalidEmail).isDisplayed() || driver.findElement(emailPresent).isDisplayed()){
//            element = driver.findElement(enterEmailInCreatAccount);
//            element.clear();
//        }
        Thread.sleep(2000);

        if (data[1].toString().equals("Mr.")) {
            element = driver.findElement(titleMr);
            selenium.click(element);
        } else if (data[1].toString().equals("Mrs.")) {
            element = driver.findElement(titleMrs);
            selenium.click(element);
        } else {
            System.out.println("invalid title");
        }

        element = driver.findElement(customerFirstName);
        element.sendKeys(data[2].toString());

        element = driver.findElement(customerLastname);
        element.sendKeys(data[3].toString());

        element = driver.findElement(newPassword);
        element.sendKeys(data[5].toString());

        if(data[6].toString().equals("yes")){
            element = driver.findElement(newsletter);
            selenium.click(element);
        }
        if(data[7].toString().equals("yes")){
            element = driver.findElement(optin);
            selenium.click(element);
        }
        element = driver.findElement(company);
        element.sendKeys(data[8].toString());

        element = driver.findElement(address1);
        element.sendKeys(data[9].toString());

        element = driver.findElement(address2);
        element.sendKeys(data[10].toString());

        element = driver.findElement(city);
        element.sendKeys(data[11].toString());

        element = driver.findElement(id_state);
        Select state = new Select(element);
        state.selectByVisibleText(data[12].toString());

        element = driver.findElement(postcode);
        element.sendKeys( String.valueOf(Math.round((Double)data[16])));

        element = driver.findElement(homePhone);
        element.sendKeys( String.valueOf(Math.round((Double)data[17])));

        element = driver.findElement(phoneMobile);
        element.sendKeys( String.valueOf(Math.round((Double)data[18])));

        Thread.sleep(3000);
        element =driver.findElement(submitAccount);
        selenium.click(element);

    }

    public void yourPersonalInformation(Object[] data) throws IOException, InterruptedException {

//        List<Map<String, String>> userData = excelData.readTestData();
//        List<Map<String,Integer>> numaricValue = excelData.numaricData();

      /*  if (data[1].toString().equals("Mr.")) {
            element = driver.findElement(titleMr);
            selenium.click(element);
        } else if (data[1].toString().equals("Mrs.")) {
            element = driver.findElement(titleMrs);
            selenium.click(element);
        } else {
            System.out.println("invalid title");
        }

        element = driver.findElement(customerFirstName);
        element.sendKeys(data[2].toString());

        element = driver.findElement(customerLastname);
        element.sendKeys(data[3].toString());

        element = driver.findElement(newPassword);
        element.sendKeys(data[5].toString());

        if(data[6].toString().equals("yes")){
            element = driver.findElement(newsletter);
            selenium.click(element);
        }
        if(data[7].toString().equals("yes")){
            element = driver.findElement(optin);
            selenium.click(element);
        }
        element = driver.findElement(company);
        element.sendKeys(data[8].toString());

        element = driver.findElement(address1);
        element.sendKeys(data[9].toString());

        element = driver.findElement(address2);
        element.sendKeys(data[10].toString());

        element = driver.findElement(city);
        element.sendKeys(data[11].toString());

        element = driver.findElement(id_state);
        Select state = new Select(element);
        state.selectByVisibleText(data[12].toString());
*/
//        element = driver.findElement(postcode);
//        element.sendKeys(""+ numaricValue.get(0).get("zipCode"));
////        element.sendKeys((CharSequence) data[16]);
//        element = driver.findElement(homePhone);
//        element.sendKeys(""+ numaricValue.get(0).get("MobNumb"));
//
//        element = driver.findElement(phoneMobile);
//        element.sendKeys("" + numaricValue.get(0).get("HomeNumb"));

        element = driver.findElement(alias);
//        element.sendKeys(userData.get(0).get("alias"));

        Thread.sleep(3000);
        element =driver.findElement(submitAccount);
        selenium.click(element);

    }

}
