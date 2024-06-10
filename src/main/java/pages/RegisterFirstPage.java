package pages;

import core.page.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class RegisterFirstPage extends BasePage {
    private final By titleDropDown = By.xpath("(//android.view.View[@text=\"Title\"])[2]");
    private final By titleMrButton = By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Mr\"]");
    private final By firstNameField = By.xpath("//android.webkit.WebView[@text=\"Register to Nespresso Poland\"]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.widget.EditText");
    private final By lastNameField = By.xpath("//android.webkit.WebView[@text=\"Register to Nespresso Poland\"]/android.view.View/android.view.View/android.view.View[2]/android.view.View[3]/android.view.View/android.widget.EditText");
    private final By emailField = By.xpath("//android.webkit.WebView[@text=\"Register to Nespresso Poland\"]/android.view.View/android.view.View/android.view.View[2]/android.view.View[4]/android.widget.EditText");
    private final By passwordField = By.xpath("//android.webkit.WebView[@text=\"Register to Nespresso Poland\"]/android.view.View/android.view.View/android.view.View[2]/android.view.View[5]/android.widget.EditText");
    private final By continueRegistrationButton = By.xpath("//android.widget.Button[@text=\"Continue registration\"]");

    public RegisterFirstPage(AppiumDriver driver) {
        super(driver);

        waitForElementToBePresent(continueRegistrationButton);
        try {
            getElement(continueRegistrationButton);
        } catch (NoSuchElementException e) {
            throw new IllegalStateException("First registration page is not displayed!");
        }
    }

    public RegisterFirstPage fillRegistrationForm(String firstName, String lastName, String email, String password) {
        getElement(titleDropDown).click();
        waitForElementToBePresent(titleMrButton);
        getElement(titleMrButton).click();

        this.type(getElement(firstNameField), firstName);
        this.type(getElement(lastNameField), lastName);
        this.type(getElement(emailField), email);
        this.type(getElement(passwordField), password);

        return this;
    }

    public RegisterSecondPage tapContinueRegistration() {
        getElement(continueRegistrationButton).click();
        return new RegisterSecondPage(driver);
    }
}
