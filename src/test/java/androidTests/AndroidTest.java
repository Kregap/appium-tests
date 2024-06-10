package androidTests;

import org.junit.jupiter.api.Test;
import pages.PermissionsPage;
import pages.TabBarPage;

import java.security.Timestamp;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AndroidTest extends BaseTest {

    @Test
    public void testScenario() {
        TabBarPage tabBarPage;
        PermissionsPage permissionsPage = new PermissionsPage(driver);

        permissionsPage.tapAllowLocation();

        restartApp();

        permissionsPage = new PermissionsPage(driver);
        assertTrue(
                permissionsPage.isLocationPermissionsDialogNotDisplayed(),
                "Location permissions dialog was displayed!"
        );

        permissionsPage
                .tapAcceptAppNotifications()
                .tapAcceptSystemNotifications()
                .tapAcceptCookiesButton()
                .tapHideTutorialButton();

        tabBarPage = new TabBarPage(driver);
        long timestamp = System.currentTimeMillis();
        tabBarPage
                .tapAccountTab()
                .tapSignInButton()
                .tapRegisterButton()
                .fillRegistrationForm(
                        "Johny",
                        "White",
                        "my" + timestamp + "@mail.com",
                        "pWd$1" + timestamp
                )
                .tapContinueRegistration()
                .fillRegistrationForm(
                        "Street 12",
                        "12-345",
                        "Sunny" ,
                        "123654123")
                .tapContinueRegistrationButton()
                .tapSkipMachineRegistrationButton()
                .tapConfirmationButton();
    }
}
