import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HoverTests {

    WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Piotr\\Desktop\\Studia_podyplomowe_Testowanie\\Kurs_Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl:8095/hovers");
    }

    @Test
    public void hoverTest() {
        WebElement hoverPortrait1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
        WebElement hoverPortrait2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"));
        WebElement hoverPortrait3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"));

        Actions actions = new Actions(driver);

        actions.moveToElement(hoverPortrait1).build().perform();

        WebElement userNameText1 = driver.findElement(By.xpath("//div[1]/div/h5"));
        WebElement userNameText2 = driver.findElement(By.xpath("//div[2]/div/h5"));
        WebElement userNameText3 = driver.findElement(By.xpath("//div[3]/div/h5"));

        assertEquals(userNameText1.getText(), "name: user1");
        assertEquals(userNameText2.getText(), "");
        assertEquals(userNameText3.getText(), "");

        actions.moveToElement(hoverPortrait2).build().perform();

        assertEquals(userNameText1.getText(), "");
        assertEquals(userNameText2.getText(), "name: user2");
        assertEquals(userNameText3.getText(), "");

        actions.moveToElement(hoverPortrait3).build().perform();

        assertEquals(userNameText1.getText(), "");
        assertEquals(userNameText2.getText(), "");
        assertEquals(userNameText3.getText(), "name: user3");
    }


    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
