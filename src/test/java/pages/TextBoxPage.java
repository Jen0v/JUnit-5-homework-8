package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    private final SelenideElement userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit"),
            resultNameField = $("#output #name"),
            resultEmailField = $("#output #email"),
            resultCurrentAddressField = $("#output #currentAddress"),
            resultPermanentAddressField = $("#output #permanentAddress");


    public TextBoxPage openPage() {
        open("/text-box");
        return this;
    }
    public TextBoxPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setName(String name) {
        userNameInput.setValue(name);
        return this;
    }

    public TextBoxPage setEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    public TextBoxPage setCurrentAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    public TextBoxPage setPermanentAddress(String address) {
        permanentAddressInput.setValue(address);
        return this;
    }

    public TextBoxPage submit() {
        submitButton.click();
        return this;
    }

    public TextBoxPage checkResultName(String name) {
        resultNameField.shouldHave(text(name));
        return this;
    }

    public TextBoxPage checkResultEmail(String email) {
        resultEmailField.shouldHave(text(email));
        return this;
    }

    public TextBoxPage checkResultCurrentAddress(String address) {
        resultCurrentAddressField.shouldHave(text(address));
        return this;
    }

    public TextBoxPage checkResultPermanentAddress(String address) {
        resultPermanentAddressField.shouldHave(text(address));
        return this;
    }


}