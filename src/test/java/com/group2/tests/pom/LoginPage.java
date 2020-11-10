package com.group2.tests.pom;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
   // SelenideElement openlogin = $("body.not-logged.b-page_fix_larger-font.b-page_infinity-zen_yes.i-ua.i-bem.b-page.b-page_search-bottom_yes.b-page_services-new-position_before-arrow.i-ua_platform_other.i-ua_js_inited:nth-child(2) div.rows-wrapper:nth-child(3) div.desk-notif__wrapper div.desk-notif.i-bem.desk-notif_js_inited div.desk-notif-card.desk-notif-card_type_login.desk-notif-card_bg_default.desk-notif-card_login_yes.i-bem.desk-notif-card_js_inited:nth-child(1) div.desk-notif-card__card > a.button.desk-notif-card__login-enter-expanded.button_theme_gray.i-bem.button_js_inited");
   // String searchLocator = "//div[@class='main_menu__inner']//i[@class='fa fa-search']";
    // $(By.xpath(searchLocator)).click();
    SelenideElement openlogin = $(By.xpath("//div[@class='desk-notif-card__card']//a[contains(@class,'login-enter')]"));
    //SelenideElement login = $("#passp-field-login");
    SelenideElement login = $(By.xpath("//span[@class='Textinput-Box']"));
    SelenideElement comein =$(By.xpath("//div[@class='passp-login-form']//div[contains(@class,'sign-in-button')]"));
    SelenideElement pass = $(By.xpath("//div[@class='AuthPasswordForm']//span[contains(@class,'Textinput-Box')]"));
    SelenideElement submit = $(By.xpath("//div[@class='AuthPasswordForm']//div[contains(@class,'sign-in-button')]"));
    SelenideElement logoutButton = $("logout");

    SelenideElement writeemail = $(By.xpath("//div[contains(@class,'view-main-action-buttons')]//a[contains(@class,'mail-ComposeButton')]"));
    SelenideElement textbody = $(By.xpath("//div[contains(@class,'PopupCompose')]//div[contains(@class,'composeReact-MBodyPanels')]"));
    SelenideElement emailto = $(By.xpath("//div[contains(@class,'ComposePopup-Body')]//div[contains(@class,'MultipleAddressesDesktop-Field')]"));
    SelenideElement send = $(By.xpath("//div[contains(@class,'ComposePopup-Body')]//div[contains(@class,'ComposeSendButton')]"));

    SelenideElement returnToMessages = $("//a[contains(text(),'Вернуться во \"Входящие\"')]");
    SelenideElement messageToOpen = $(By.xpath("//div[contains(@class, 'ns-view-messages-item-wrap')][2]"));

    public void login(String u, String p) {
        open("https://yandex.by/");
        openlogin.click();
        login.setValue(u);
        comein.click();
        pass.setValue(p);
        submit.click();
    }

    public boolean isLoginPerformedCorrectly() {
        return login.isDisplayed();
    }

    public void sendEmail(String email, String text) {
        writeemail.click();
        emailto.setValue(email);
        textbody.setValue(text);
        send.click();
    }

    public void openEmail() {
        returnToMessages.click();
        messageToOpen.click();
    }

    public void logout(String u, String p) {
        login.setValue(u);
        pass.setValue(p);
        logoutButton.click();
    }
}
