package pages;

import core.page.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class RegisterThirdPage extends BasePage {
    private final By skipMachineRegistrationButton = By.xpath("//android.view.View[@content-desc=\"Skip and register next time\"]");

    public RegisterThirdPage(AppiumDriver driver) {
        super(driver);

        waitForElementToBePresent(skipMachineRegistrationButton);
        try {
            getElement(skipMachineRegistrationButton);
        } catch (NoSuchElementException e) {
            throw new IllegalStateException("Third registration page is not displayed!");
        }
    }

    public RegisterSuccessPage tapSkipMachineRegistrationButton() {
        getElement(skipMachineRegistrationButton).click();
        return new RegisterSuccessPage(driver);
    }
}
