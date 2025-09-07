package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPassPage extends BasePage {

    public ForgotPassPage(WebDriver driver) {
        super(driver);
    }

    private By emailField = By.name("name");
    private By restoreButton = By.xpath("//button[text()='Восстановить']");
    private By loginLink = By.xpath("//a[text()='Войти']");

    @Step("Выбор поля email")
    public void emailFieldClick() {
        click(emailField);
    }

    @Step("Клик на кнопку восстановить")
    public void restoreButtonClick() {
        click(restoreButton);
    }

    @Step("Клик на ссылку войти")
    public void loginLinkClick() {
        click(loginLink);
    }
}
