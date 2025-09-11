package pages;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegisterPage extends BasePage {

    private Faker faker = new Faker();

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    private By nameField = By.xpath("//label[text()='Имя']/following-sibling::input");
    private By emailField = By.xpath("//label[text()='Email']/following-sibling::input");



    private By passwordField = By.xpath("//label[text()='Пароль']/following-sibling::input");
    private By passwordError = By.xpath("//p[text()='Некорректный пароль']"); //Ошибка с паролем...
    private By registrationButton = By.xpath("//button[text()='Зарегистрироваться']");
    private By loginLink = By.xpath("//a[text()='Войти']"); //Уже зарегистрированы?..

    @Step("Выбор поля имя")
    public void nameFieldClick() {
        click(nameField);
    }

    @Step("Выбор поля Email")
    public void emailFieldClick() {
        click(emailField);
    }

    @Step("Выбор поля пароль")
    public void passwordFieldClick() {
        click(passwordField);
    }

    @Step("Клик на кнопку зарегистрироваться")
    public void registrationButtonClick() {
        click(registrationButton);
    }

    @Step("Клик на ссылку войти")
    public void loginLinkClick() {
        click(loginLink);
    }

    @Step("Проверка видимости ошибки о некорректном пароле")
    public boolean passwordErrorIsDisplayedCheck() { //Проверяем что ошибка видна
        return isDisplayed(passwordError);
    }

    @Step("Ввод случайного имени")   //Нужно один раз - для проведения регистрации руками
    public String enterRandomName() {
        String name = faker.name().firstName();
        type(nameField, name);
        return name;
    }

    @Step("Ввод случайного email")
    public String enterRandomEmail() {
        String email = faker.internet().emailAddress();
        type(emailField, email);
        return email;
    }

    @Step("Ввод случайного пароля")
    public String enterRandomPassword() {
        String password = faker.internet().password(6, 12);
        type(passwordField, password);
        return password;
    }
    @Step("Открыть страницу регистрации")
    public void open() {
        driver.get("https://stellarburgers.nomoreparties.site/register");
    }
    public By getPasswordField() {
        return passwordField;
    }

}



