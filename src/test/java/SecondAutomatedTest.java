import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SecondAutomatedTest {
        private WebDriver driver;

        @BeforeMethod
        public void beforeTest() {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Piotr\\Desktop\\Studia_podyplomowe_Testowanie\\Kurs_Selenium\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        @Test
        public void mySecondTest() {
            driver.navigate().to("http://www.seleniumhq.org/");

            String pageTitle3 = driver.getTitle();

            assertTrue(pageTitle3.equals("Selenium - Web Browser Automation"));
        }

        @AfterMethod
        public void afterTest() {
            driver.close();
            driver.quit();
        }
    }