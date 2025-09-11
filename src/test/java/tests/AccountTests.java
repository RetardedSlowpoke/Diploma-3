package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource; //Справедливо. В какой-то момент в коде был ValueSource, забыл потереть.
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import utility.BaseTest;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountTests extends BaseTest {
    @Test
    @DisplayName("Проверка перехода в личный кабинет") //Очевидно, уже залогиненым пользователем, так что...
    public void accountPageOpenTest(){

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = new AccountPage(driver);

        mainPage.loginMainPageButtonClick();
        loginPage.loginWithCreatedUser(user);

        mainPage.accountButtonClick();

        assertTrue(accountPage.isExitButtonVisible());

    }

    @ParameterizedTest(name = "{0}")
    @CsvSource({
            "Переход через логотип, logo",
            "Переход через кнопку конструктор, constructor"
    })
    @DisplayName("Проверяем переход в конструктор через лого и кнопку конструктора")
    public void goToConstructorTest(String displayName, String clickTarget) {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = new AccountPage(driver);

        mainPage.accountButtonClick();
        loginPage.loginWithCreatedUser(user);
        mainPage.accountButtonClick();

        if (clickTarget.equals("logo")) {
            accountPage.logoClick(); //кликаем по лого
        } else if (clickTarget.equals("constructor")) {
            accountPage.constructorLinkClick(); // по кнопке конструктор
        }


        assertTrue(mainPage.isPlaceOrderButtonVisible(), "Конструктор должен быть виден"); //Опять же, кнопка "оформить заказ" появляется только при успешном логине и только в конструкторе, используем её.
    }
    @Test
    @DisplayName("Проверяем выход из аккаунта")
    public void exitFromAccountTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = new AccountPage(driver);

        mainPage.accountButtonClick();
        loginPage.loginWithCreatedUser(user);
        mainPage.accountButtonClick();
        accountPage.exitButtonClick();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getLoginButton())); //Перекидывает на логин - ищем тамошнюю кнопку войти, значит.


        assertEquals("https://stellarburgers.nomoreparties.site/login", driver.getCurrentUrl(), "Должны оказаться на странице логина");
    }
}
