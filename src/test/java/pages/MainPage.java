package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    //для блока "Вход"

    private By loginMainPageButton = By.xpath("//button[text()='Войти в аккаунт']"); //вход на главной
    private By accountButton = By.xpath("//button[text()='Личный кабинет']"); //личный кабинет

    //для блока "Конструктор"

    private By bunsTab = By.xpath("//span[text()='Булки']");
    private By saucesTab = By.xpath("//span[text()='Соусы']");
    private By fillingsTab = By.xpath("//span[text()='Начинки']");

    //---------------------------------------------------//

    public void loginMainPageButtonClick() {
        click(loginMainPageButton);
    }

    public void accountButtonClick() {
        click(accountButton);
    }

    public void bunsTabClick() {
        click(bunsTab);
    }

    public void saucesTabClick() {
        click(saucesTab);
    }

    public void fillingsTabClick() {
        click(fillingsTab);
    }
}
