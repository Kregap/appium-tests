package pages;

import core.page.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class AccountPage extends BasePage {
    private final By signInButton = By.id("com.nespresso.activities:id/btn_signin");

    public AccountPage(AppiumDriver driver) {
        super(driver);
        waitForElementToBePresent(signInButton);
        try {
            getElement(signInButton);
        } catch (NoSuchElementException e) {
            throw new IllegalStateException("Account page is not displayed!");
        }
    }

    public LoginPage tapSignInButton() {
        getElement(signInButton).click();
        return new LoginPage(driver);
    }
}
