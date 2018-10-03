package tests;

import org.testng.annotations.Test;
import page.objects.*;

import static org.testng.Assert.assertEquals;

public class ShoppingCartTests extends TestBase {

    @Test
    public void asNotLoggedUserIShouldNotProceedToCheckout() {

        LandingPage landingPage = new LandingPage();
        landingPage.clickOnEnterStoreLink();

        MainPage mainPage = new MainPage();
        mainPage.goToFishSection();

        FishPage fishPage = new FishPage();
        fishPage.clickOnAngelFishLink();

        AngelFishPage angelFishPage = new AngelFishPage();
        angelFishPage.clickOnAngelFishAddToCartButton();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.clickOnProceedToCheckoutButton();

        LoginPage loginPage = new LoginPage();
        String warningText = loginPage.getWarningMessage();
        assertEquals(warningText, "You must sign on before attempting to check out. Please sign on and try checking out again.");
    }
}
