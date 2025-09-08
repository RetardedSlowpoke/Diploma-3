package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pojo.User;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By emailField = By.name("name");
    private By passwordField = By.name("Пароль");
    private By loginButton = By.xpath("//button[text()='Войти']");

    @Step("Выбор поля email")
    public void emailFieldClick() {
        click(emailField);
    }

    @Step("Выбор поля пароль")
    public void passwordFieldClick() {
        click(passwordField);
    }

    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Клик на войти")
    public void loginButtonClick() {
        click(loginButton);
    }


    @Step("Проверка отображения кнопки Войти")
    public boolean isLoginButtonDisplayed() {
        return isDisplayed(loginButton);
    }
    public By getLoginButton() {
        return loginButton;
    }
    @Step("Входим с пользователем созданным через api")
    public void loginWithCreatedUser(User user){
        emailFieldClick();
        setEmail(user.getEmail());
        passwordFieldClick();
        setPassword(user.getPassword());
        loginButtonClick();
    }
}
