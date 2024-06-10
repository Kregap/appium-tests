package pages;

import core.page.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class NewsPage extends BasePage {
    private final By hideTutorialButton = By.id("com.nespresso.activities:id/quit_button");
    private final By myMachineButton = By.id("com.nespresso.activities:id/menu_mymachine");

    public NewsPage(AppiumDriver driver) {
        super(driver);

        waitForElementToBePresent(myMachineButton);
        try {
            getElement(myMachineButton);
        } catch (NoSuchElementException e) {
            throw new IllegalStateException("News page is not displayed!");
        }
    }

    public NewsPage tapHideTutorialButton() {
        getElement(hideTutorialButton).click();
        return this;
    }
}
