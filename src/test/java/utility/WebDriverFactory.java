package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {

    public static WebDriver createDriver(String browserName) {

        WebDriverManager.chromedriver().driverVersion("138").setup(); // ставим драйвер который точно подойдёт и туда и туда

        switch (browserName) {
            case "chrome":
                return new ChromeDriver();

            case "yandex":
                ChromeOptions options = new ChromeOptions();
                options.setBinary("C:\\Users\\Stange\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe"); //Интересно, насколько корректно оставлять тут __свой__ путь, хм. :thinking:
                return new ChromeDriver(options);

            default:
                return new ChromeDriver(); //В любой непонятной ситуации запускаем chrome.
        }
    }
}
