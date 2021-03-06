package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class FishPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "#Catalog a[href*='SW-01']")
    WebElement angelFishLink;

    public FishPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnAngelFishLink() {
        WaitForElement.waitUntilElementIsClickable(angelFishLink);
        angelFishLink.click();
        logger.info("Clicked on Angel Fish Link");
    }
}
