package utilities;

import browserfactory.BaseTest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    /*
     * This method click on element
     * */
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();

    }

    /**
     * This method will send text on element
     */
    public void sendTexTooElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
        // WebElement emailField = driver.findElement(by);
        //Type email to email field
        // emailField.sendKeys(text);
    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
        //WebElement actualTextMessageElement = driver.findElement(by);
        //   return actualTextMessageElement.getText();
    }
    public void assertVerifyText(By by, String expectedtext) {
        String actualText = getTextFromElement(by);
        String expectedText = expectedtext;
        Assert.assertEquals("Error has occurred --->  Test failed : ", expectedText, actualText);

    }
    //====================Alertmethods=================
    /*Homework 4 methods--- acceptAlert,dismissAlert,  String getTextFromAlert, sendTextToAlert(String text)
     */
    //this method will switch to alert
    public void switchToAlert() {
        driver.switchTo().alert();
    }
    //acceptAlert
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    //dismissAlert
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
    //String getTextFromAlert
    public String getTextFromAlert(){
        return driver.switchTo().alert().getText();
    }
    //sendTextToAlert(String text)
    public void sendTextToAlert(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    //********************Select class Method***************


    //This method will select option by visible text
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }

    /**
     * This method will select the option by value
     */
    public void selectByValue(By by, String text) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByValue(text);
    }

    /**
     * This method will select the option by index(int)
     */

    public void selectByIndex(By by, int index) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByIndex(index);
    }

    /**
     * This method will select the option by contains text
     */
    public void selectByContainsText(By by, String text1) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        selectByContainsText(by, text1);
    }

    //***************************** Window Handle ************************************


    //***************************** Action Class *************************************
    // mouseHoverToElement(By by)
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        WebElement mouseHoverElement = driver.findElement(by);
        //mouseHoverToElement(by);
        actions.moveToElement(mouseHoverElement).build().perform();

    }
    //mouseHoverToElementAndClick(By by)
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement mouseHoverClick = driver.findElement(by);
        actions.moveToElement(mouseHoverClick).click().build().perform();

    }

}
