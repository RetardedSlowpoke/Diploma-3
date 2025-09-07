package utility;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;
import pojo.User;

public class BaseTest {

    protected WebDriver driver;
    private final String baseUrl = "https://stellarburgers.nomoreparties.site/";
    protected User user;
    private API api;

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        String browser = System.getProperty("yandex", "chrome");
        driver = WebDriverFactory.createDriver(browser);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        api = new API(baseUrl);

        String testName = testInfo.getDisplayName();
        if (!testName.equals("shortPasswordErrorTest") && !testName.equals("registerNewUserTest")) {
            user = api.createUser();
        }
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        String testName = testInfo.getDisplayName();
        if (!testName.equals("shortPasswordErrorTest") && !testName.equals("registerNewUserTest")) {
            if (user != null && user.getAccessToken() != null) {
                api.deleteUser(user.getAccessToken());
            }
        }

        if (driver != null) {
            driver.quit();
        }
    }
}