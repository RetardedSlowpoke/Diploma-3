package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By emailField = By.name("name");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("//button[text()='Войти']");
    private By registerLink = By.xpath("//a[text()='Зарегистрироваться']");
    private By resetPassLink = By.xpath("//a[text()='Восстановить пароль']");

    @Step("Выбор поля email")
    public void emailFieldClick() {
        click(emailField);
    }

    @Step("Выбор поля пароль")
    public void passwordFieldClick() {
        click(passwordField);
    }

    @Step("Клик на войти")
    public void loginButtonClick() {
        click(loginButton);
    }

    @Step("Клик на ссылку зарегистрироваться")
    public void registerLinkClick() {
        click(registerLink);
    }

    @Step("Клик на ссылку забыл пароль")
    public void resetPassLinkClick() {
        click(resetPassLink);
    }
    @Step("Проверка отображения кнопки Войти")
    public boolean isLoginButtonDisplayed() {
        return isDisplayed(loginButton);
    }
    public By getLoginButton() {
        return loginButton;
    }
}
