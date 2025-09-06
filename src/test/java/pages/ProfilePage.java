package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    private By constructorLink = By.xpath("//a[p[text()='Конструктор']]");
    private By logo = By.xpath("//div[contains(@class, 'AppHeader_header__logo__2D0X2')]/a");
    private By exitButton = By.xpath("//button[text()='Выход']");

    public void constructorLinkClick(){
        click(constructorLink);
    }
    public void logoClick(){
        click(logo);
    }
    public void exitButtonClick(){
        click(exitButton);
    }
}
