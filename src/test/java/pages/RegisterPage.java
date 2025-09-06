package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    private By nameField = By.xpath("//label[text()='Имя']/following-sibling::input");
    private By emailField = By.xpath("//label[text()='Email']/following-sibling::input");
    private By passwordField = By.xpath("//label[text()='Пароль']/following-sibling::input");
    private By passwordError = By.xpath("//p[text()='Некорректный пароль']"); //Ошибка с паролем...
    private By registrationButton = By.xpath("//button[text()='Зарегистрироваться']");
    private By loginLink = By.xpath("//a[text()='Войти']"); //Уже зарегистрированы?..

    public void nameFieldClick() {
        click(nameField);
    }

    public void emailFieldClick() {
        click(emailField);
    }

    public void passwordFieldClick() {
        click(passwordField);
    }

    public void registrationButtonClick() {
        click(registrationButton);
    }

    public void loginLinkClick() {
        click(loginLink);
    }

    public void passwordErrorIsDisplayedCheck() { //Проверяем что ошибка видна
        isDisplayed(passwordError);
    }

}

