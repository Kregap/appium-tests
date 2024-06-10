package pages;

import core.page.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

public class PermissionsPage extends BasePage {
    private final By locationPermissionsDialog = By.id("com.android.permissioncontroller:id/permission_message");
    private final By locationAllowButton = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
    private final By notificationsAppAcceptButton = By.id("android:id/button1");
    private final By notificationsSystemAcceptButton = By.id("com.android.permissioncontroller:id/permission_allow_button");
    private final By acceptCookiesButton = By.id("com.nespresso.activities:id/btn_accept_cookies");

    public PermissionsPage(AppiumDriver driver) {
        super(driver);
    }

    public PermissionsPage tapAllowLocation() {
        waitForElementToBePresent(locationAllowButton);
        getElement(locationAllowButton).click();
        return this;
    }

    public PermissionsPage tapAcceptAppNotifications() {
        waitForElementToBePresent(notificationsAppAcceptButton);
        getElement(notificationsAppAcceptButton).click();
        return this;
    }

    public PermissionsPage tapAcceptSystemNotifications() {
        waitForElementToBePresent(notificationsSystemAcceptButton);
        getElement(notificationsSystemAcceptButton).click();
        return this;
    }

    public NewsPage tapAcceptCookiesButton() {
        waitForElementToBePresent(acceptCookiesButton);
        getElement(acceptCookiesButton).click();
        return new NewsPage(this.driver);
    }

    public boolean isLocationPermissionsDialogNotDisplayed() {
        try {
            waitForElementToBePresent(locationPermissionsDialog);
            WebElement dialog = getElement(locationPermissionsDialog);
            if (dialog.isDisplayed()) {
                return false;
            }
        } catch (TimeoutException e) {
            return true;
        }
        return false;
    }
}
