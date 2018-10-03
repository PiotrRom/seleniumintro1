package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(css = "#Banner img[src*='dog']")
    WebElement bannerAfterLoginLogo;

    @FindBy(css = "#QuickLinks a[href*='FISH']")
    WebElement fishUpperButton;

    public MainPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public boolean checkIfDogLogoIsVisible() {
        return bannerAfterLoginLogo.isDisplayed();
    }

    public void goToFishSection() {
        fishUpperButton.click();
    }
}
