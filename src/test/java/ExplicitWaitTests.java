import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class ExplicitWaitTests {

    WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Piotr\\Desktop\\Studia_podyplomowe_Testowanie\\Kurs_Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl:8095/dynamic_controls");
    }

    @Test
    public void waitForDisapperingElement() {
        WebElement checkBoxA = driver.findElement(By.id("checkbox"));
        WebElement actionButton = driver.findElement(By.id("btn"));

        assertFalse(checkBoxA.isSelected());
        assertTrue(checkBoxA.isDisplayed());

        actionButton.click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);

        webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("message"), "It's gone!"));

        WebElement messageInfo = driver.findElement(By.id("message"));

        assertTrue(messageInfo.isDisplayed());

        actionButton.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated((By.id("message"))));

        checkBoxA = driver.findElement(By.id("checkbox"));

        assertFalse(checkBoxA.isSelected());
        assertTrue(checkBoxA.isDisplayed());
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
