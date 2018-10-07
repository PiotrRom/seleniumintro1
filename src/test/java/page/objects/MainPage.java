package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class MainPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "#Banner img[src*='dog']")
    WebElement bannerAfterLoginLogo;

    @FindBy(css = "#QuickLinks a[href*='FISH']")
    WebElement fishUpperButton;

    public MainPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public boolean checkIfDogLogoIsVisible() {
        WaitForElement.waitUntilElementIsVisible(bannerAfterLoginLogo);
        boolean isDisplayed = bannerAfterLoginLogo.isDisplayed();
        logger.info("Returning status of Dog Logo after login: {}", isDisplayed);
        return isDisplayed;
    }

    public void clickOnUpperLinkToFishSection() {
        WaitForElement.waitUntilElementIsClickable(fishUpperButton);
        fishUpperButton.click();
        logger.info("Clicked on upper link to Fish Section");
    }
}
