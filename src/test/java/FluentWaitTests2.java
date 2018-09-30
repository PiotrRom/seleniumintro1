import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class FluentWaitTests2 {

    WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Piotr\\Desktop\\Studia_podyplomowe_Testowanie\\Kurs_Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl:8095/dynamic_loading/1");
    }

    @Test
    public void fluentWaitWithExceptionTest() {
        WebElement startButton = driver.findElement(By.xpath("//*[@id=\"start\"]/button"));
        WebElement helloWorldText = driver.findElement(By.xpath("//div[@id=\"finish\"]/h4"));

        startButton.click();

        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
        fluentWait
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id=\"finish\"]/h4"), "Hello World!"));

        assertTrue(helloWorldText.isDisplayed());
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
