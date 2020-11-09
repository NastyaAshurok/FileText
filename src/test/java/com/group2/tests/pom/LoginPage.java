package com.group2.tests.pom;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    SelenideElement openlogin = $("body.not-logged.b-page_fix_larger-font.b-page_infinity-zen_yes.i-ua.i-bem.b-page.b-page_search-bottom_yes.b-page_services-new-position_before-arrow.i-ua_platform_other.i-ua_js_inited:nth-child(2) div.rows-wrapper:nth-child(3) div.desk-notif__wrapper div.desk-notif.i-bem.desk-notif_js_inited div.desk-notif-card.desk-notif-card_type_login.desk-notif-card_bg_default.desk-notif-card_login_yes.i-bem.desk-notif-card_js_inited:nth-child(1) div.desk-notif-card__card > a.button.desk-notif-card__login-enter-expanded.button_theme_gray.i-bem.button_js_inited");
    SelenideElement login = $("#passp-field-login");
    SelenideElement enter = $("#div.layout:nth-child(1) div.passp-flex-wrapper div.passp-page div.passp-flex-wrapper div.passp-content div.passp-auth div.passp-auth-content div.passp-route-forward div.passp-route.passp-route-enter-done div.passp-auth-screen.passp-add-account-page div.passp-add-account-page_has-social-block div.passp-login-form form:nth-child(1) div.passp-button.passp-sign-in-button:nth-child(11) > button.Button2.Button2_size_l.Button2_view_action.Button2_width_max.Button2_type_submit");
    SelenideElement pass = $("#passp-field-passwd");
    SelenideElement submit = $("div.layout:nth-child(1) div.passp-flex-wrapper div.passp-page div.passp-flex-wrapper div.passp-content div.passp-auth div.passp-auth-content div.passp-route-forward div.passp-route.passp-route-enter-done div.passp-auth-screen.passp-welcome-page div.AuthPasswordForm form:nth-child(1) div.passp-button.passp-sign-in-button:nth-child(6) > button.Button2.Button2_size_l.Button2_view_action.Button2_width_max.Button2_type_submit");
    SelenideElement logoutButton = $("logout");

    public void login(String u, String p) {
        open("https://yandex.by/");
        openlogin.click();
        login.setValue(u);
        enter.click();
        pass.setValue(p);
        submit.click();
    }

    public boolean isLoginPerformedCorrectly() {
        return login.isDisplayed();
    }

    public void logout(String u, String p) {
        login.setValue(u);
        pass.setValue(p);
        logoutButton.click();
    }
}
