package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {

    public static WebDriver createDriver(String browserName) {

        WebDriverManager.chromedriver().setup(); // ставим драйвер

        switch (browserName) {
            case "chrome":
                return new ChromeDriver();

            case "yandex":
                ChromeOptions options = new ChromeOptions();
                options.setBinary("C:\\Path\\To\\YandexBrowser\\browser.exe");
                return new ChromeDriver(options);

            default:
                return new ChromeDriver(); //В любой непонятной ситуации запускаем chrome.
        }
    }
}
