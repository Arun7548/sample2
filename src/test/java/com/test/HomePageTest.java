package com.test;

import com.Util.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.pages.*;
import org.testng.Assert;
import org.testng.annotations.*;
import com.Util.*;

import java.io.IOException;
import java.time.Duration;


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
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }

    @AfterTest
    public void terminateBrowser() throws InterruptedException {


    }
    @AfterClass
    public void tesminteBrowser() throws InterruptedException {
        Thread.sleep(2000);
//        driver.quit();
    }


    @Test
    public void testClickOnDressesBtn() throws InterruptedException {
       String expectedBackgroundColor =  homePage.clickOnDresses();
       String actualBackgroundColor = "rgba(51, 51, 51, 1)";
       Assert.assertEquals(actualBackgroundColor,expectedBackgroundColor);
    }
    @Test(dependsOnMethods = "testClickOnDressesBtn")
    public void testAddToCartPrintedDresses() throws InterruptedException {
        Boolean expected = addToCartPage.addToCartPrintedDress();
        Assert.assertTrue(expected);
    }

    @Test(dependsOnMethods = "testAddToCartPrintedDresses")
    public void testClickOnTShitBtn() throws InterruptedException {
        String expectedBackgroundColor =  homePage.clickOnTshirt();
        String actualBackgroundColor = "rgba(51, 51, 51, 1)";
        Assert.assertEquals(actualBackgroundColor,expectedBackgroundColor);
    }

    @Test(dependsOnMethods = "testClickOnTShitBtn")
    public void testAddToCartTShirt() throws InterruptedException {
        boolean expected = addToCartPage.addToCartTShirt();
        Assert.assertTrue(expected);
    }

    @Test(dependsOnMethods = "testAddToCartTShirt")
    public void testProceedToCheckoutBtn(){
        homePage.proceedToCheckoutButton();
    }

    @Test(dependsOnMethods = "testProceedToCheckoutBtn")
    public void testSummary(){
        String expextedTotal = summary.clickOnProceedToCheckOut();
        String actualTotal = "$69.50";
        Assert.assertEquals(actualTotal,expextedTotal);
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider() throws IOException {
//        Object[][] data = ReadExcelData.readDataFromEcxelSheet();
        Object[][] data = Helper.readDataFromEcxelSheet();

        return data;
    }

    @Test(dependsOnMethods = "testSummary", dataProvider = "dataProvider")
    public void testEnterEmailInCreatAccount(Object[] data) throws IOException, InterruptedException {
        Thread.sleep(2000);
        if(data[19].toString().equals("y") && data[19] != null){
            signInPage.enterEmailInCreatAccount(data);

        }

    }
    @Test(dependsOnMethods = "testEnterEmailInCreatAccount",dataProvider = "dataProvider")
    public void testValidateAddress(Object[] data) throws IOException {
        if(data[19].toString().equals("y")) {
            Boolean expected = address.validateAddress(data);
            Assert.assertTrue(expected);
        }
    }
    @Test(dependsOnMethods = "testValidateAddress")
    public void testAdditionalInformation(){
         address.additionalInformation();
    }


    @Test(dependsOnMethods = "testAdditionalInformation")
    public void testProceedToCheckoutButton() throws InterruptedException {
        address.proceedToCheckoutButton();

    }

    @Test(dependsOnMethods = "testProceedToCheckoutButton")
    public void testSelectTermsOfService(){
        Boolean expected = shipping.selectTermsOfService();
        Assert.assertTrue(expected);
    }

    @Test(dependsOnMethods = "testSelectTermsOfService")
    public void testClickOnProceedTOCheckout(){
        shipping.clickOnProceedTOCheckout();
    }

    @Test(dependsOnMethods = "testClickOnProceedTOCheckout")
    public void testPayment(){
        String expectedAmount = payment.payment();
        String actualAmount = "$69.50";
        Assert.assertEquals(actualAmount,expectedAmount);
    }
    @Test(dependsOnMethods = "testPayment")
    public void testIConfirmMyOrder(){
        String expectedAmount = payment.IConfirmMyOrder();
        String actualAmount = "$69.50";
        Assert.assertEquals(actualAmount,expectedAmount);
    }
}
