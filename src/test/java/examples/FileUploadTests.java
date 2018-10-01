package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Piotr\\Desktop\\Studia_podyplomowe_Testowanie\\Kurs_Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl:8095/upload");
    }

    @Test
    public void fileUploadTest() {
        WebElement uploadFilePicker = driver.findElement(By.id("file-upload"));
        WebElement uploadButton = driver.findElement(By.id("file-submit"));

        uploadFilePicker.sendKeys("C:\\Users\\Piotr\\Desktop\\Studia_podyplomowe_Testowanie\\testfile.txt");
        uploadButton.click();

        WebElement resultOfFileUpload = driver.findElement(By.id("uploaded-files"));

        String uploadedNameOfFile = resultOfFileUpload.getText();

        assertEquals(uploadedNameOfFile, "testfile.txt");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
