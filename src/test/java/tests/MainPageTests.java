package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.MainPage;
import utility.BaseTest;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTests extends BaseTest {

    @Description("Проверяем вкладки конструктора перещёлкикаются верно.")
    @ParameterizedTest(name = "Проверяем переход к разделу {0}")
    @CsvSource({
            "Булки",
            "Соусы",
            "Начинки"
    })
    @DisplayName("Проверяем работу конструктора")
    public void constructorNavigationTest(String section) {
        MainPage mainPage = new MainPage(driver);

        switch (section) {
            case "Булки":
                mainPage.bunsTabClick();
                assertTrue(mainPage.isBunsActive(), "Раздел 'Булки' должен быть активен");
                break;
            case "Соусы":
                mainPage.saucesTabClick();
                assertTrue(mainPage.isSaucesActive(), "Раздел 'Соусы' должен быть активен");
                break;
            case "Начинки":
                mainPage.fillingsTabClick();
                assertTrue(mainPage.isFillingsActive(), "Раздел 'Начинки' должен быть активен");
                break;
            default:
                throw new IllegalArgumentException("Неизвестная вкладка: " + section);
        }
    }

}
