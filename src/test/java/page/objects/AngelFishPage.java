package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class AngelFishPage {

    @FindBy(css = "a.Button[href$='EST-2']")
    WebElement angelFishAddToCartButton;

    public AngelFishPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnAngelFishAddToCartButton() {
        WaitForElement.waitUntilElementIsClickable(angelFishAddToCartButton);
        angelFishAddToCartButton.click();
    }
}
