package laptopsandnotebooks;

import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUP() {
        openBrowser(baseUrl);
    }


    @Test
    public void TestNameVerifyProductsPriceDisplayHighToLowSuccessfully() {
        //  1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverToElementAndClick(By.xpath("//a[text()='Laptops & Notebooks']"));
        //1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));
        //1.3 Select Sort By "Price (High > Low)"
        clickOnElement(By.xpath("//select[@id='input-sort']"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        //1.4 Verify the Product price will arrange in High to Low order.
        boolean isInventoryDisplayByOrder = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]")).isDisplayed();
        System.out.println("products are Displayed:" + isInventoryDisplayByOrder);
        // String veryFyProductPrice="Laptops & Notebooks";
        //String ProductDisplayInOrder=getTextFromElement(By.xpath("//div[@id='content']"));
        // Assert.assertEquals("Products are not in sory in orderby high to low ",veryFyProductPrice,ProductDisplayInOrder);
    }

    @Test
    public void TestNameVerifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverToElementAndClick(By.xpath("//a[text()='Laptops & Notebooks']"));
        //2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));
        //2.3 Select Sort By "Price (High > Low)"
        clickOnElement(By.xpath("//select[@id='input-sort']"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        //2.4 Select Product “MacBook”
        Thread.sleep(2000);
        clickOnElement(By.linkText("MacBook"));

        //2.5 Verify the text “MacBook”
        assertVerifyText(By.xpath("//h1[contains(text(),'MacBook')]"), "MacBook");

        // 2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        //assertVerifyText(By.xpath("//body/div[@id='product-product']/div[1]"),"Success: You have added MacBook to your shopping cart!");
        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //2.9 Verify the text "Shopping Cart"
        Thread.sleep(1000);
        assertVerifyText(By.xpath("//h1[contains(text(),' (0.00kg)')]"), "Shopping Cart  (0.00kg)");

        //2.10 Verify the Product name "MacBook"
        Thread.sleep(1000);
        assertVerifyText(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"), "MacBook");
        //2.11 Change Quantity "2"
        clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"));
        driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]")).clear();
        sendTexTooElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"), "2");
        //2.12 Click on “Update”Tab
        clickOnElement(By.xpath("//i[@class='fa fa-refresh']"));
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        Thread.sleep(1000);
        //assertVerifyText(By.xpath("/html[1]/body[1]/div[2]/div[1]/i[1]"),"Success: You have modified your shopping cart!");
        //2.14 Verify the Total £737.45//$1,204.00
        assertVerifyText(By.xpath("//tbody/tr[1]/td[6]"), "$1,204.00");
        //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));
        //2.16 Verify the text “Checkout”
        assertVerifyText(By.xpath("//a[contains(text(),'Checkout')]"), "Checkout");
        //2.17 Verify the Text “New Customer”
        assertVerifyText(By.xpath("//h2[contains(text(),'New Customer')]"), "New Customer");
        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));
        //2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));
        //2.20 Fill the mandatory fields
        sendTexTooElement(By.id("input-payment-firstname"), "Clair");
        sendTexTooElement(By.id("input-payment-lastname"), "white");
        sendTexTooElement(By.id("input-payment-email"), "abc123@gmail.com");
        sendTexTooElement(By.id("input-payment-telephone"), "07687654323");
        sendTexTooElement(By.id("input-payment-address-1"), "8 hill Rd");
        sendTexTooElement(By.id("input-payment-city"), "London");
        sendTexTooElement(By.id("input-payment-postcode"), "wd14 7tr");
        clickOnElement(By.id("input-payment-country"));
        clickOnElement(By.xpath("//option[contains(text(),'United Kingdom')]"));
        clickOnElement(By.id("input-payment-zone"));
        clickOnElement(By.xpath("//option[contains(text(),'Greater London')]"));
        //2.21 Click on “Continue” Button
        clickOnElement(By.id("button-guest"));
        // 2.22 Add Comments About your order into text area
        sendTexTooElement(By.xpath("//textarea[@class='form-control']"), "satisfied with product and service");
        // 2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@type='checkbox'and@name='agree']"));
        //2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));
        //2.25 Verify the message “Warning: Payment method required
        assertVerifyText(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]"), "Warning: No Payment options are available. Please contact us for assistance!");

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
