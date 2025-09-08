package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage extends BasePage {
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    private By constructorLink = By.xpath("//a[p[text()='Конструктор']]");
    private By logo = By.xpath("//div[contains(@class, 'AppHeader_header__logo__2D0X2')]/a");
    private By exitButton = By.xpath("//button[text()='Выход']");
    @Step("Клик на кнопку Конструктор")
    public void constructorLinkClick(){
        click(constructorLink);
    }
    @Step("Клик на лого")
    public void logoClick(){
        click(logo);
    }
    @Step("Клик на логотип")
    public void exitButtonClick(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(exitButton));
        click(exitButton);
    }
    @Step("Проверяем вошли в аккаунт") //кнопка "выйти" есть только там, вот и посмотрим на неё...
    public boolean isExitButtonVisible(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(exitButton));
        return driver.findElement(exitButton).isDisplayed();
    }
}
