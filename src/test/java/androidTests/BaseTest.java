package androidTests;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest {
    protected AndroidDriver driver;
    private static final String appPackage = "com.nespresso.activities";
    private static final String appActivity = "com.nespresso.ui.activity.SplashScreen";

    @BeforeEach
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:appPackage", appPackage);
        capabilities.setCapability("appium:appActivity", appActivity);

        driver = new AndroidDriver(capabilities);

        //TODO: Remove this hack when first start defect is fixed
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.terminateApp(appPackage);
        driver.activateApp(appPackage);
        // end of hack
    }

    @AfterEach
    public void tearDown() {
        // TODO: Remove this hack when first start defect is fixed
        driver.terminateApp(appPackage);

        driver.quit();
    }

    protected void restartApp() {
        driver.terminateApp(appPackage);
        driver.activateApp(appPackage);
    }
}
