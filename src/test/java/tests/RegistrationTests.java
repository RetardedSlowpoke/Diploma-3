package tests;


import io.qameta.allure.Description;

import io.qameta.allure.Feature;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.RegisterPage;
import utility.BaseTest;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Регистрация")
public class RegistrationTests extends BaseTest {

    @Test
    @DisplayName("Успешная регистрация нового пользователя через юай")
    @Description("Регистрируем нового пользователя и проверяем, что после этого открывается страница логина") //Несмотря на то, что в задании требуется использовать API для регистрации, этот тест, очевидно, должен стать исключением: регистрацию через API проверяли во втором задании, здесь же мы проверяем что сам пользователь по кнопкам может протыкать (в этом конкретном случае, да).
    public void registerNewUserTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        registerPage.open();



        registerPage.nameFieldClick();
        registerPage.enterRandomName();

        registerPage.emailFieldClick();
        registerPage.enterRandomEmail();

        registerPage.passwordFieldClick();
        registerPage.enterRandomPassword();

        registerPage.registrationButtonClick();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getLoginButton()));


        assertTrue(loginPage.isLoginButtonDisplayed(), "После регистрации не открылась страница логина");
    }

    @Test
    @DisplayName("Отображение ошибки о некорректном пароле")
    @Description("Проверяем, что при вводе пароля менее чем в 6 символов появляется ошибка")
    public void shortPasswordErrorTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.open();



        registerPage.nameFieldClick();
        registerPage.enterRandomName();

        registerPage.emailFieldClick();
        registerPage.enterRandomEmail();

        registerPage.passwordFieldClick();
        driver.findElement(registerPage.getPasswordField()).sendKeys("кошка"); //мяу

        registerPage.registrationButtonClick();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> registerPage.passwordErrorIsDisplayedCheck());

        assertTrue(registerPage.passwordErrorIsDisplayedCheck(), "Ошибка о некорректном пароле не появилась");
    }

}
