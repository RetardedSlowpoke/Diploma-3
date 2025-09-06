package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPassPage extends BasePage {

    public ForgotPassPage(WebDriver driver) {
        super(driver);
    }
    private By emailField = By.name("name");
    private By restoreButton = By.xpath("//button[text()='Восстановить']");
    private By loginLink = By.xpath("//a[text()='Войти']");

    public void emailFieldClick() {
        click(emailField);
    }
    public void restoreButtonClick(){
        click(restoreButton);
    }
    public void loginLinkClick(){
        click(loginLink);
    }
}
