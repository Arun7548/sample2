package com.pages;

import org.openqa.selenium.By;
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
    ReadExcelData excelData = new ReadExcelData();

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

    public void enterEmailInCreatAccount() throws IOException {

        List<Map<String,String>> userData = excelData.readTestData();

        element = driver.findElement(enterEmailInCreatAccount);
        element.sendKeys(userData.get(0).get("Email"));

        element = driver.findElement(submitCreatBtn);
        selenium.click(element);
    }

    public void yourPersonalInformation() throws IOException, InterruptedException {

        List<Map<String, String>> userData = excelData.readTestData();
        List<Map<String,Integer>> numaricValue = excelData.numaricData();

        if (userData.get(0).get("title").equals("Mr.")) {
            element = driver.findElement(titleMr);
            selenium.click(element);
        } else if (userData.get(0).get("title").equals("Mrs.")) {
            element = driver.findElement(titleMrs);
            selenium.click(element);
        } else {
            System.out.println("invalid title");
        }

        element = driver.findElement(customerFirstName);
        element.sendKeys(userData.get(0).get("First name "));

        element = driver.findElement(customerLastname);
        element.sendKeys(userData.get(0).get("Last name "));

        element = driver.findElement(newPassword);
        element.sendKeys(userData.get(0).get("Password"));

        if(userData.get(0).get("newsletter").equals("yes")){
            element = driver.findElement(newsletter);
            selenium.click(element);
        }
        if(userData.get(0).get("Receive special offers from our partners").equals("yes")){
            element = driver.findElement(optin);
            selenium.click(element);
        }
        element = driver.findElement(company);
        element.sendKeys(userData.get(0).get("Company"));

        element = driver.findElement(address1);
        element.sendKeys(userData.get(0).get("Address"));

        element = driver.findElement(address2);
        element.sendKeys(userData.get(0).get("Address2"));

        element = driver.findElement(city);
        element.sendKeys(userData.get(0).get("City"));

        element = driver.findElement(id_state);
        Select state = new Select(element);
        state.selectByVisibleText(userData.get(0).get("State"));

        element = driver.findElement(postcode);
        element.sendKeys(""+ numaricValue.get(0).get("zipCode"));

        element = driver.findElement(homePhone);
        element.sendKeys(""+ numaricValue.get(0).get("MobNumb"));

        element = driver.findElement(phoneMobile);
        element.sendKeys("" + numaricValue.get(0).get("HomeNumb"));

        element = driver.findElement(alias);
        element.sendKeys(userData.get(0).get("alias"));

        Thread.sleep(3000);
        element =driver.findElement(submitAccount);
        selenium.click(element);

    }

}
