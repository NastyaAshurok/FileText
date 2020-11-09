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

    SelenideElement write = $("body.mail-Page-Body.js-mail-Page-Body.Theme.Theme_color_yandex-default.Theme_root_default.pointerfocus:nth-child(2) div.ns-view-app.ns-view-id-52.mail-App.js-mail-App:nth-child(4) div.mail-App-Content.js-mail-app-content div.mail-Layout.js-mail-layout.mail-Layout_2pane.ui-resizable.messages_avatars div.mail-Layout-Inner div.mail-Layout-Aside.js-layout-left.ui-resizable.mail-Layout-Aside_maximum div.ns-view-compose-buttons-box.ns-view-id-64 div.ns-view-main-action-buttons.ns-view-id-235.mail-ComposeButton-Holder div.mail-ComposeButton-Wrap.js-compose-button-container a.mail-ComposeButton.js-main-action-compose > span.mail-ComposeButton-Text");
SelenideElement textbox = $("body.mail-Page-Body.js-mail-Page-Body.Theme.Theme_color_yandex-default.Theme_root_default.pointerfocus:nth-child(2) div.ns-view-app.ns-view-id-52.mail-App.js-mail-App:nth-child(4) div.ns-view-compose-manager-container-box.ns-view-id-72.mail-ComposeManagerContainer_box div.ns-view-compose-manager-container.ns-view-id-238.js-ComposeManagerContainer div.ComposeManager.ComposeManager_hidden.ComposeManager_size_small div.popup2.popup2_view_classic.popup2_theme_normal.popup2_direction_top-center.popup2_nonvisual_yes.popup2_visible_yes.popup2_motionless.popup2_target_position.ComposePopup.ComposePopup_size_small div.ComposePopup-Content div.ComposePopup-Body div.ComposePopup-BodyContent div.composeReact.ComposeManager-PopupCompose:nth-child(1) div.composeReact__inner:nth-child(2) div.composeReact__scrollable-container div.composeReact__scrollable-content div.composeReact__main-content:nth-child(3) div.composeReact-MBodyPanels:nth-child(2) div.ComposeMbodyCKEditor.composeReact__message-body div.cke_1.cke.cke_reset.cke_chrome.cke_editor_editor34.cke_ltr.cke_browser_webkit.mail-Editor.cke_focus:nth-child(2) div.cke_inner.cke_reset div.cke_contents_wrap div.cke_contents.cke_reset > div.cke_wysiwyg_div.cke_reset.cke_enable_context_menu.cke_editable.cke_editable_themed.cke_contents_ltr.cke_htmlplaceholder");

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
    public void sendMessage(String email, String text) {
write.click();
textbox.setValue(text);
    }

    public void logout(String u, String p) {
        login.setValue(u);
        pass.setValue(p);
        logoutButton.click();
    }
}
