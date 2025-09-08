package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ForgotPassPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;
import utility.BaseTest;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests extends BaseTest {


    @Test
    @DisplayName("Проверяем вход по кнопке на главной")

    public void enterToAccountFromMainPageTests() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.loginMainPageButtonClick();
        loginPage.loginWithCreatedUser(user);

        assertTrue(mainPage.isPlaceOrderButtonVisible(), "Кнопка Оформить заказ должна быть видна");
    }

    @Test
    @DisplayName("Проверяем вход через личный кабинет")

    public void enterToAccountFromAccountButton() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.accountButtonClick();
        loginPage.loginWithCreatedUser(user);

        assertTrue(mainPage.isPlaceOrderButtonVisible(), "Кнопка Оформить заказ должна быть видна");
    }

    @Test
    @DisplayName("Проверяем вход через страницу регистрации")

    public void enterToAccountFromRegistrationPage() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.open();

        registerPage.loginLinkClick();
        loginPage.loginWithCreatedUser(user);

        assertTrue(mainPage.isPlaceOrderButtonVisible(), "Кнопка Оформить заказ должна быть видна");
    }

    @Test
    @DisplayName("Проверяем вход через страницу забытого пароля")

    public void enterToAccountFromForgotPassPage() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ForgotPassPage forgotPassPage = new ForgotPassPage(driver);

        forgotPassPage.open();

        forgotPassPage.loginLinkClick();
        loginPage.loginWithCreatedUser(user);

        assertTrue(mainPage.isPlaceOrderButtonVisible(), "Кнопка Оформить заказ должна быть видна");
    }


}
