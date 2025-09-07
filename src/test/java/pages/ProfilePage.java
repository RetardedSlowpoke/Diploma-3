package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver) {
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
        click(exitButton);
    }
}
