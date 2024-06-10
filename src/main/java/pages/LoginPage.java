package pages;

import core.page.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LoginPage extends BasePage {
    private final By registerButton = By.id("com.nespresso.activities:id/tv_register");

    public LoginPage(AppiumDriver driver) {
        super(driver);

        waitForElementToBePresent(registerButton);
        try {
            getElement(registerButton);
        } catch (NoSuchElementException e) {
            throw new IllegalStateException("Login page is not displayed!");
        }
    }

    public RegisterFirstPage tapRegisterButton() {
        getElement(registerButton).click();
        return new RegisterFirstPage(driver);
    }
}
