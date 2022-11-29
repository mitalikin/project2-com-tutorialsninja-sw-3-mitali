package desktops;

import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class DesktopsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUP() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //1.1 Mouse hover on Desktops Tab.and click
        mouseHoverToElementAndClick(By.linkText("Desktops"));
        // 1.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));
        //1.3 Select Sort By position "Name: Z to A"
        clickOnElement(By.xpath("//select[@id='input-sort']"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");
        //1.4 Verify the Product will arrange in Descending order.

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //    2.1 Mouse hover on Desktops Tab. and click
        mouseHoverToElementAndClick(By.linkText("Desktops"));
        //   2.2 Click on “Show All Desktops”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));
        //  2.3 Select Sort By position "Name: A to Z"
        clickOnElement(By.xpath("//select[@id='input-sort']"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (A - Z)");
        //  2.4 Select product “HP LP3065”
        Thread.sleep(2000);
        clickOnElement(By.linkText("HP LP3065"));
        // 2.5 Verify the Text "HP LP3065"
        Thread.sleep(2000);
        assertVerifyText(By.xpath("//a[contains(text(),'HP LP3065')]"), "HP LP3065");
        //2.6 Select Delivery Date "2022-11-30"
        Thread.sleep(1000);
        // clickOnElement(By.xpath("//button[@class='btn btn-default'and@xpath='3']"));
        String year = "2022";
        String month = "november";
        String date = "30";
        clickOnElement(By.xpath("//body/div[@id='product-product']/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/span[1]/button[1]/i[1]"));//opens the date picker
        while (true) {
            String monthYear = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[2]")).getText();
            //nov 2022
            String arr[] = monthYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[3]"));
            }
        }
        //Select Date----//div[@id='rb-calendar_onward_cal']//table//td
        List<WebElement> allDates = driver.findElements(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/table[1]/tbody[1]/tr[5]/td[3]"));
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;
            }

        }
        //2.7.Enter Qty "1” using Select class.
        WebElement xyz = driver.findElement(By.id("input-quantity"));
        // Get value attribute with getAttribute()
        String qty = xyz.getAttribute("value");
        // Verify the quantity
        Assert.assertEquals("Error> Quanti mismatch:", "1", qty);

        // 2.8 Click on “Add to Cart” button
        clickOnElement(By.id("button-cart"));
        //x-path----//button[@id='button-cart']
        // 2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        // assertVerifyText(By.xpath("//div[@class='alert alert-success alert-dismissible']"),"Success: You have added HP LP3065 to your shopping cart!");
        // 2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.linkText("shopping cart"));
        // 2.11 Verify the text "Shopping Cart"
        assertVerifyText(By.xpath("//a[text()='Shopping Cart']"), "Shopping Cart");
        // 2.12 Verify the Product name "HP LP3065"
        assertVerifyText(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"), "HP LP3065");
        // 2.13 Verify the Delivery Date "2022-11-30"
        assertVerifyText(By.xpath("//small[contains(text(),'Delivery Date: 2022-11-30')]"), "Delivery Date: 2022-11-30");
        // 2.14 Verify the Model "Product21"
        assertVerifyText(By.xpath("//td[contains(text(),'Product 21')]"), "Product 21");
        //2.15 Verify the Total "£74.73"/$122.00"
        assertVerifyText(By.xpath("//tbody/tr[1]/td[6]"), "$122.00");

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
