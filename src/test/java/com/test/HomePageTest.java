package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class HomePageTest {
    WebDriver driver = null;
    String baseURL = "http://automationpractice.com/index.php";
    String driverPath = "chromedriver";

    HomePage homePage = new HomePage();
    SignInPage signInPage = new SignInPage();
    Summary summary = new Summary();
    Address address = new Address();
    Shipping shipping = new Shipping();
    AddToCartPage addToCartPage = new AddToCartPage();
    Payment payment = new Payment();


    @BeforeTest
    public void launchBrowser(){
        System.setProperty("WebDriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        homePage.setDriver(driver);
        summary.setDriver(driver);
        signInPage.setDriver(driver);
        address.setDriver(driver);
        shipping.setDriver(driver);
        addToCartPage.setDriver(driver);
        payment.setDriver(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterTest
    public void terminateBrowser() throws InterruptedException {
        Thread.sleep(2000);

    }

    @Test(priority = 1)
    public void testClickOnDressesBtn() throws InterruptedException {
       String expectedBackgroundColor =  homePage.clickOnDresses();
       String actualBackgroundColor = "rgba(51, 51, 51, 1)";
       Assert.assertEquals(actualBackgroundColor,expectedBackgroundColor);
    }
    @Test(priority = 2)
    public void testAddToCartPrintedDresses() throws InterruptedException {
        Boolean expected = addToCartPage.addToCartPrintedDress();
        Assert.assertTrue(expected);
    }

    @Test(priority = 3)
    public void testClickOnTShitBtn() throws InterruptedException {
        String expectedBackgroundColor =  homePage.clickOnTshirt();
        String actualBackgroundColor = "rgba(51, 51, 51, 1)";
        Assert.assertEquals(actualBackgroundColor,expectedBackgroundColor);
    }

    @Test(priority = 4)
    public void testAddToCartTShirt() throws InterruptedException {
        boolean expected = addToCartPage.addToCartTShirt();
        Assert.assertTrue(expected);
    }

    @Test(priority = 5)
    public void testProceedToCheckoutBtn(){
        homePage.proceedToCheckoutButton();
    }

    @Test(priority = 6)
    public void testSummary(){
        String expextedTotal = summary.clickOnProceedToCheckOut();
        String actualTotal = "$69.50";
        Assert.assertEquals(actualTotal,expextedTotal);
    }

    @Test(priority = 7)
    public void testEnterEmailInCreatAccount() throws IOException {
        signInPage.enterEmailInCreatAccount();
    }
    @Test(priority = 8)
    public void testYourPersonalInformation() throws IOException, InterruptedException {
        signInPage.yourPersonalInformation();
    }
    @Test(priority = 9)
    public void testValidateAddress() throws IOException {
        Boolean expected = address.validateAddress();
        Assert.assertTrue(expected);
    }
    @Test(priority = 10)
    public void testAdditionalInformation(){
         address.additionalInformation();
    }


    @Test(priority = 11)
    public void testProceedToCheckoutButton() throws InterruptedException {
        address.proceedToCheckoutButton();

    }

    @Test(priority = 12)
    public void testSelectTermsOfService(){
        Boolean expected = shipping.selectTermsOfService();
        Assert.assertTrue(expected);
    }

    @Test(priority = 13)
    public void testClickOnProceedTOCheckout(){
        shipping.clickOnProceedTOCheckout();
    }

    @Test(priority = 14)
    public void testPayment(){
        String expectedAmount = payment.payment();
        String actualAmount = "$69.50";
        Assert.assertEquals(actualAmount,expectedAmount);
    }
    @Test(priority = 15)
    public void testIConfirmMyOrder(){
        String expectedAmount = payment.IConfirmMyOrder();
        String actualAmount = "$69.50";
        Assert.assertEquals(actualAmount,expectedAmount);
    }
}
