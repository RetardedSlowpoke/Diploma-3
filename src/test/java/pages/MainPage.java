package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    // --- Локаторы ---
    private By loginMainPageButton = By.xpath("//button[text()='Войти в аккаунт']");
    private By accountButton = By.xpath("//button[text()='Личный кабинет']");

    private By bunsTab = By.xpath("//span[text()='Булки']/parent::div");
    private By saucesTab = By.xpath("//span[text()='Соусы']/parent::div");
    private By fillingsTab = By.xpath("//span[text()='Начинки']/parent::div");

    // --- Действия ---
    @Step("Клик на кнопку входа на главной")
    public void loginMainPageButtonClick() {
        click(loginMainPageButton);
    }

    @Step("Клик на кнопку Личный кабинет")
    public void accountButtonClick() {
        click(accountButton);
    }

    @Step("Клик по вкладке Булки и ожидание её активации")
    public void bunsTabClick() {
        driver.findElement(bunsTab).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.attributeContains(bunsTab, "class", "tab_tab_type_current"));
    }

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

    // --- Проверки ---
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

    // --- Геттеры ---
    public By getSaucesTab() {
        return saucesTab;
    }

    public By getBunsTab() {
        return bunsTab;
    }

    public By getFillingsTab() {
        return fillingsTab;
    }
}
