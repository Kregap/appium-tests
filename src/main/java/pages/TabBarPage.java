package pages;

import core.page.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class TabBarPage extends BasePage {
    private final By accountTab = By.id("com.nespresso.activities:id/tab_title_account");

    public TabBarPage(AppiumDriver driver) {
        super(driver);
        waitForElementToBePresent(accountTab);
        try {
            getElement(accountTab);
        } catch (NoSuchElementException e) {
            throw new IllegalStateException("Tab bar page is not displayed!");
        }
    }

    public AccountPage tapAccountTab() {
        getElement(accountTab).click();
        return new AccountPage(driver);
    }
}
