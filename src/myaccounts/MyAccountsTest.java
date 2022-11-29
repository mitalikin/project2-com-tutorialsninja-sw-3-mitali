package myaccounts;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MyAccountsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUP() {
        openBrowser(baseUrl);
    }

    public void selectMyAccountOptions(String option) {
        if (option == "Register") {
            //1.1 Click on My Account Link.
            clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
            //1.3 Verify the text “Register Account”.
            clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
            String expectedTital = "Register";
            String actualTitle = getTextFromElement(By.xpath("//a[contains(text(),'Register')]"));
            Assert.assertEquals("Title not matched", expectedTital, expectedTital);
        } else if (option == "Login") {
            //1.1 Click on My Account Link.
            clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
            //1.3 Verify the text “Login Account”.
            clickOnElement(By.xpath("//a[contains(text(),'Login')]"));
            String expectedTital = "Login";
            String actualTitle = getTextFromElement(By.xpath("//a[contains(text(),'Login')]"));
            Assert.assertEquals("Title not matched", expectedTital, expectedTital);
            //2.3 Verify the text “Returning Customer”.
            assertVerifyText(By.xpath("//h2[contains(text(),'Returning Customer')]"), "Returning Customer");

        } else if (option=="Logout"){
            clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
            clickOnElement(By.xpath("//a[normalize-space()='Logout']"));

        }else{
            System.out.println("Title is not matched");
        }
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        selectMyAccountOptions("Register");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        selectMyAccountOptions("Login");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        //3.1 Click on My Account Link.---already used in selectMyAccountOptions("Register")
        //clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter“Register”
        selectMyAccountOptions("Register");
        //3.3 Enter First Name
        sendTexTooElement(By.id("input-firstname"), "clare");
        //3.4 Enter Last Name
        sendTexTooElement(By.id("input-lastname"), "white");
        //3.5 Enter Email----use another Email-id to run
        sendTexTooElement(By.id("input-email"), "xyx110@gmail.com");
        //3.6 Enter Telephone
        sendTexTooElement(By.id("input-telephone"), "07834675434");
        //3.7 Enter Password
        sendTexTooElement(By.id("input-password"), "xyz123");
        //3.8 Enter Password Confirm
        sendTexTooElement(By.id("input-confirm"), "xyz123");
        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//input[@name='newsletter'and@value='1']"));
        //3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@type='checkbox']"));
        //3.11 Click on Continue button
        Thread.sleep(500);
        clickOnElement(By.xpath("//input[@value='Continue'and@class='btn btn-primary']"));
        //3.12 Verify the message “Your Account Has Been Created!”
        assertVerifyText(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"), "Your Account Has Been Created!");
        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        //3.14 Click on My Account Link.
        clickOnElement(By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[1]"));
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter“Logout”
        Thread.sleep(500);
        selectMyAccountOptions("Logout");
        // 3.16 Verify the text “Account Logout”
        assertVerifyText(By.xpath("//h1[contains(text(),'Account Logout')]"), "Account Logout");
        clickOnElement(By.linkText("Logout"));
        //3.17 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {

        // 4.1 Click on My Account Link.// 4.2 Call the method “selectMyAccountOptions” method and pass the parameter“Login”
        selectMyAccountOptions("Login");
        //4.3 Enter Email address
        sendTexTooElement(By.xpath("//input[@id='input-email']"), "xyx288@gmail.com");
        //4.4 Enter Last Name-----not required here
        // 4.5 Enter Password
        sendTexTooElement(By.xpath("//input[@id='input-password']"), "xyz123");
        // 4.6 Click on Login button
        clickOnElement(By.xpath("//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]"));
        // 4.7 Verify text “My Account”
        assertVerifyText(By.xpath("//h2[contains(text(),'My Account')]"), "My Account");
        // 4.8 Click on My Account Link.
        clickOnElement(By.xpath("//a[@class='list-group-item'and@href='http://tutorialsninja.com/demo/index.php?route=account/account']"));
        // 4.9 Call the method “selectMyAccountOptions” method and pass the parameter“Logout”
        selectMyAccountOptions("Logout");
        //4.10 Verify the text “Account Logout”
        Thread.sleep(1000);
        assertVerifyText(By.xpath("//h1[contains(text(),'Account Logout')]"), "Account Logout");
        //clickOnElement(By.linkText("Logout"));
        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }
    @After
    public void tearDown() {
       // closeBrowser();
    }

}
