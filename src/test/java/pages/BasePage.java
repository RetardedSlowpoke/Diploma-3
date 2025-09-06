package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Универсальный клик, а то я с ума начинаю сходить каждый раз прописывая driver.findElement...
    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    // Универсальный ввод текста
    protected void type(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    // Универсальное получение текста элемента
    protected String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    protected boolean isDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }
}
