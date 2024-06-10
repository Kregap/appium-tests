package pages;

import core.page.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class RegisterSecondPage extends BasePage {
    private final By addressField = By.xpath("//android.webkit.WebView[@text=\"Address Details\"]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText");
    private final By postalCodeField = By.xpath("//android.webkit.WebView[@text=\"Address Details\"]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[4]/android.view.View/android.widget.EditText");
    private final By cityField = By.xpath("//android.webkit.WebView[@text=\"Address Details\"]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[5]/android.view.View/android.widget.EditText");
    private final By phoneField = By.xpath("//android.webkit.WebView[@text=\"Address Details\"]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[7]/android.view.View[1]/android.widget.EditText");
    private final By continueRegistrationButton = By.xpath("//android.widget.Button[@text=\"Continue registration\"]");

    public RegisterSecondPage(AppiumDriver driver) {
        super(driver);

        waitForElementToBePresent(continueRegistrationButton);
        try {
            getElement(continueRegistrationButton);
        } catch (NoSuchElementException e) {
            throw new IllegalStateException("Second registration page is not displayed!");
        }
    }

    public RegisterSecondPage fillRegistrationForm(
            String address, String postalCode, String city, String phoneNumber
    ) {
        this.type(getElement(addressField), address);
        this.type(getElement(postalCodeField), postalCode);
        this.type(getElement(cityField), city);
        this.type(getElement(phoneField), phoneNumber);

        return this;
    }

    public RegisterThirdPage tapContinueRegistrationButton() {
        getElement(continueRegistrationButton).click();
        return new RegisterThirdPage(driver);
    }
}
