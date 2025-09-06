package pages;

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

    public void emailFieldClick() {
        click(emailField);
    }

    public void passwordFieldClick() {
        click(passwordField);
    }

    public void loginButtonClick() {
        click(loginButton);
    }

    public void registerLinkClick() {
        click(registerLink);
    }

    public void resetPassLinkClick() {
        click(resetPassLink);
    }
}
