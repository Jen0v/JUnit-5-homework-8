package tests;

import data.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import pages.TextBoxPage;



@DisplayName("Тесты для формы Text Box")
public class TextBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();
    @DisplayName("Проверка заполнения поля Full Name")
    @EnumSource (Data.class)
    @ParameterizedTest(name = "Успешное заполнение поля Name {0}")
    @Tag("WEB")
    void checkNameTest (Data data) {
        textBoxPage.openPage()
                .removeBanner()
                .setName(data.getName())
                .submit()
                .checkResultName(data.getName());
    }

    @DisplayName("Проверка заполнения поля Email")
    @ValueSource(strings = {
            "jen@gmail.com",
            "anjen@yandex.ru"
    })
    @ParameterizedTest(name = "Успешное заполнение поля email = {0}")
    @Tag("WEB")
    void checkEmailTest(String email) {
        textBoxPage.openPage()
                .removeBanner()
                .setEmail(email)
                .submit()
                .checkResultEmail(email);
    }

    @DisplayName("Проверка заполнения всех имеющихся полей")
    @CsvFileSource(resources = "/test_data/checkAddressResultTest.csv")
    @ParameterizedTest(name = "Успешное заполнение полей набором данных: " +
            "firstName = {0}, " +
            "Email = {1}, " +
            "CurrentAddress = {2}, " +
            "PermanentAddress={3} " )
    @Tag("SMOKE")
    void checkDataSetTest(String name, String email, String currentAddress, String permanentAddress) {
        textBoxPage.openPage()
                .removeBanner()
                .setName(name)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .submit()
                .checkResultName(name)
                .checkResultEmail(email)
                .checkResultCurrentAddress(currentAddress)
                .checkResultPermanentAddress(permanentAddress);
    }
}