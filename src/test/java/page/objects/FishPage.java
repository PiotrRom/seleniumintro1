package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FishPage {

    @FindBy(css = "#Catalog a[href*='SW-01']")
    WebElement angelFishLink;

    public FishPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnAngelFishLink() {
        angelFishLink.click();
    }
}
