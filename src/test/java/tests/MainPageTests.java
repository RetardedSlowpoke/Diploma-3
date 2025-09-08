package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import utility.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTests extends BaseTest {

    @Test
    @DisplayName("Проверяем работу конструктора")
    @Description("Проверяем вкладки конструктора перещёлкикаются верно.") //Начинаем с "Соусов", потому что "Булки" открыты по-умолчанию.
    public void constructorNavigationTest() {
        MainPage mainPage = new MainPage(driver);

        checkSaucesSection(mainPage);
        checkBunsSection(mainPage);
        checkFillingsSection(mainPage);
    }

    @Step("Проверяем переход к разделу 'Соусы'")
    private void checkSaucesSection(MainPage mainPage) {
        mainPage.saucesTabClick();
        assertTrue(mainPage.isSaucesActive(), "Раздел 'Соусы' должен быть активен");
    }

    @Step("Проверяем переход к разделу 'Булки'")
    private void checkBunsSection(MainPage mainPage) {
        mainPage.bunsTabClick();
        assertTrue(mainPage.isBunsActive(), "Раздел 'Булки' должен быть активен");
    }

    @Step("Проверяем переход к разделу 'Начинки'")
    private void checkFillingsSection(MainPage mainPage) {
        mainPage.fillingsTabClick();
        assertTrue(mainPage.isFillingsActive(), "Раздел 'Начинки' должен быть активен");
    }
}
