package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DropDownTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Piotr\\Desktop\\Studia_podyplomowe_Testowanie\\Kurs_Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl:8095/dropdown");
    }

    @Test
    public void dropDownTest() {
        WebElement dropDownWebElement = driver.findElement(By.id("dropdown"));
        Select optionDropDown = new Select(dropDownWebElement);

        assertEquals(optionDropDown.getFirstSelectedOption().getText(), "Please select an option");

        optionDropDown.selectByValue("1");

        assertEquals(optionDropDown.getFirstSelectedOption().getText(), "Option 1");

        optionDropDown.selectByValue("2");

        assertEquals(optionDropDown.getFirstSelectedOption().getText(), "Option 2");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
