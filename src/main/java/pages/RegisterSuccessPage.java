package pages;

import core.page.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class RegisterSuccessPage extends BasePage {
    private final By confirmRegistrationButton = By.xpath("//android.widget.Button[@text=\"Complete registration\"]");

    public RegisterSuccessPage(AppiumDriver driver) {
        super(driver);

        waitForElementToBePresent(confirmRegistrationButton);
        try {
            getElement(confirmRegistrationButton);
        } catch (NoSuchElementException e) {
            throw new IllegalStateException("Third registration page is not displayed!");
        }
    }

    public AccountPage tapConfirmationButton() {
        getElement(confirmRegistrationButton).click();
        return new AccountPage(driver);
    }
}
