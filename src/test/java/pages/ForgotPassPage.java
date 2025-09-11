package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPassPage extends BasePage {

    public ForgotPassPage(WebDriver driver) {
        super(driver);
    }


    private By loginLink = By.xpath("//a[text()='Войти']");



    @Step("Клик на ссылку войти")
    public void loginLinkClick() {
        click(loginLink);
    }
    @Step("Открыть страницу забытого пароля")
    public void open() {
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
    }
}
