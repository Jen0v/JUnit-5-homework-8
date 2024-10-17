package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.TextBoxPage;
import tests.TestBase;

import java.util.stream.Stream;

@DisplayName("Тесты регистрации на Text Box")
public class TextBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @ValueSource(strings = {
            "jen@gmail.com",
            "anjen@yandex.ru"
    })
    @ParameterizedTest(name = "Успешная регистрация с email = {0}")
    @Tag("SMOKE")
    void successfulRegistrationWithEmailTest(String Email) {
        textBoxPage.openPage()
                .removeBanner()
                .setName("Anna")
                .setEmail(Email)
                .setCurrentAddress("Some street 1")
                .setPermanentAddress("Another street 1")
                .submit()
                .checkResultName("Anna")
                .checkResultEmail(Email)
                .checkResultCurrentAddress("Some street 1")
                .checkResultPermanentAddress("Another street 1");
    }

    @CsvFileSource(resources = "/test_data/checkAddressResultTest.csv")
    @ParameterizedTest(name = "Успешная регистрация с набором данных: " +
            "firstName = {0}, " +
            "Email = {1}, " +
            "CurrentAddress = {2}, " +
            "PermanentAddress={3} " )
    @Tag("SMOKE")
    void successfulRegistrationOnWithDataSetTest(String Name, String Email, String CurrentAddress, String PermanentAddress) {
        textBoxPage.openPage()
                .removeBanner()
                .setName(Name)
                .setEmail(Email)
                .setCurrentAddress(CurrentAddress)
                .setPermanentAddress(PermanentAddress)
                .submit()
                .checkResultName(Name)
                .checkResultEmail(Email)
                .checkResultCurrentAddress(CurrentAddress)
                .checkResultPermanentAddress(PermanentAddress);
    }
//static Stream<Arguments> negativeRegistrationTest (){
//        return Stream.of()
//}
//    @MethodSource
//    @ParameterizedTest(name = "Негативная проверка" )
//    @Tag("WEB")
//    void negativeRegistrationTest
//            (String Name, String Email, String CurrentAddress, String PermanentAddress) {
//        textBoxPage.openPage()
//                .removeBanner()
//                .setName(Name)
//                .setEmail(Email)
//                .setCurrentAddress(CurrentAddress)
//                .setPermanentAddress(PermanentAddress)
//                .submit()
//                .checkResultName(Name)
//                .checkResultEmail(Email)
//                .checkResultCurrentAddress(CurrentAddress)
//                .checkResultPermanentAddress(PermanentAddress);
//    }

}