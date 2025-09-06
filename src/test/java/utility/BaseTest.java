package utility;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver;
    private final String baseUrl = "https://stellarburgers.nomoreparties.site/";

    @BeforeEach
    public void setUp() {
        String browser = System.getProperty("yandex", "chrome");
        driver = WebDriverFactory.createDriver(browser);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
