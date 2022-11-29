package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUP() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
        if (menu == "Desktops") {
            //Find computer tab and click
            mouseHoverToElement(By.linkText("Desktops"));
            clickOnElement(By.linkText("Show All Desktops"));
            //Get title
            String title = driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched: ", "Desktops", title);

        } else if (menu == "Laptops & Notebooks") {
            //Find computer tab and click
            mouseHoverToElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
            clickOnElement(By.linkText("Show All Laptops & Notebooks"));
            //Get title
            String title = driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched: ", "Laptops & Notebooks", title);
        } else if (menu == "Components") {
            //Find computer tab and click
            mouseHoverToElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]"));
            clickOnElement(By.linkText("Show All Components"));
            //Get title
            String title = driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched: ", "Components", title);
        } else {
            System.out.println("Please enter valid Top-menu name or check actual Top-menu name");
        }
    }

    @Test
    public void verifyPageNavigation() {
        selectMenu("Desktops");
        selectMenu("Laptops & Notebooks");
        selectMenu("Components");
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        selectMenu("Desktops");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        selectMenu("Laptops & Notebooks");
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        selectMenu("Components");

    }

    @After
    public void teardown() {
        closeBrowser();
    }

}

