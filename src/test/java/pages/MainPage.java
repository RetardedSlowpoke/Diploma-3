package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private By loginMainPageButton = By.xpath("//button[text()='Войти в аккаунт']");
    private By accountButton = By.xpath("//a[p[text()='Личный Кабинет']]"); //вообще это скорее ссылка, а не кнопка, но уже слишком поздно.
    private By placeOrderButton = By.xpath("//button[text()='Оформить заказ']"); //"Войти" после логина заменяется на эту кнопку, так и проверим вход.

    private By bunsTab = By.xpath("//div[span[text()='Булки']]"); //А тут другой локатор был нужен если со старта её искать... Заняло время.
    private By saucesTab = By.xpath("//span[text()='Соусы']/parent::div");
    private By fillingsTab = By.xpath("//span[text()='Начинки']/parent::div");


    @Step("Клик на кнопку входа на главной")
    public void loginMainPageButtonClick() {
        click(loginMainPageButton);
    }

    @Step("Клик на кнопку Личный кабинет")
    public void accountButtonClick() {
        click(accountButton);
    }

    @Step("Клик по вкладке Булки")
    public void bunsTabClick() {
        WebElement buns = driver.findElement(bunsTab);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buns); //Из-за того что вкладка открыта по-умолчанию, она, кажется, перекрывается родительским <div>, но в задании же прямо указано, что надо кликать...
    }                                    //Вот и кликаем, как можем. ._. Да и правильнее это, думается.
                                        //Здесь ничего не ждём - всё уже есть.

    @Step("Клик по вкладке Соусы и ожидание её активации")
    public void saucesTabClick() {
        driver.findElement(saucesTab).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.attributeContains(saucesTab, "class", "tab_tab_type_current"));
    }

    @Step("Клик по вкладке Начинки и ожидание её активации")
    public void fillingsTabClick() {
        driver.findElement(fillingsTab).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.attributeContains(fillingsTab, "class", "tab_tab_type_current"));
    }


    @Step("Проверяем что вкладка Булки активна")
    public boolean isBunsActive() {
    return driver.findElement(bunsTab).getAttribute("class").contains("tab_tab_type_current");
    }

    @Step("Проверяем что вкладка Соусы активна")
    public boolean isSaucesActive() {
        return driver.findElement(saucesTab).getAttribute("class").contains("tab_tab_type_current");
    }

    @Step("Проверяем что вкладка Начинки активна")
    public boolean isFillingsActive() {
        return driver.findElement(fillingsTab).getAttribute("class").contains("tab_tab_type_current");
    }
    @Step("Проверяем что вход в аккаунт успешен (кнопка войти заменилась на оформить заказ)")
    public boolean isPlaceOrderButtonVisible(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(placeOrderButton));
        return driver.findElement(placeOrderButton).isDisplayed();
    }
    @Step("Проверяем что выход из аккаунта успешен)") //и опять появилась кнопка "войти"
    public boolean isLoginMainPageButtonVisible(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(loginMainPageButton));
        return driver.findElement(loginMainPageButton).isDisplayed();
    }

}
